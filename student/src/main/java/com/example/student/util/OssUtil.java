package com.example.student.util;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

@Slf4j
public class OssUtil {

    private static OSSClient ossClient;
    private static final String ossEndpoint = "http://oss-cn-beijing.aliyuncs.com";
    private static final String ossBucket = "";
    private static final String ossAccessKeyId = "";
    private static final String ossAccessKeySecret = "";
    private static final String ossBaseDir = "";

    private static final long MIN_IMAGE_SIZE = 1024L;

    private static final String cdnUrl = "https://自己项目的cdn/";

    static {
        ossClient = new OSSClient(ossEndpoint, ossAccessKeyId, ossAccessKeySecret);
    }


    public static long getRemoteImgSize(String imgUrl) {
        try {
            URL url = new URL(imgUrl);
            URLConnection conn = url.openConnection();
            conn.setConnectTimeout(60 * 1000);
            conn.setReadTimeout(60 * 1000);
            long imgSize = conn.getContentLength();
            if(imgSize >= MIN_IMAGE_SIZE ) {
                InputStream is = conn.getInputStream();
                BufferedImage image = ImageIO.read(is);
                int srcWidth = image.getWidth();      // 源图宽度
                int srcHeight = image.getHeight();    // 源图高度
                System.out.println(StringUtils.substringAfterLast(imgUrl, "/")  + ", size = " + srcWidth + "x" + srcHeight);
                is.close();
            }else {
                log.error("read img size result, imgUrl:{}, content:{}", imgUrl, ((HttpURLConnection) conn).getResponseMessage());
            }
            return imgSize;
        } catch (IOException e) {
            log.error("read img size err, imgUrl:{}", imgUrl, e);
        }
        return 0L;
    }

    /**
     * 根据文件
     * @param url
     * @param filename
     * @return
     * @throws IOException
     */
    public static String saveUrl2Oss(String url, boolean isMp4, String filename) throws IOException {
        //文件名
        String key = ossBaseDir + DateTimeUtils.getDailyVersion() + "/" + (isMp4 ? "mp4" : "img") + "/" + filename;
        // 建立链接
        URL httpUrl = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) httpUrl.openConnection();
        conn.setDoInput(true);
        conn.setDoOutput(true);
        // post方式不能使用缓存
        conn.setUseCaches(false);
        //连接指定的资源
        conn.connect();
        //获取网络输入流
        InputStream inputStream = conn.getInputStream();
        ossClient.putObject(new PutObjectRequest(ossBucket, key, inputStream));
        conn.disconnect();
        return cdnUrl + key;
    }
}
