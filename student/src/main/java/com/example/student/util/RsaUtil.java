package com.example.student.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://blog.csdn.net/qy20115549/article/details/83105736
 * @description: RsaUtil
 * @date: 2021/3/18 下午5:09
 * @author: zcy
 * @version: 1.0
 */
public class RsaUtil {
    private static Map<Integer, String> keyMap = new HashMap<Integer, String>(16);

    public static void main(String[] args) throws Exception {
        //生成公钥和私钥
        genKeyPair();
        //加密字符串
        String message = "df723820";
        System.out.println("生成的随机公钥：" + keyMap.get(0));
        System.out.println("生成的随机秘钥：" + keyMap.get(1));
        String messageEn = encrypt(message, keyMap.get(0));
        System.out.println(message + "\t加密的字符串为：" + messageEn);
        String messageDe = decrypt(messageEn, keyMap.get(1));
        System.out.println("还原后的字符串为：" + messageDe);

    }

    /**
     * 使用RSA一般需要产生公钥和私钥，当采用公钥加密时，使用私钥解密，采用私钥加密时，需要公钥解密
     * 随机生成秘钥对
     * @throws NoSuchAlgorithmException
     */
    public static void genKeyPair()throws NoSuchAlgorithmException{
        // keyPairGenerator 类用于生成公钥和私钥对，基于RSA 算法生成对象
        KeyPairGenerator rsa = KeyPairGenerator.getInstance("RSA");
        //初始化秘钥对生成器，秘钥大小为512-1024
        rsa.initialize(512,new SecureRandom());
        //生成一个秘钥对，保存在keyPair中
        KeyPair keyPair = rsa.generateKeyPair();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        String publicKeyStr = new String(Base64.encodeBase64(publicKey.getEncoded()));
        //获取
        String privateKeyStr = new String(Base64.encodeBase64(privateKey.getEncoded()));
        //将公钥和私钥保存到Map
        keyMap.put(0,publicKeyStr);
        keyMap.put(1,privateKeyStr);
    }

    /**
     *  RSA 公钥加密
     * @param str  加密字符串
     * @param publicKey 公钥
     * @return 密文
     * @throws Exception
     */
    public static String encrypt(String str,String publicKey) throws Exception{
        byte[] decoded = Base64.decodeBase64(publicKey);
        PublicKey pubKey = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
        //RSA加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE,pubKey);
        return Base64.encodeBase64String(cipher.doFinal(str.getBytes(StandardCharsets.UTF_8)));
    }

    /**
     * RSA私钥解密
     * @param str 加密字符串
     * @param privateKey 秘钥
     * @return 铭文
     * @throws Exception
     */
    public static String decrypt(String str,String privateKey) throws Exception{
        //64位解码加密后的字符串
        byte[] inputByte = Base64.decodeBase64(str.getBytes(StandardCharsets.UTF_8));
        //64位解码加密后的字符串
        byte[] decoded = Base64.decodeBase64(privateKey);
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
        //RSA解密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE,priKey);
        return new String(cipher.doFinal(inputByte));
    }
}
