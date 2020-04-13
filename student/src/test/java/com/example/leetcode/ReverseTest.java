package com.example.leetcode;

public class ReverseTest {
    public static void main(String[] args) {
        reverse(123);
    }

    public static int reverse(int x) {
        String a = x + "";
        int length = a.length();
        char[] chars = a.toCharArray();
        boolean negative = false;
        StringBuffer sb =new StringBuffer();
        for(int j = length-1;j>=0;j--){
            char aChar = chars[j];
            if(j==0&&chars[j]=='-'){
                negative=true;
                break;
            }
            sb.append(aChar);

        }
        Long aLong = Long.valueOf(sb.toString());
        if(negative){
           if( -aLong<Integer.MIN_VALUE){
               return 0;
           }else {
               return -aLong.intValue();
           }
        }
        if(aLong>Integer.MAX_VALUE){
            return 0;
        }else {
            return aLong.intValue();
        }
    }
}
