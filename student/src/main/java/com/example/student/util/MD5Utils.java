package com.example.student.util;

import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by liuliandong on 2016/10/24.
 */

public class MD5Utils {

    private static Logger logger = LoggerFactory.getLogger(MD5Utils.class);


    public static String getMd5Sum(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.reset();
            byte[] buf = input.getBytes();
            md.update(buf);
            byte[] digest = md.digest();
            String result = new String(Hex.encodeHex(digest));
            md.reset();
            return result;
        } catch (NoSuchAlgorithmException e) {
            logger.error("MD5Utils esrror:", e);
            return "";
        }
    }
}
