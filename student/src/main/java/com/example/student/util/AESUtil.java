package com.example.student.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AESUtil {

    public static final Charset CHARSET = StandardCharsets.UTF_8;
    public static final String ALGORITHMS_MD5 = "MD5";
    public static final String SHA = "SHA1PRNG";

    public static final String ALGORITHM = "AES";

    /**
     * 加密
     *
     * @param content  需要加密的内容
     * @param password 加密密码
     * @return
     */
    public static byte[] encrypt(String content, String password) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance(ALGORITHM);
            SecureRandom random = SecureRandom.getInstance(SHA);
            random.setSeed(password.getBytes());
            kgen.init(128, random);
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);// 创建密码器
            byte[] byteContent = content.getBytes(CHARSET);
            cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
            return cipher.doFinal(byteContent); // 加密
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密
     *
     * @param content  待解密内容
     * @param password 解密密钥
     * @return
     */
    public static byte[] decrypt(byte[] content, String password) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance(ALGORITHM);
            SecureRandom random = SecureRandom.getInstance(SHA);
            random.setSeed(password.getBytes());
            kgen.init(128, random);
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);// 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
            return cipher.doFinal(content); // 加密
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将二进制转换成16进制
     *
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 将16进制转换为二进制
     *
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    private static byte[] doSign(String algorithms, String inputStr) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(algorithms);
        messageDigest.update(inputStr.getBytes(CHARSET));
        return messageDigest.digest();
    }

    private static String signToHexStr(String algorithms, String inputStr) {
        try {
            return parseByte2HexStr(doSign(algorithms, inputStr));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String sign(String key, String sourceStr) {
        String md5Str1 = signToHexStr(ALGORITHMS_MD5, sourceStr);
        String sourceStr2 = md5Str1 + key;
        return signToHexStr(ALGORITHMS_MD5, sourceStr2);
    }

    public static String toDecryptParam(String sourceStr, String password) {
        try {
            byte[] sourceByte = parseHexStr2Byte(sourceStr);
            byte[] bytes = decrypt(sourceByte, password);
            return new String(bytes, CHARSET);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String toEncryptResult(Object sourceStr, String password) {
        String parameterJson = JSONObject.toJSONString(sourceStr);
        byte[] encode = encrypt(parameterJson, password);
        return parseByte2HexStr(encode);
    }

    public static String encryptAES(String content, String password) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            byte[] byteContent = content.getBytes("utf-8");
            cipher.init(1, getSecretKey(password));
            byte[] result = cipher.doFinal(byteContent);
            return Base64.encodeBase64String(result);
        } catch (Exception var5) {
            return null;
        }
    }

    public static String decryptAES(String content, String password) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(2, getSecretKey(password));
            byte[] result = cipher.doFinal(Base64.decodeBase64(content));
            return new String(result, "utf-8");
        } catch (Exception var4) {
            return null;
        }
    }

    private static SecretKeySpec getSecretKey(String password) {
        KeyGenerator kg = null;

        try {
            kg = KeyGenerator.getInstance("AES");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(password.getBytes());
            kg.init(128, random);
            SecretKey secretKey = kg.generateKey();
            return new SecretKeySpec(secretKey.getEncoded(), "AES");
        } catch (NoSuchAlgorithmException var4) {
            return null;
        }
    }

    public static void main(String[] args) {
        String password = "ajkjkjdjfdkjfkdjfkdjweieupqz/mmokoe";
        String context = "weppppqejejrjejrekjwkjrkwjekrjewkejkewjkjkqjwekjrkwjrkwjekrjwekq,m,ml\"ddd\"dfjdkfjkasj;fjasd;jfqiepuqwerqpuup:";
        byte[] encrypt = encrypt(context, password);
        System.out.println(JSONObject.toJSONString(encrypt));
        byte[] decrypt = decrypt(encrypt, password);
        System.out.println(new String(decrypt));
    }
}