package com.example.algorithm.kmp;

import com.alibaba.fastjson.JSONObject;

/**
 * 查询字符串s1,完整包含字符串s2的开始位置
 *
 * @description: SearchSonStr
 * @date: 2022/6/11 下午2:35
 * @author: zcy
 * @version: 1.0
 */
public class SearchSonStr {
    public static void main(String[] args) {
        String s1 = "abdddadjfkdjfkjsda;fjdsk;jjdfkdsjfkjdskjf;dsj;";
        String s2 = "dsj;";
        System.out.println(JSONObject.toJSONString(getNextArray("11211".toCharArray())));
        int i = s1.indexOf(s2);
        System.out.println(i);
        int[] all = getNextArray(s2.toCharArray());
        System.out.println(JSONObject.toJSONString(all));
        System.out.println(getIndexOf(s1, s2));
    }

    public static int getIndexOf(String s1, String s2) {
        int index = -1;
        if (s1.length() < s2.length()) {
            return index;
        }
        char[] chars = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int[] nextArray = getNextArray(chars2);
        int i1 = 0;;
        int i2 = 0;
        while (i1 < s1.length() && i2 < s2.length()) {
            if (chars[i1] == chars2[i2]) {
                i1++;
                i2++;
            } else if (i2 > 0) {
                i2 = nextArray[i2];
            } else {
                i1++;
            }
        }
        return i2 == s2.length() ? i1 - i2 : -1;
    }

    public static int[] getNextArray(char[] chars) {
        if (chars == null || chars.length < 2) {
            return new int[]{-1};
        }
        int[] arr = new int[chars.length];
        arr[0] = -1;
        arr[1] = 0;
        int index = 2;
        int cn = 0;
        while (index < chars.length) {
            if (chars[index] == chars[cn]) {
                arr[index++] = ++cn;
            } else if (cn > 0) {
                cn = arr[cn];
            } else {
                arr[index++] = 0;
            }
        }
        return arr;
    }
}
