package com.example.leetcode;

public class IsPalindRome {
    public static void main(String[] args) {
        int x = -121;
        System.out.println(isPalindrome(x));;
    }
    private static boolean isPalindrome(int x){
        String s = x+"";
        int length  = s.length();
        int mid = length / 2;
        for(int i = 0;i<mid;i++){
            int i1 = s.charAt(i);
            int i2 = s.charAt(length - 1 - i);
            if(i1!=i2){
                return false;
            }
        }
        return true;
    }
}
