package com.example.socket.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * @description: MultiplexerTimeServer
 * @date: 2023/9/14 下午5:14
 * @author: zcy
 * @version: 1.0
 */
public class MultiplexerTimeServer implements Runnable {
    private Selector selector;
    private ServerSocketChannel servChannel;
    private volatile boolean stop;


    /**
     *
     * @param port 端口
     * @param maxQueueSize 连接最大队列长度
     */
    public MultiplexerTimeServer(int port,int maxQueueSize){
        try {
            this.selector = Selector.open();
            this.servChannel = ServerSocketChannel.open();
            this.servChannel.configureBlocking(false);
            this.servChannel.socket().bind(new InetSocketAddress(port),maxQueueSize);
            this.servChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("The time server is start in port : " + port);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void stop(){
        this.stop = true;
    }

    /**
     * while 循环体中循环遍历 selector，它的休眠时间为1s。
     * 无论是否有读写等事件发生，selector 每隔 1s 都被唤醒一次。
     * selector 也提供了一个无参的 select 方法：当有处于就绪状态的 Channel 时，
     * selector 将返回该 Channel 的 SelectionKey 集合。
     * 通过对就绪状态的 Channel 集合进行迭代，可以进行网络的异步读写操作。
     */
    @Override
    public void run() {
        while (!stop) {
            try {
                this.selector.select(1000);
                Set<SelectionKey> selectionKeys = this.selector.selectedKeys();
                Iterator<SelectionKey> it = selectionKeys.iterator();
                SelectionKey key  = null;
                while (it.hasNext()){
                    key = it.next();
                    it.remove();
                    try {
                        handleInput(key);
                    } catch (IOException e) {
                        if(key != null){
                            key.cancel();
                            if(key.channel() != null){
                                key.channel().close();
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();

            }
        }
        //多路复用器关闭后，所有注册在上面的channel和Pipe等资源都会被自动去注册并关闭
        //所以不需要中辅释放资源
        if(this.selector != null){
            try {
                this.selector.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 处理新接入的客户端请求消息，根据 SelectionKey 的操作位进行判断即可获知网络事件的类型，
     * 通过 ServerSocketChannel 的 accept 接收客户端的连接请求并创建 SocketChannel实例。
     * 完成上述操作后，相当于完成了 TCP 的三次握手，TCP物理链路正式建立。
     * 注意，我们需要将新创建的 SocketChannel 设置为异步非阻寨，
     * 同时也可以对其 TCP 参数进行设置，例如 TCP 接收和发送缓冲区的大小等。
     * 但作为入门的例子，以上例程没有进行额外的参数设置。
     *
     */
    private void handleInput(SelectionKey key) throws IOException {
        if(key.isValid()){
            //处理新接入的请求消息
            if(key.isAcceptable()){
                // Accept the new connection
                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                SocketChannel sc = ssc.accept();
                sc.configureBlocking(false);
                //Add the new connection to the selector
                sc.register(this.selector,SelectionKey.OP_READ);
            }
            if(key.isReadable()){
                // Read the data
                SocketChannel sc = (SocketChannel) key.channel();
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                //读取请求码流
                int readBytes = sc.read(readBuffer);
                if(readBytes > 0){
                    //flip()的作用是将缓冲区当前的limit设置为position,position设置为0，
                    // 用于后续对缓冲去的读取操作
                    readBuffer.flip();
                    //根据缓冲区可读字节个数创建字节数组
                    byte[] bytes = new byte[readBuffer.remaining()];
                    //将缓冲区可读字节数组复制到新创建的字节数组总
                    readBuffer.get(bytes);
                    String body = new String(bytes, StandardCharsets.UTF_8);
                    System.out.println("The time server receive order : " + body);
                    String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ?
                            new Date(System.currentTimeMillis()).toString() :
                            "BAD ORDER";
                    doWrite(sc,currentTime);
                }else if(readBytes < 0){
                    //对端链路关闭
                    key.cancel();;
                    sc.close();
                }//读到0字节忽略
            }
        }
    }

    private void doWrite(SocketChannel channel,String response) throws IOException{
        if(response != null && response.trim().length()>0){
            byte[] bytes = response.getBytes();
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            //将缓字节数组复制到缓冲区
            writeBuffer.put(bytes);
            writeBuffer.flip();
            channel.write(writeBuffer);
        }
    }
}
