package com.example.algorithm.n_queen;

/**
 * 八皇后问题
 * @description: Nqueen
 * @date: 2022/5/30 下午8:04
 * @author: zcy
 * @version: 1.0
 */
public class Nqueen {
    public static void main(String[] args) {
        int n = 4;
        int[] arr = new int[n];
        System.out.println(getQueen(arr,0,n));
        System.out.println(num2(n));
    }


    public static int getQueen(int[] arr,int row,int countRol){
        if(row == countRol){
            return 1;
        }
        int res = 0;
        //遍历每一个位置是否可以放皇后
        for (int i = 0; i < arr.length; i++) {
            if(isValid(arr,row,i)){
                arr[row]=i;
                res+=getQueen(arr,row+1,countRol);
            }
        }
        return res;
    }

    public static boolean isValid(int[] arr,int row,int col){
        for (int k = 0; k < row; k++) {
            if(col == arr[k] || Math.abs(arr[k]- col)==Math.abs(row-k)){
                return false;
            }
        }
        return true;
    }

    public static int num2(int n){
        if(n<1||n>32){
            return 0;
        }
        int limit = n == 32 ? 1 : (1 << n) -1;
        return process2(limit, 0, 0, 0);
    }

    public static int process2(int limit,int colLimit,int leftDiaLim,int rigDiaLim){
        if(limit == colLimit){
            return 1;
        }
        int pos = 0;
        int mastRightOne = 0;
        //String  = Integer.toBinaryString(colLimit);
        pos = limit & (~(colLimit|leftDiaLim|rigDiaLim));
        int res = 0;
        while (pos!=0){
            mastRightOne = pos&(~pos+1);
            pos = pos -mastRightOne;
            res+=process2(limit,colLimit|mastRightOne,
                    (leftDiaLim|mastRightOne)<<1,
                    (rigDiaLim|mastRightOne)>>>1);
        }
        return res;
    }
}
