package com.example.magnet;
import com.frostwire.jlibtorrent.*;
import com.frostwire.jlibtorrent.alerts.Alert;
import com.frostwire.jlibtorrent.alerts.AlertType;

import java.io.BufferedInputStream;
import java.io.File;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.CountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description: MagnetLinkDownloader
 * @date: 2023/11/14 下午8:44
 * @author: zcy
 * @version: 1.0
 */
public class MagnetLinkDownloader {
    public static void main(String[] args) {
        String magnetLink = "magnet:?xt=urn:btih:5A40C5B4B21AF943A6ED03D0D05F080EA85C49E7&dn=example.torrent";
        String savePath = "/path/to/save/file.torrent";

        // 解析磁力链
        String pattern = "magnet:\\?xt=urn:btih:([A-F0-9]+)&dn=([A-Za-z0-9.]+)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(magnetLink);

        if (m.find()) {
            String hash = m.group(1);
            String fileName = m.group(2);

            // 下载文件
            String fileUrl = "" + fileName;
            System.out.println(hash);
            /*try {
                URL url = new URL(fileUrl);
                URLConnection connection = url.openConnection();

                BufferedInputStream in = new BufferedInputStream(connection.getInputStream());
                FileOutputStream out = new FileOutputStream(savePath);

                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }

                out.close();
                in.close();

                System.out.println("File downloaded successfully");
            } catch (IOException e) {
                e.printStackTrace();
            }*/
        } else {
            System.out.println("Invalid magnet link");
        }
    }


}
