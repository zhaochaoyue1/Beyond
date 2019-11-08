package com.example.student.Test;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;

import static com.example.student.Test.SignManager.getSimpleDay;

public class TestClass {
    private static final int INTERVAL = 59;
    public static void main(String[] args) {
        /*long mill = System.currentTimeMillis();
        int i = ((Long) ((mill + 1000 * 60 * 60 * 8) / DateUtils.MILLIS_PER_DAY)).intValue();
        System.out.println(i);*/
        SignModel signModel = new SignModel();
        // 只有当 fromDate 距离今天超过 60 天时才需要进行重置
        Integer currentDate = getSimpleDay(System.currentTimeMillis());
        Integer days = currentDate - signModel.getFromDate();
        Integer needMovedDays = days - INTERVAL;
        if (needMovedDays > 0 && needMovedDays <= INTERVAL) {
            for (int i = 1; i <= needMovedDays; i++) {
                String bitStr = get64BitString(signModel.getStatus());
                // 每天向右移一位
                if (bitStr.charAt(i - 1) == '1') { // 签到了
                    signModel.setCount(signModel.getCount() + 1);
                } else { // 没签到
                    signModel.setCount(0);
                }
                signModel.setFromDate(signModel.getFromDate() + 1);
                signModel.setStatus(signModel.getStatus() << 1);
            }
        } else if (needMovedDays >= INTERVAL) {
            signModel.setStatus(0L);
            signModel.setCount(0);
            signModel.setFromDate(currentDate - INTERVAL);
        }
        Date date = new Date();
        Integer signDay = getSimpleDay(date.getTime());
        Integer index = signDay - signModel.getFromDate();
        long l1 = 1L << (63 - index);
        long l = signModel.getStatus() | l1 ;
        signModel.setStatus(signModel.getStatus() | (1L << (63 - index)));
        System.out.println(JSON.toJSONString(signModel));
    }
    /**
     * 将 Long 补全为长度为 64 的字符串
     **/
    public static String get64BitString(Long status) {
        String statusStr = Long.toBinaryString(status);
        StringBuffer sb = new StringBuffer();
        for (int i = 64; i > statusStr.length(); i--) {
            sb.append("0");
        }
        sb.append(statusStr);
        return sb.toString();
    }
}
