package com.example.student.Test;

import com.alibaba.fastjson.JSONObject;

public class Video {
    public static void main(String[] args) {
        //领取次数
        int group = 5;
        //冷缺次数
        int coolingNum = 8;
        //再看视频数
        int againLookNum = 10;
        //一次周期数
        int onePeriodNum = coolingNum + againLookNum;
        //总共观看的次数
        int countNum = onePeriodNum * group;
        int[] a = new int[countNum];
        //循环次数
        for (int i = 0; i < group; i++) {
            for (int j = 1; j <= onePeriodNum; j++) {
                int k = j % onePeriodNum;
                if (k == 0) {
                    a[(i + 1) * onePeriodNum-1] = 2;
                } else {
                    int index = i * onePeriodNum + k - 1;
                    if (k <= coolingNum) {
                        a[index] = 0;
                    } else {
                        a[index] = 1;
                    }
                }
            }
        }
        System.out.println(JSONObject.toJSONString(a));

    }
}
