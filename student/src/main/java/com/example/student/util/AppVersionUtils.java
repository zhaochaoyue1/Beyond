package com.example.student.util;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * Created by liubin on 2014/12/10.
 */
public class AppVersionUtils implements Serializable {

    private static final long serialVersionUID = -3783642119393263228L;

    /**
     * 版本号大小判断
     *
     * @param v1
     * @param v2
     * @return
     * @throws Exception
     */
    public static int compareVersion(String v1, String v2) {
        if (v1 == null) {
            return -1;
        }
        if (v2 == null) {
            return 1;
        }

        String[] arr1 = StringUtils.split(v1, ".");
        String[] arr2 = StringUtils.split(v2, ".");
        for (int i = 0; i < arr1.length; i++) {
            if (arr2.length <= i) {
                return 1;
            }
            int value1 = Integer.parseInt(arr1[i]);
            int value2 = Integer.parseInt(arr2[i]);
            if (value1 < value2) {
                return -1;
            } else if (value1 > value2) {
                return 1;
            }
        }
        if (arr1.length == arr2.length) {
            return 0;
        }

        return -1;
    }

}
