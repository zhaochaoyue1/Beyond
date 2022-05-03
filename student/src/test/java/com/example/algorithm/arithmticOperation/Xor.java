package com.example.algorithm.arithmticOperation;

/**
 * 异或运算
 * 异或运算又称为是加法不进位计算或者半加法运算
 * 异或运算的特性：
 *  1. 1^0=1 0^1=1 1^1=0 0^0=0
 *  2. 具有结合性、和对换性
 *  3.
 *  1110
 *  0001
 *  0010
 *
 * @description: Xor
 * @date: 2022/3/18 上午11:39
 * @author: zcy
 * @version: 1.0
 */
public class Xor {
    public static void main(String[] args) {
        int[] ints = {1, 1, 2, 3, 2, 4, 5, 4, 5};
        System.out.println(getElement(ints));
        int[] ints2 = {1, 1, 2, 8, 2, 4, 4, 12};
        System.out.println(getTwoElement(ints2));
    }

    /**
     * 需求一：一个数组中有多个偶数项元素和一个基数项元素，请找出基数项元素
     */
    public static int getElement(int[] arr){
        int eor = 0;
        for(int a:arr){
            eor^=a;
        }
        return eor;
    }

    /**
     * 需求二： 一个数组有两个不想等的元素时基数项，其余元素都是偶数项，请找出这两个基数数字
     */
    public static String getTwoElement(int[] arr){

        int eor = 0;
        for(int a:arr){
            eor^=a;
        }
        //上面程序执行完后eor实际就是这个两个基数项的数字异或后的结果

        //取出eor最有侧为1的位，为1表示是两个奇数不等位的异或结果，按照这一位将数组结果分为两步分，
        // a,b必然个占一边
        int minRight = eor&((~eor)+1);
        int b = 0;
        for (int a:arr){
            //找到与minRight相同为1的数值
            if((a & minRight)== minRight){
                b^=a;
            }
        }
        return "b :"+ b + "  c:"+(eor^b);
    }
}
