package com.example;


import com.alibaba.fastjson.JSONObject;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * description: Test
 * date: 2020/5/27 下午2:36
 * author: zcy
 * version: 1.0
 */
public class Test {
    private static int[] weight = {8, 5, 3, 2};
    private static int[] value = {5, 5, 4, 6};

    public static void main(String[] args) {
        int c = 13;
        int i = weight.length - 1;
        //int[] b = {1,17,5,10,13,15,10,5,16,8};
        //String[]  s = {"duh","ill"};
        //List<List<String>> lists = groupAnagrams(s);
        //System.out.println(JSONObject.toJSONString(lists));
        //int n = 1234;
        //System.out.println(test(n));
        //System.out.println(test("abba", "dog cat cat dog"));
        //System.out.println(maxProfit(new int[]{1, 2, 3, 4, 9}, 0));
        //System.out.println(findTheDifference("adfd", "aedfd"));
        //System.out.println(firstUniqChar("123411"));
        //System.out.println(candy(new int[]{1, 0, 2}));
        //System.out.println(findContentChildren(new int[]{250,490,328,149,495,325,314,360,333,418,430,458}, new int[]{}));
        //int[] ints = {2,454,454,3,45};
        //sort2(ints,0,ints.length-1);
        //System.out.println(JSONObject.toJSONString(largeGroupPositions("abbxxxxzzzzyxxxx")));
        //int[] n = {1,2,3,4,5,6};
        //rotate(n,3);
        String s = "test1,test2,test3";
        String join = String.join(s, ",");
        System.out.println(join);
    }

    

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }

    public static List<List<Integer>> largeGroupPositions(String s) {
        int length = s.length();
        char a = 0;
        int k = 0;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                a = s.charAt(i);
                continue;
            }
            if (a == s.charAt(i)) {
                k++;
                if (i == length - 1 && k >= 2) {
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(i - k);
                    list1.add(i);
                    list.add(list1);
                }
                continue;
            }
            if (k >= 2) {
                List<Integer> list1 = new ArrayList<>();
                list1.add(i - k-1);
                list1.add(i - 1);
                list.add(list1);
            }
            a = s.charAt(i);
            k = 0;
        }

        return list;
    }

    public static int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }
        if (stones.length == 1) {
            return stones[0];
        }
        while (stones.length > 1) {
            Arrays.sort(stones);
            int length = stones.length;
            int i = stones[length - 1] - stones[length - 2];
            if (i == 0) {
                int[] a = new int[length - 2];
                System.arraycopy(stones, 0, a, 0, length - 2);
                stones = a;
            } else {
                int[] a = new int[length - 1];
                System.arraycopy(stones, 0, a, 0, length - 2);
                a[length - 2] = i;
                stones = a;
            }
        }
        return stones.length == 0 ? 0 : stones[0];
    }

    public static int findContentChildren(int[] g, int[] s) {
        if (g.length == 0) {
            return 0;
        }
        int a = g.length;
        int b = s.length;
        sort(g, 0, a - 1);
        sort(s, 0, b - 1);
        int count = 0;
        for (int i = 0; i < b; i++) {
            if (a == count) {
                break;
            }
            if (s[i] >= g[count]) {
                count++;
            }
        }
        return count;
    }

    private static void sort2(int[] arr, int left, int right) {
        if (arr == null || arr.length == 0) {
            return;
        }
        if (left > right) {
            return;
        }
        int l = left;
        int r = right;
        int pivot = arr[left];
        while (l != r) {
            while (arr[r] >= pivot && l < r) {
                r--;
            }
            while (arr[l] <= pivot && l < r) {
                l++;
            }
            if (l < r) {
                int temp = arr[r];
                arr[r] = arr[l];
                arr[l] = temp;
            }
        }
        arr[left] = arr[l];
        arr[l] = pivot;
        sort2(arr, left, l - 1);
        sort2(arr, l + 1, right);
    }

    private static void sort(int[] arr, int left, int right) {
        if (arr == null || arr.length == 0) {
            return;
        }
        if (left > right) {
            return;
        }
        int l = left;
        int r = right;
        int pivot = arr[left];
        while (l != r) {
            while (arr[r] >= pivot && l < r) {
                r--;
            }
            while (arr[l] <= pivot && l < r) {
                l++;
            }
            if (l < r) {
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }
        arr[left] = arr[l];
        arr[l] = pivot;
        sort(arr, left, l - 1);
        sort(arr, l + 1, right);
    }

    public static int candy(int[] ratings) {
        int length = ratings.length;
        int[] left = new int[length];
        for (int i = 0; i < length; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }

        }
        int right = 0, ret = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (i < length - 1 && ratings[i] > ratings[i + 1]) {
                right++;
            } else {
                right = 1;
            }
            ret += Math.max(right, left[i]);
        }
        return ret;
    }

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        return n + fib(n - 1);
    }

    public static int firstUniqChar(String s) {

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.merge(s.charAt(i), 1, (a, b) -> a + b);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    class TreeNode {
        /**
         * 节点数据
         */
        public int val;
        /**
         * 当前节点的左子节点
         */
        public TreeNode left;
        /**
         * 当前节点的右子节点
         */
        public TreeNode right;
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        int val = root.val;
        Queue<TreeNode> queue = new ArrayDeque();
        queue.add(root);
        while (queue.size() != 0) {
            int size = queue.size();

            List<Integer> listSon = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
                listSon.add(poll.val);
            }
            if (listSon.size() == 0) {
                continue;
            }
            int size1 = list.size();
            if (size1 % 2 == 0) {
                list.add(listSon);
            } else {
                int i = listSon.size() / 2;
                for (int j = 0; j < i; j++) {
                    int k;
                    int m = size1 - 1 - j;
                    k = listSon.get(i);
                    listSon.add(i, listSon.get(m));
                    listSon.add(m, k);
                }
                list.add(listSon);
            }
        }
        return list;
    }


    public static char findTheDifference(String s, String t) {

        String s1 = t.replaceAll(s, "");
        char c = s1.charAt(0);
        char[] chars = s.toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                map.put(chars[i], map.get(chars[i]) + 1);
            } else {
                map.put(chars[i], 1);
            }
        }
        char[] chars1 = t.toCharArray();
        /*for (int i = 0; i < chars1.length; i++) {
            if(map.containsKey(chars1[i])){
                Integer integer = map.get(chars1[i])-1;
                if(integer<0){
                    return chars1[i];
                }else {
                    map.put(chars1[i],integer);
                }
            }else {
                return chars1[i];
            }
        }*/
        int a = 0;
        for (int i = 0; i < t.length(); i++) {
            if (i == 0) {
                a = t.codePointAt(i) ^ a;
            } else {
                a = t.codePointAt(i) ^ a;
                a = s.codePointAt(i - 1) ^ a;
            }

        }
        System.out.println((char) a);
        return 'a';
    }


    /*输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
    https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/solution/di-gui-dong-tai-gui-hua-tan-xin-suan-fa-7wk97/
    输出: 8
    解释: 能够达到的最大利润:
    在此处买入 prices[0] = 1
    在此处卖出 prices[3] = 8
    在此处买入 prices[4] = 4
    在此处卖出 prices[5] = 9
    总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.*/


    public static int maxProfit(int[] prices, int fee) {
        int length = prices.length;
        int[] dp = {0, -prices[0]};
        List<Integer> List = new ArrayList<>();
        for (int i = 1; i < length; i++) {
            int t = dp[0];
            dp[0] = Math.max(dp[0], dp[1] + prices[i] - fee);
            dp[1] = Math.max(dp[1], t - prices[i]);
        }
        return dp[0];
    }

    public int maxProfit(int k, int[] prices) {
        int length = prices.length;
        int index = 0;
        List<Integer> list = new ArrayList<>();
        if (length == 0 || length == 1) {
            return 0;
        }
        for (int i = 0; i < length - 1; i++) {
            if (prices[i] <= prices[i + 1]) {
                continue;
            } else {
                if (index < i) {
                    list.add(prices[i] - prices[index]);
                    index = i + 1;
                } else {
                    index++;
                }
            }
        }
        int i = prices[length - 1] - prices[index];
        if (i > 0) {
            list.add(i);
        }
        int count = 0;
        if (list.size() > 0) {
            list.sort(Integer::compareTo);
            for (int j = list.size() - 1; j >= 0 && k > 0; j--, k--) {
                count += list.get(j);
            }
        }
        return count;
    }

    public static boolean test(String pattern, String str) {
        String[] array = str.split(" ");
        if (pattern.length() != array.length) {
            return false;
        }
        Map<Object, Object> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String sr = array[i];
            if (map.containsKey(c) && !sr.equals(map.get(c))) {
                return false;
            }
            if (map.containsKey(sr) && c != (Character) map.get(sr)) {
                return false;
            }
            map.put(c, sr);
            map.put(sr, c);
        }
        return true;
    }

    public static boolean wordPattern(String pattern, String str) {
        Map<String, Character> str2ch = new HashMap<String, Character>();
        Map<Character, String> ch2str = new HashMap<Character, String>();
        int m = str.length();
        int i = 0;
        for (int p = 0; p < pattern.length(); ++p) {
            char ch = pattern.charAt(p);
            if (i >= m) {
                return false;
            }
            int j = i;
            while (j < m && str.charAt(j) != ' ') {
                j++;
            }
            String tmp = str.substring(i, j);
            if (str2ch.containsKey(tmp) && str2ch.get(tmp) != ch) {
                return false;
            }
            if (ch2str.containsKey(ch) && !tmp.equals(ch2str.get(ch))) {
                return false;
            }
            str2ch.put(tmp, ch);
            ch2str.put(ch, tmp);
            i = j + 1;
        }
        return i >= m;
    }

    public static int test(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        int i = 1;
        if (i < chars.length && chars[i - 1] <= chars[i]) {
            i++;
        }
        if (i < chars.length) {
            while (i > 0 && chars[i - 1] > chars[i]) {
                chars[i - 1] -= 1;
                i--;
            }
            for (i += 1; i < chars.length; i++) {
                chars[i] = '9';
            }
        }
        return Integer.parseInt(new String(chars));
    }

    public static int monotoneIncreasingDigits(int N) {
        char[] strN = Integer.toString(N).toCharArray();
        int i = 1;
        while (i < strN.length && strN[i - 1] <= strN[i]) {
            i += 1;
        }
        if (i < strN.length) {
            while (i > 0 && strN[i - 1] > strN[i]) {
                strN[i - 1] -= 1;
                i -= 1;
            }
            for (i += 1; i < strN.length; ++i) {
                strN[i] = '9';
            }
        }
        return Integer.parseInt(new String(strN));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        Map<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            int hash = getHash(str);
            if (map.containsKey(hash)) {
                List<String> set = map.get(hash);
                set.add(str);
            } else {
                List<String> set = new ArrayList<>();
                set.add(str);
                map.put(hash, set);
            }
        }
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            List<String> list = new ArrayList<>();
            list.addAll(entry.getValue());
            lists.add(list);
        }
        return lists;
    }

    public static int getHash(String str) {
        char[] chars = str.toCharArray();
        int sum = 1;
        for (int i = 0; i < chars.length; i++) {
            sum *= (chars[i] << 4);
        }
        return sum;
    }


    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int up = 1;
        int down = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            }
            if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }

}
