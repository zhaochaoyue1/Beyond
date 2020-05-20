package com.example.leetcode;

import org.assertj.core.util.Lists;

import java.util.List;

/**
 * (重点：一定要画图)
 * 动态规划算法
 * 题目： 有一个背包，他的容量为C（capacity). 现在有n种不同的商品，编号为0至n-1，其中每一件物品的重量为w(i),价值为v(i).问
 * 可以向这个背包中盛放哪些物品，使得在不超过背包容量的基础上，物质的总价值最大。
 * F(n,c)考虑将n个物品放进容量为C的背包，使得价值最大
 * F(i,c) = F(i-1,c)
 * = v(i) + F(i-1,c-w(i))
 * F(i,c) = max(F(i-1,c),v(i) + F(i-1,c-w(i)))
 */
public class DynamicProgramming {

    private static int[] wight = {2, 3, 11};
    private static int[] value = {8, 5, 7};
    private static List<Integer> list = Lists.newArrayList();

    public static int bestValue(int[] w, int[] v, int index, int c, Integer[][] array) {
        if (index < 0 || c <= 0) {
            return 0;
        }
        if (array[index][c] != null) {
            return array[index][c];
        }
        Integer res = bestValue(w, v, index - 1, c, array);
        if (c >= w[index]) {
            res = Math.max(res, v[index] + bestValue(w, v, index - 1, c - w[index], array));
        }
        array[index][c] = res;

        return res;
    }

    public static void main(String[] args) {
        int index = wight.length - 1;
        int c = 13;
        Integer[][] array = new Integer[wight.length][c + 1];
        System.out.println(bestValue(wight, value, index, c, array));
        System.out.println(getMaxValue(c, index));
        System.out.println(getMaxValueDynamic(c));
        //System.out.println(JSONObject.toJSONString(list));
    }
    /*--------------------------------理解二：求解 开始--------------------------------*/

    /**
     * 递归算法
     *
     * @param c     背包剩余的容量
     * @param index 物品个数（按下标取物品）举例 n=2，表示3个物品存放在数据中，重小标index开始取
     * @return
     */
    private static int getMaxValue(int c, int index) {
        if (index < 0 || c <= 0) {
            return 0;
        }
        //判断当前物品的重量
        int wNum = wight[index];
        int result = 0;
        //判断当前下标是否可以取
        if (wNum > c) {
            //不可以取这个物品
            result = getMaxValue(c, index - 1);
        } else {
            //可以取这个物品
            result = Math.max(getMaxValue(c, index - 1), value[index] + getMaxValue(c - wNum, index - 1));
        }
        return result;
    }

    /**
     * 运用动态规划实现
     *
     * @param capacity 背包最大容量
     * @return
     */
    private static int getMaxValueDynamic(int capacity) {
        //获取物品个数
        int n = wight.length;
        //维护一个二维矩阵
        //行
        int row = n;
        //列
        int column = capacity + 1;
        Integer[][] dp = new Integer[row][column];
        //开始更新这个二维矩阵列表的值
        //容量从0依次增加到capacity
        for (int i = 0; i < column; i++) {
            //从上往下，依次更新当前最有值
            for (int j = 0; j < row; j++) {
                //第一行特殊处理，容量能装下，就取当前值。装不下，则取值为0
                if (j == 0) {
                    if (i >= wight[0]) {
                        //当前容量能装下第一件物品
                        dp[j][i] = value[0];
                    } else {
                        //不能装下第一件物品
                        dp[j][i] = 0;
                    }
                } else if (i == 0) {
                    //因为容量为0，所以全部为0
                    dp[j][i] = 0;
                } else {
                    //后面的值可以用来比较
                    if (i < wight[j]) {
                        //如果容量装不下新物品，则当前直接取上一行的值
                        dp[j][i] = dp[j - 1][i];
                    } else {
                        //可以装下当前的重量
                        //当前重量 + 剩余容量的最有解是否大于等于上一级的值
                        int value1 = value[j] + dp[j - 1][i - wight[j]];
                        //获取上一行的值
                        int value2 = dp[j - 1][i];
                        dp[j][i] = Math.max(value1, value2);
                    }
                }
            }
        }

        return dp[row - 1][column - 1];
    }

    /*--------------------------------理解二：求解 结束--------------------------------*/

}
