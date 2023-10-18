package com.example;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.designPattern23.strategyPattern.Sort;
import com.example.student.Student;
import com.example.student.project.service.ProxyService;
import com.example.student.project.service.StudentService;
import com.example.student.project.service.impl.StudentServiceImpl;
import com.google.common.collect.Maps;
import lombok.Builder;
import lombok.Data;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.util.CollectionUtils;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.stream.Stream;

/**
 * description: Test
 * date: 2020/5/27 下午2:36
 * author: zcy
 * version: 1.0
 */
public class Test {
    private static int[] weight = {8, 5, 3, 2};
    private static int[] value = {5, 5, 4, 6};

    public static void main(String[] args) throws ClassNotFoundException {
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
        //String s = "test1,test2,test3";
        //String join = String.join(s, ",");
        //System.out.println(join);
        //System.out.println(minCut("sdjkdjkjdkjda"));
        //System.out.println(cal("1000/3+5 + 9 / 3"));;
        //System.out.println(isValidSerialization("1,#,2"));
        //System.out.println(JSONObject.toJSONString(generateMatrix4(3)));
        //System.out.println(numDistinct("  com.example.spi.SpiInterface"," com.example.spi.SpiInterface"));
        //System.out.println(evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        //subsetsWithDup(new int[]{1,2});
        //System.out.println(trap(new int[]{1, 3, 1, 5, 6, 7, 8}));
        //System.out.println(new Date().getTime());
        //System.out.println(removeDuplicates(new int[]{1,1,1,1,4,4,4}));
        //System.out.println(findMin(new int[]{1,2,3,4,5}));
        //System.out.println(findMinThree(new int[]{3, 3, 1, 3}));
        //System.out.println(rob(new int[]{3,30,34,5,9}));
        //System.out.println(strStr("mississippi","issip"));
        //System.out.println();
        //romanToInt("III");
        //findMaximumXOR(new int[]{1, 6,30});
        //reverseParentheses("(er(abcd)hs)");
        //int[][] ints = {{2, 9, 10}, {2, 7, 15}, {2, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        //int[][] ints1 = {{4, 6, 4}, {2, 3, 1}, {2, 5, 2}, {3, 4, 3}, {4, 5, 2}};
        //int[][] ints2 = {{2, 3, 6}, {2, 4, 7}};
        //System.out.println(JSONObject.toJSONString(getSkyline3(ints1)));
        ;
        //priorityQueue();
        //int maximumGenerated = getMaximumGenerated(10);
        ///longestPalindrome("1111");
        //findMaximizedCapital(2,4,new int[]{2,2,3,7},new int[]{4,4,4,5});
        //getRpn("3+(5*6)-8");
        //int tilt = findTilt(treeNode);
        /*List<Integer> list = Lists.newArrayList();
        list.add(4);
        list.add(3);
        list.add(5);
        list.add(4);
        Collections.sort(list,((o1, o2) -> {
            int i1 = o2.compareTo(o1);
            if(i1 !=0){
                return i1;
            }
            return o2-o1;
        }));
        System.out.println(JSONObject.toJSONString(list));*/
        //System.out.println(divide(-2147483648,-1));
        //int[] nums1 = {3,8,10},nums2={5,8,10,7,2,3,4};
        //System.out.println(JSONObject.toJSONString(nextGreaterElement(nums1,nums2)));
        //System.out.println(removeInvalidParentheses("()())()"));
        //test("");

        //System.out.println(shortestCompletingWord("1s3 PSt", new String[]{"step","steps","stripe","stepple"}));
        //System.out.println(findRadius2(new int[]{3,5,6,7,8,9,11,12},new int[]{5,11,12}));;
        //repeatedStringMatch("abcd","cdabcd");
        //pushDominoes(".L.R...LR..L..");
        //maximumRequests2(5,new int[][]{{0,1},{1,0},{0,1},{1,2},{2,0},{3,4}});
        //new CountHighest().countHighestScoreNodes(new int[]{-1,2,0,2,0});
        /*System.out.println(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli());
        System.out.println(new Date().getTime());*/
        /*int[][] matrix = new int[][]{{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(minFallingPathSum(matrix));
        Integer num = new Integer("3");
        updateNum(num);
        System.out.println(num);*/
        System.out.println(JSONObject.toJSONString(avoidFlood(new int[]{1,2,0,2})));
    }

    public int[] singleNumber(int[] nums) {
        int[] arr = new int[2];
        int sum = 0;
        for (int j = 0; j < nums.length; j++) {
            sum = sum ^ nums[j];
        }
        int minRight = sum & ((~sum)+1);
        int a = 0;
        for (int j = 0; j < nums.length; j++) {
            if((minRight&nums[j])==minRight){
                a ^= nums[j];
            }
        }
        arr[0] = a;
        arr[1] = sum ^ a;
        return arr;
    }

    public static int[] avoidFlood(int[] rains) {
        int[] ans = new int[rains.length];
        Arrays.fill(ans, 1);
        TreeSet<Integer> st = new TreeSet<>();
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < rains.length; ++i) {
            //等于0没有下雨
            if (rains[i] == 0) {
                //记录没有下雨的天数
                st.add(i);
            } else {
                //下雨了
                ans[i] = -1;
                if (mp.containsKey(rains[i])) {
                    //某个湖泊下雨了
                    Integer it = st.ceiling(mp.get(rains[i]));
                    if (it == null) {
                        return new int[0];
                    }
                    ans[it] = rains[i];
                    st.remove(it);
                }
                //记录那个湖泊，在那天下雨了
                mp.put(rains[i], i);
            }
        }
        return ans;
    }

    /**
     * rains[i] > 0 表示第 i 天时，第 rains[i] 个湖泊会下雨。
     * rains[i] == 0 表示第 i 天没有湖泊会下雨，你可以选择 一个 湖泊并 抽干 这个湖泊的水。
     * 请返回一个数组 ans ，满足：
     *
     * ans.length == rains.length
     * 如果 rains[i] > 0 ，那么ans[i] == -1 。
     * 如果 rains[i] == 0 ，ans[i] 是你第 i 天选择抽干的湖泊。
     * 如果有多种可行解，请返回它们中的 任意一个 。如果没办法阻止洪水，请返回一个 空的数组 。
     *
     * rain[1,2,0,3]
     * ans[-1,-1,-1,0]
     * [1,2]
     * 2
     * 1
     */


    public static void updateNum(Integer num){
        num=9;
    }

    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] dp = new int[n];
        System.arraycopy(matrix[0], 0, dp, 0, n);
        dp = dfs(matrix, dp, 1, n);
        System.out.println(JSONObject.toJSON(dp));
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < n; ++j) {
            res = Math.min(res, dp[j]);
        }

        return res;
    }

    private static int[] dfs(int[][] matrix, int[] dp, int depth, int n) {
        if (depth == n) {
            return dp;
        }

        int[] nextDp = new int[n];
        for (int i = 0; i < n; ++i) {
            int cur = dp[i];
            if (i > 0) cur = Math.min(cur, dp[i - 1]);
            if (i < n - 1) cur = Math.min(cur, dp[i + 1]);
            nextDp[i] = cur + matrix[depth][i];
        }

        return dfs(matrix, nextDp, depth + 1, n);
    }

    @Data
    static class MinBool{
        private boolean isValid;
        private int num;
    }

    static class CountHighest{
        long maxScore = 0;
        int cnt = 0;
        int n;
        List<Integer>[] children;

        public int countHighestScoreNodes(int[] parents) {
            n = parents.length;
            children = new List[n];
            for (int i = 0; i < n; i++) {
                children[i] = new ArrayList<Integer>();
            }
            for (int i = 0; i < n; i++) {
                int p = parents[i];
                if (p != -1) {
                    children[p].add(i);
                }
            }
            dfs(0);
            return cnt;
        }

        public int dfs(int node) {
            long score = 1;
            int size = n - 1;
            for (int c : children[node]) {
                int t = dfs(c);
                score *= t;
                size -= t;
            }
            if (node != 0) {
                score *= size;
            }
            if (score == maxScore) {
                cnt++;
            } else if (score > maxScore) {
                maxScore = score;
                cnt = 1;
            }
            return n - size;
        }
    }

    public String convert(String s, int numRows) {
        int length = s.length();
        int n = (numRows-1)*2;
        int col = length / n + length % n > 0 ? 1 : 0;

        return null;
    }

    /**
     * 链接：https://leetcode-cn.com/problems/maximum-number-of-achievable-transfer-requests/solution/202202280859-mei-ri-yi-ti-java-hui-su-by-ltao/
     * @param n
     * @param requests
     * @return
     */
    public static int maximumRequests2(int n, int[][] requests) {
        return dfs(new int[n], requests, 0, 0);
    }

    // 可选选项：requests[cur]
    // 当前状态：count
    // 结束条件：cur >= requests.length
    // 更新结果：isAcceptable(count) == true
    private static int dfs(int[] count, int[][] requests, int cur, int chosen) {
        // 到达结束条件
        if (cur >= requests.length) {
            if (isAcceptable(count)) {
                return chosen;
            }
            return 0;
        }

        // 不接受 request[cur]
        int ret = dfs(count, requests, cur + 1, chosen);

        // 接受 request[cur]
        count[requests[cur][0]] -= 1;
        count[requests[cur][1]] += 1;
        ret = Math.max(ret, dfs(count, requests, cur + 1, chosen + 1));
        count[requests[cur][1]] -= 1;
        count[requests[cur][0]] += 1;

        return ret;
    }

    private static boolean isAcceptable(int[] cnt) {
        for (int c : cnt) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }



    public int maximumRequests(int n, int[][] requests) {
        int[] delta = new int[n];
        int ans = 0, m = requests.length;
        for (int mask = 0; mask < (1 << m); ++mask) {
            int cnt = Integer.bitCount(mask);
            if (cnt <= ans) {
                continue;
            }
            Arrays.fill(delta, 0);
            for (int i = 0; i < m; ++i) {
                if ((mask & (1 << i)) != 0) {
                    ++delta[requests[i][0]];
                    --delta[requests[i][1]];
                }
            }
            boolean flag = true;
            for (int x : delta) {
                if (x != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans = cnt;
            }
        }
        return ans;
    }

    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int ans = -1, premin = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] > premin) {
                ans = Math.max(ans, nums[i] - premin);
            } else {
                premin = nums[i];
            }
        }
        return ans;
    }

    public static String pushDominoes(String dominoes) {
        char[] s = dominoes.toCharArray();
        int n = s.length, i = 0;
        char left = 'L';
        while (i < n) {
            int j = i;
            while (j < n && s[j] == '.') { // 找到一段连续的没有被推动的骨牌
                j++;
            }
            char right = j < n ? s[j] : 'R';
            if (left == right) { // 方向相同，那么这些竖立骨牌也会倒向同一方向
                while (i < j) {
                    s[i++] = right;
                }
            } else if (left == 'R' && right == 'L') { // 方向相对，那么就从两侧向中间倒
                int k = j - 1;
                while (i < k) {
                    s[i++] = 'R';
                    s[k--] = 'L';
                }
            }
            left = right;
            i = j + 1;
        }
        return new String(s);
    }



    /**
     * leetcode-cn.com/problems/repeated-string-match/solution/zhong-fu-die-jia-zi-fu-chuan-pi-pei-by-l-vnye/
     * @param a
     * @param b
     * @return
     */
    public static int repeatedStringMatch(String a, String b) {
        int an = a.length(), bn = b.length();
        int index = strStr2(a, b);
        if (index == -1) {
            return -1;
        }
        if (an - index >= bn) {
            return 1;
        }
        return (bn + index - an - 1) / an + 2;
    }

    public static int strStr2(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        for (int i = 0, j = 0; i - j < n; i++) { // b 开始匹配的位置是否超过第一个叠加的 com.example.spi.SpiInterface
            while (j > 0 && haystack.charAt(i % n) != needle.charAt(j)) { // haystack 是循环叠加的字符串，所以取 i % n
                j = pi[j - 1];
            }
            if (haystack.charAt(i % n) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }


    /**
     * TODO 很重要，很有用 可以散发都灌溉上
     * 链接：https://leetcode-cn.com/problems/heaters/solution/gong-nuan-qi-by-leetcode-solution-rwui/
     * findRadius2
     * @return
     */
    public static int findRadius(int[] houses, int[] heaters) {
        int ans = 0;
        Arrays.sort(heaters);
        for (int house : houses) {
            int i = binarySearch2(heaters, house);
            int j = i + 1;
            int leftDistance = i < 0 ? Integer.MAX_VALUE : house - heaters[i];
            int rightDistance = j >= heaters.length ? Integer.MAX_VALUE : heaters[j] - house;
            int curDistance = Math.min(leftDistance, rightDistance);
            ans = Math.max(ans, curDistance);
        }
        return ans;
    }
    public static int binarySearch2(int[] heaters, int house) {
        int left = 0, right = heaters.length - 1;
        if (heaters[left] > house) {
            return -1;
        }
        while (left < right) {
            int mid = (right - left + 1) / 2 + left;
            if (heaters[mid] > house) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public static int findRadius2(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans = 0;
        for (int i = 0, j = 0; i < houses.length; i++) {
            int curDistance = Math.abs(houses[i] - heaters[j]);
            while (j < heaters.length - 1 && Math.abs(houses[i] - heaters[j]) >= Math.abs(houses[i] - heaters[j + 1])) {
                j++;
                curDistance = Math.min(curDistance, Math.abs(houses[i] - heaters[j]));
            }
            ans = Math.max(ans, curDistance);
        }
        return ans;
    }


    /**
     * https://leetcode-cn.com/problems/shortest-completing-word/solution/zui-duan-bu-quan-ci-by-leetcode-solution-35pt/
     * @param licensePlate
     * @param words
     * @return
     */
    public static String shortestCompletingWord(String licensePlate, String[] words) {
        int[] cnt = new int[26];
        for (int i = 0; i < licensePlate.length(); ++i) {
            char ch = licensePlate.charAt(i);
            if (Character.isLetter(ch)) {
                ++cnt[Character.toLowerCase(ch) - 'a'];
            }
        }
        int idx = -1;
        for (int i = 0; i < words.length; ++i) {
            int[] c = new int[26];
            for (int j = 0; j < words[i].length(); ++j) {
                char ch = words[i].charAt(j);
                ++c[ch - 'a'];
            }
            boolean ok = true;
            for (int j = 0; j < 26; ++j) {
                if (c[j] < cnt[j]) {
                    ok = false;
                    break;
                }
            }
            if (ok && (idx < 0 || words[i].length() < words[idx].length())) {
                idx = i;
            }
        }
        return words[idx];
    }

    public static void test(String s) {
        System.out.println("jkdjfkwe".substring(1));
        System.out.println(Math.pow(2,7));
    }

    public static List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<String>();
        Set<String> currSet = new HashSet<String>();

        currSet.add(s);
        while (true) {
            for (String str : currSet) {
                if (isValid(str)) {
                    ans.add(str);
                }
            }
            if (ans.size() > 0) {
                return ans;
            }
            Set<String> nextSet = new HashSet<String>();
            for (String str : currSet) {
                for (int i = 0; i < str.length(); i ++) {
                    if (i > 0 && str.charAt(i) == str.charAt(i - 1)) {
                        continue;
                    }
                    if (str.charAt(i) == '(' || str.charAt(i) == ')') {
                        nextSet.add(str.substring(0, i) + str.substring(i + 1));
                    }
                }
            }
            currSet = nextSet;
        }
    }

    private static boolean isValid(String str) {
        char[] ss = str.toCharArray();
        int count = 0;

        for (char c : ss) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }

        return count == 0;
    }

    /**
     * 单调栈
     * https://leetcode-cn.com/problems/next-greater-element-i/solution/xia-yi-ge-geng-da-yuan-su-i-by-leetcode-bfcoj/
     * @return
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2){
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<nums2.length;i++){
            while(!stack.isEmpty() && nums2[i] >= stack.peek()){
                stack.pop();
            }
            map.put(nums2[i],stack.isEmpty() ? -1:stack.peek());
            stack.push(nums2[i]);
        }
        for(int i = 0 ;i <nums1.length;i++){
            nums1[i]=map.get(nums1[i]);
        }
        return nums1;
    }

    public static int divide(int dividend, int divisor) {

        if(dividend == 0 ){
            return 0;
        }
        if(dividend<0){
            if(divisor <0){
                return num(-dividend,-divisor);
            }else{
                return -num(-dividend,divisor);
            }
        }else{
            if(divisor <0){
                return -num(dividend,-divisor);
            }else{
                return num(dividend,divisor);
            }
        }
    }

    public static int num(int div,int dis){
        int num = 0;
        while(div>=dis){
            num++;
            div-=dis;
        }
        return num;
    }


    /*TreeNode treeNode = new TreeNode();
    treeNode.val=4;
    TreeNode left = new TreeNode();
    left.val=2;
    TreeNode right = new TreeNode();
    right.val=9;
    treeNode.right=right;
    treeNode.left=left;

    TreeNode leftLeft = new TreeNode();
    leftLeft.val=3;
    TreeNode leftRight = new TreeNode();
    leftRight.val=5;
    left.right=leftRight;
    left.left=leftLeft;
    TreeNode rightRight = new TreeNode();
    rightRight.val=7;
    right.right=rightRight;*/


    public static int findTilt(TreeNode root){
        if(root == null){
            return 0;
        }

        List<Integer> list = new ArrayList<>();
        return root(root);
    }

    //root
    public static int root(TreeNode root){
        int result =0;
        if(root.left!=null){
            result+=root(root.left);
        }
        if (root.right!=null){
            result+=root(root.right);
        }
        int right =0;
        if(root.right!=null){
            right=root.right.val;
        }
        int left = 0;
        if(root.left!=null){
            left = root.left.val;
        }
        root.val=root.val+right+left;
        result+=Math.abs(right-left);
        return result;
    }


    public static int root2(TreeNode root){
        int left =0;
        if(root.left!=null){
            left=root3(root.left);
        }
        int right=0;
        if(root.right!=null){
            right=root3(root.right);
        }
        return Math.abs(left-right);
    }
    public static int root3(TreeNode root){
        if(root == null){
            return 0;
        }
        int result = root.val;
        if(root.left!=null){
            result+=root3(root.left);
        }
        if(root.right!=null){
            result+=root3(root.right);
        }
        return result;
    }

    public static List<String> getRpn(String str){
        char[] chars = str.toCharArray();
        List<String> ls = new ArrayList<>();
        for (int i = 0; i < chars.length ; i++) {
            ls.add(String.valueOf(chars[i]));
        }


        //符号栈
        Stack<String> s1 = new Stack<>();
        //结果
        List<String> s2 = Lists.newArrayList();
        for(String item: ls){
            if(item.matches("\\d+")){
                s2.add(item);
            }else if("(".equals(item)){
                s1.push(item);
            }else if (")".equals(item)){
                while(!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();
            }else {
                //while (s1.size()!=0&&Operation.getValue(s1.peek()) >= Operation.getValue(item))
            }
        }
        while (s1.size() != 0 ){
            s2.add(s1.pop());
        }
        return s2;
    }



    /**
     *   链接：https://leetcode-cn.com/problems/ipo/solution/ipo-by-leetcode-solution-89zm/
     * @return
     */
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int curr = 0;
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; ++i) {
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        for (int i = 0; i < k; ++i) {
            while (curr < n && arr[curr][0] <= w) {
                pq.add(arr[curr][1]);
                curr++;
            }
            if (!pq.isEmpty()) {
                w += pq.poll();
            } else {
                break;
            }
        }

        return w;
    }



    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }



    public static int getMaximumGenerated(int n) {
        if(n == 0 || n==1){
            return n;
        }
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        for(int m=2;m<=n;m++){
            
            if( (m % 2) == 0){
                list.add(list.get(m/2));
                continue;
            }
            if(((m+1)%2)==0){
                list.add(list.get((m-1)/2)+list.get((m+1)/2));
                continue;
            }
        }
        return Math.max(list.get(list.size()-1),list.get(list.size()-2));
    }

    public static int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int MOD = (int) (1e9) + 7;
        int n = nums1.length;
        int[] rec = new int[n];
        System.arraycopy(nums1, 0, rec, 0, n);
        Arrays.sort(rec);
        int sum = 0, maxn = 0;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            sum = (sum + diff) % MOD;
            int j = binarySearch(rec, nums2[i]);
            if (j < n) {
                maxn = Math.max(maxn, diff - (rec[j] - nums2[i]));
            }
            if (j > 0) {
                maxn = Math.max(maxn, diff - (nums2[i] - rec[j - 1]));
            }
        }
        return (sum - maxn + MOD) % MOD;
    }

    private static int binarySearch(int[] rec, int target) {
        int low = 0, high = rec.length - 1;
        if (rec[high] < target) {
            return high + 1;
        }
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (rec[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }


    public static List<List<Integer>> getSkyline3(int[][] buildings) {
        List<int[]> buildPoints = Lists.newArrayList();
        //获取到所有横坐标
        for (int[] a : buildings) {
            buildPoints.add(new int[]{a[0], -a[2]});
            buildPoints.add(new int[]{a[1], a[2]});
        }
        //横坐标升序排列，横坐标相等时纵坐标升序
        buildPoints.sort((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        //最大的优先队列
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        //最后获得的最大坐标，起始是0
        pq.offer(0);
        //存储延迟处理的高度
        Map<Integer, Integer> maps = Maps.newHashMap();
        //最后的高度
        int lastHigh = 0;
        List<List<Integer>> res = Lists.newArrayList();

        for (int[] a : buildPoints) {
            if (a[1] < 0) {
                pq.offer(-a[1]);
            } else {
                maps.merge(a[1], 1, Integer::sum);
            }
            while (!pq.isEmpty()) {
                Integer peek = pq.peek();
                if (maps.containsKey(peek)) {
                    pq.poll();
                    if (maps.merge(peek, -1, Integer::sum) == 0) {
                        maps.remove(peek);
                    }
                } else {
                    break;
                }
            }
            Integer peek = pq.peek();
            //有高度差记录
            if (peek != lastHigh) {
                // 正在扫过的左端点的值
                res.add(Arrays.asList(a[0], peek));
                //当前高度成为计算高度差的标准
                lastHigh = peek;
            }
        }
        return res;
    }

    /**
     * https://leetcode-cn.com/problems/the-skyline-problem/solution/you-xian-dui-lie-java-by-liweiwei1419-jdb5/
     *
     * @param buildings
     * @return
     */
    public static List<List<Integer>> getSkyline2(int[][] buildings) {
        // 第 1 步：预处理
        List<int[]> buildingPoints = new ArrayList<>();
        for (int[] b : buildings) {
            // 负号表示左边高度的转折点
            buildingPoints.add(new int[]{b[0], -b[2]});
            buildingPoints.add(new int[]{b[1], b[2]});
        }

        // 第 2 步：按照横坐标排序，横坐标相同的时候，高度高的在前面
        buildingPoints.sort((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                // 注意：这里因为左端点传进去的时候，数值是负的，在比较的时候还按照升序排序
                return a[1] - b[1];
            }
        });

        // 第 3 步：扫描一遍动态计算出结果
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // 哈希表，记录「延迟删除」的元素，key 为元素，value 为需要删除的次数
        Map<Integer, Integer> delayed = new HashMap<>();

        // 最开始的时候，需要产生高度差，所以需要加上一个高度为 0，宽度为 0 的矩形
        maxHeap.offer(0);
        // 为了计算高度差，需要保存之前最高的高度
        int lastHeight = 0;
        List<List<Integer>> res = new ArrayList<>();
        for (int[] buildingPoint : buildingPoints) {
            if (buildingPoint[1] < 0) {
                // 说明此时是「从下到上」，纵坐标参与选拔最大值，请见「规则 1」
                maxHeap.offer(-buildingPoint[1]);
            } else {
                // 不是真的删除 buildingPoint[1]，把它放进 delayed，等到堆顶元素是 buildingPoint[1] 的时候，才真的删除
                delayed.merge(buildingPoint[1], 1, Integer::sum);
            }

            // 如果堆顶元素在延迟删除集合中，才真正删除，这一步可能执行多次，所以放在 while 中
            // while (true) 都是可以的，因为 maxHeap 一定不会为空
            while (!maxHeap.isEmpty()) {
                int curHeight = maxHeap.peek();
                if (delayed.containsKey(curHeight)) {
                    delayed.put(curHeight, delayed.get(curHeight) - 1);
                    if (delayed.get(curHeight) == 0) {
                        delayed.remove(curHeight);
                    }
                    maxHeap.poll();
                } else {
                    break;
                }
            }

            int curHeight = maxHeap.peek();
            // 有高度差，才有关键点出现
            if (curHeight != lastHeight) {
                // 正在扫过的左端点的值
                res.add(Arrays.asList(buildingPoint[0], curHeight));
                // 当前高度成为计算高度差的标准
                lastHeight = curHeight;
            }
        }
        return res;
    }

    public static void priorityQueue() {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            pq.offer(random.nextInt(100));
        }
        while (!pq.isEmpty()) {
            Integer peek = pq.peek();
            System.out.println(pq.poll());

        }
    }

    public static List<List<Integer>> getSkyline(int[][] buildings) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> b[1] - a[1]);
        List<Integer> boundaries = new ArrayList<Integer>();
        for (int[] building : buildings) {
            boundaries.add(building[0]);
            boundaries.add(building[1]);
        }
        Collections.sort(boundaries);

        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        int n = buildings.length, idx = 0;
        for (int boundary : boundaries) {
            while (idx < n && buildings[idx][0] <= boundary) {
                pq.offer(new int[]{buildings[idx][1], buildings[idx][2]});
                idx++;
            }
            while (!pq.isEmpty() && pq.peek()[0] <= boundary) {
                pq.poll();
            }

            int maxn = pq.isEmpty() ? 0 : pq.peek()[1];
            if (ret.size() == 0 || maxn != ret.get(ret.size() - 1).get(1)) {
                ret.add(Arrays.asList(boundary, maxn));
            }
        }
        return ret;
    }

    int i, n;
    String formula;

    public String countOfAtoms(String formula) {
        this.i = 0;
        this.n = formula.length();
        this.formula = formula;

        Deque<Map<String, Integer>> stack = new LinkedList<Map<String, Integer>>();
        stack.push(new HashMap<String, Integer>());
        while (i < n) {
            char ch = formula.charAt(i);
            if (ch == '(') {
                i++;
                stack.push(new HashMap<String, Integer>()); // 将一个空的哈希表压入栈中，准备统计括号内的原子数量
            } else if (ch == ')') {
                i++;
                int num = parseNum(); // 括号右侧数字
                Map<String, Integer> popMap = stack.pop(); // 弹出括号内的原子数量
                Map<String, Integer> topMap = stack.peek();
                for (Map.Entry<String, Integer> entry : popMap.entrySet()) {
                    String atom = entry.getKey();
                    int v = entry.getValue();
                    topMap.put(atom, topMap.getOrDefault(atom, 0) + v * num); // 将括号内的原子数量乘上 num，加到上一层的原子数量中
                }
            } else {
                String atom = parseAtom();
                int num = parseNum();
                Map<String, Integer> topMap = stack.peek();
                topMap.put(atom, topMap.getOrDefault(atom, 0) + num); // 统计原子数量
            }
        }

        Map<String, Integer> map = stack.pop();
        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>(map);

        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            String atom = entry.getKey();
            int count = entry.getValue();
            sb.append(atom);
            if (count > 1) {
                sb.append(count);
            }
        }
        return sb.toString();
    }

    public String parseAtom() {
        StringBuffer sb = new StringBuffer();
        sb.append(formula.charAt(i++)); // 扫描首字母
        while (i < n && Character.isLowerCase(formula.charAt(i))) {
            sb.append(formula.charAt(i++)); // 扫描首字母后的小写字母
        }
        return sb.toString();
    }

    public int parseNum() {
        if (i == n || !Character.isDigit(formula.charAt(i))) {
            return 1; // 不是数字，视作 1
        }
        int num = 0;
        while (i < n && Character.isDigit(formula.charAt(i))) {
            num = num * 10 + formula.charAt(i++) - '0'; // 扫描数字
        }
        return num;
    }

    public int[] array(int[] arr1, int[] arr2) {
        int length1 = arr1.length;
        int length2 = arr2.length;
        if (length1 == 0) {
            return arr2;
        }
        if (length2 == 0) {
            return arr1;
        }
        int length3 = length1 + length2;
        int[] arr3 = new int[length3];
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < length3; i++) {
            if (arr1[index1] > arr2[index2]) {
                arr3[i] = arr2[index2];
                index2++;
                if (index2 == length2) {
                    for (int j = i + 1; j < length3; j++) {
                        arr3[j] = arr1[index1];
                        index1++;
                    }
                    return arr3;
                }
            } else {
                arr3[i] = arr1[index1];
                index1++;
                if (index1 == length1) {
                    for (int j = i + 1; j < length3; j++) {
                        arr3[j] = arr2[index2];
                        index2++;
                    }
                    return arr3;
                }
            }
        }
        return arr3;
    }

    public static String reverseParentheses(String s) {
        Deque<String> stack = new LinkedList<String>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(sb.toString());
                sb.setLength(0);
            } else if (ch == ')') {
                sb.reverse();
                sb.insert(0, stack.pop());
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    // 最高位的二进制位编号为 30
    static final int HIGH_BIT = 30;

    public static int findMaximumXOR(int[] nums) {
        int res = 0;
        int mask = 0;
        for (int i = HIGH_BIT; i >= 0; i--) {
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                //获取高位
                set.add(num & mask);
            }
            //如果当前第i位为1时，就是目标最大值
            int targetMax = res | (1 << i);
            for (Integer prefix : set) {
                //最大目标值，异或已有前缀，获得另一个一个前缀temp
                int temp = prefix ^ targetMax;
                //set集合里如果有和前缀异或等于1的可以获取当前位
                //是否存在另一个前缀
                if (set.contains(temp)) {
                    res = targetMax;
                    break;
                }
            }
        }
        return res;
    }


    public static int romanToInt(String s) {
        Map<String, Integer> map = new HashMap(32);
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);
        int num = 0;
        int lenght = s.length();
        for (int i = 0; i < lenght; i++) {
            if (i + 1 < lenght) {
                String key = s.substring(i, i + 2);
                if (map.containsKey(key)) {
                    num += map.get(key);
                    i += 1;
                    continue;
                }
            }
            num += map.get(s.substring(i, i + 1));
        }
        return num;
    }

    /**
     * https://leetcode-cn.com/problems/frog-jump/solution/qing-wa-guo-he-by-leetcode-solution-mbuo/
     * title:青蛙过河
     *
     * @param stones
     * @return
     */
    public static boolean canCross(int[] stones) {
        int n = stones.length;
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;
        for (int i = 1; i < n; ++i) {
            if (stones[i] - stones[i - 1] > i) {
                return false;
            }
        }
        HashMap<Object, Object> map = Maps.newHashMap();
        for (int i = 1; i < n; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                int k = stones[i] - stones[j];
                if (k > j + 1) {
                    break;
                }
                dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
                if (i == n - 1 && dp[i][k]) {
                    return true;
                }
            }
        }
        return false;
    }


    public static int shipWithinDays(int[] weights, int D) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();
        return 0;
    }

    /**
     * https://leetcode-cn.com/problems/implement-strstr/solution/shi-xian-strstr-by-leetcode-solution-ds6y/
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStrKmp(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

    public static int strStr(String haystack, String needle) {
        if (haystack.equals(needle)) {
            return 0;
        }
        if (haystack == "") {
            return -1;
        }
        if (needle.equals("")) {
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0) && haystack.length() - i >= needle.length()) {
                for (int j = 0; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    }
                    if (j == needle.length() - 1) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }


    public static int rob1(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        } else if (length == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            return Math.max(rob2(nums, 0, length - 2), rob2(nums, 1, length - 1));
        }
    }

    public static int rob2(int[] nums, int low, int high) {
        int first = nums[low], second = Math.max(nums[low], nums[low + 1]);
        for (int i = low + 2; i <= high; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = second;
        }
        return second;
    }

    //https://leetcode-cn.com/problems/house-robber-ii/solution/da-jia-jie-she-ii-by-leetcode-solution-bwja/
    public static int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        } else if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robRange(nums, 0, length - 2), robRange(nums, 1, length - 1));
    }

    public static int robRange(int[] nums, int start, int end) {
        int first = nums[start], second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }

    //https://leetcode-cn.com/problems/largest-number/solution/zui-da-shu-by-leetcode-solution-sid5/
    public static String largestNumber(int[] nums) {
        int n = nums.length;
        // 转换成包装类型，以便传入 Comparator 对象（此处为 lambda 表达式）
        Integer[] numsArr = new Integer[n];
        for (int i = 0; i < n; i++) {
            numsArr[i] = nums[i];
        }

        Arrays.sort(numsArr, (x, y) -> {
            long sx = 10, sy = 10;
            while (sx <= x) {
                sx *= 10;


            }
            while (sy <= y) {
                sy *= 10;
            }
            return (int) (-sy * x - y + sx * y + x);
        });

        if (numsArr[0] == 0) {
            return "0";
        }
        StringBuilder ret = new StringBuilder();
        for (int num : numsArr) {
            ret.append(num);
        }
        return ret.toString();
    }

    /**
     * @param nums
     * @return
     */
    public static int findMinThree(int[] nums) {
        int high = nums.length - 1;
        int low = 0;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else if (nums[pivot] > nums[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return nums[low];
    }

    /**
     * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/solution/xun-zhao-xuan-zhuan-pai-xu-shu-zu-zhong-5irwp/
     *
     * @param nums
     * @return
     */
    public static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else {
                low = pivot + 1;
            }
        }
        return nums[low];
    }

    /**
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/solution/shan-chu-pai-xu-shu-zu-zhong-de-zhong-fu-yec2/
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }

    /**
     * 接雨水
     * https://leetcode-cn.com/problems/volume-of-histogram-lcci/solution/zhi-fang-tu-de-shui-liang-by-leetcode-so-7rla/
     *
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }

        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; ++i) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }

    /**
     * 接雨水 stack处理
     *
     * @param height
     * @return
     */
    public int trapStack(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = height.length;
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                ans += currWidth * currHeight;
            }
            stack.push(i);
        }
        return ans;
    }

    /**
     * leetcode-cn.com/problems/subsets-ii/solution/gong-shui-san-xie-yi-ti-shuang-jie-hui-s-g77q/
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> cur = new ArrayList<>();
        dfs(nums, 0, cur, ans);
        return new ArrayList<>(ans);
    }

    /**
     * @param nums 原输入数组
     * @param u    当前决策到原输入数组中的哪一位
     * @param cur  当前方案
     * @param ans  最终结果集
     */
    static void dfs(int[] nums, int u, List<Integer> cur, Set<List<Integer>> ans) {
        // 所有位置都决策完成，将当前方案放入结果集
        if (nums.length == u) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        // 选择当前位置的元素，往下决策
        cur.add(nums[u]);
        dfs(nums, u + 1, cur, ans);

        // 不选当前位置的元素（回溯），往下决策
        cur.remove(cur.size() - 1);
        dfs(nums, u + 1, cur, ans);
    }

    /**
     * 132问题
     * https://leetcode-cn.com/problems/132-pattern/solution/132mo-shi-by-leetcode-solution-ye89/
     *
     * @param nums
     * @return
     */
    public static boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }

        // 左侧最小值
        int leftMin = nums[0];
        // 右侧所有元素
        TreeMap<Integer, Integer> rightAll = new TreeMap<Integer, Integer>();

        for (int k = 2; k < n; ++k) {
            rightAll.put(nums[k], rightAll.getOrDefault(nums[k], 0) + 1);
        }

        for (int j = 1; j < n - 1; ++j) {
            if (leftMin < nums[j]) {
                Integer next = rightAll.ceilingKey(leftMin + 1);
                if (next != null && next < nums[j]) {
                    return true;
                }
            }
            leftMin = Math.min(leftMin, nums[j]);
            rightAll.put(nums[j + 1], rightAll.get(nums[j + 1]) - 1);
            if (rightAll.get(nums[j + 1]) == 0) {
                rightAll.remove(nums[j + 1]);
            }
        }

        return false;
    }


    /**
     * 逆波兰表达式
     * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
     *
     * @param tokens
     * @return
     */
    public static int evalRPN(String[] tokens) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            switch (tokens[i]) {
                case "+":
                    int i1 = deque.pop() + deque.pop();
                    deque.push(i1);
                    continue;
                case "-":
                    int i2 = -deque.pop() + deque.pop();
                    deque.push(i2);
                    continue;
                case "*":
                    int i3 = deque.pop() * deque.pop();
                    deque.push(i3);
                    continue;
                case "/":
                    Integer pop = deque.pop();
                    int i4 = deque.pop() / pop;
                    deque.push(i4);
                    continue;
            }
            deque.push(Integer.parseInt(tokens[i]));
        }
        return deque.pop();
    }

    public static int numDistinct2(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int j = 0; j < s.length() + 1; j++) dp[0][j] = 1;
        for (int i = 1; i < t.length() + 1; i++) {
            for (int j = 1; j < s.length() + 1; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                else dp[i][j] = dp[i][j - 1];
            }
        }
        return dp[t.length()][s.length()];
    }

    /**
     * https://leetcode-cn.com/problems/distinct-subsequences/solution/dong-tai-gui-hua-yi-ci-ti-wei-li-jiang-j-enq0/
     * t[i]==s[j]   dp[i][j] = dp[i-1][j-1]+dp[i][j-1]
     * t[i]!=s[j]   dp[i][j] = dp[i][j-1]
     *
     * @return
     */
    public static int numDistinct(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (tLen > sLen) {
            return 0;
        }
        if (sLen == tLen) {
            if (s.equals(t)) {
                return 1;
            }
            return 0;
        }
        int[][] dp = new int[tLen + 1][sLen + 1];
        for (int i = 0; i <= tLen; i++) {
            if (i == 0) {
                for (int j = 0; j <= sLen; j++) {
                    if (j == 0) {
                        dp[i][j] = 1;
                    }
                }
                continue;
            }
            for (int j = 1; j <= sLen; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[tLen][sLen];
    }


    public static int[][] generateMatrix4(int n) {
        int[][] mat = new int[n][n];
        int row = 0, column = 0, nextRow = 0, nextColumn = 0, num = 1, max = n * n;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        while (num <= max) {
            mat[row][column] = num;
            num++;
            nextRow = row + directions[directionIndex][0];
            nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= n || mat[nextRow][nextColumn] != 0) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row = row + directions[directionIndex][0];
            column = column + directions[directionIndex][1];
            view(mat, n);
        }
        return mat;
    }

    public static int[][] generateMatrix3(int n) {
        int[][] mat = new int[n][n];
        int num = 1;
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int max = n * n;
        while (num <= max) {
            for (int i = l; i <= r; i++) mat[t][i] = num++;
            t++;
            for (int i = t; i <= b; i++) mat[i][r] = num++;
            r--;
            for (int i = r; i >= l; i--) mat[b][i] = num++;
            b--;
            for (int i = b; i >= t; i--) mat[i][l] = num++;
            l++;
        }
        for (int i = 0; i < n; i++) {
            int[] ints = mat[i];
            for (int j = 0; j < n; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
        return mat;
    }

    public static int[][] generateMatrix2(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while (num <= tar) {
            //上边界
            for (int i = l; i <= r; i++) mat[t][i] = num++; // left to right.
            t++;
            //下边界
            for (int i = t; i <= b; i++) mat[i][r] = num++; // top to bottom.
            r--;
            for (int i = r; i >= l; i--) mat[b][i] = num++; // right to left.
            b--;
            for (int i = b; i >= t; i--) mat[i][l] = num++; // bottom to top.
            l++;
        }
        return mat;
    }

    /**
     * https://leetcode-cn.com/problems/spiral-matrix-ii/solution/luo-xuan-ju-zhen-ii-by-leetcode-solution-f7fp/
     *
     * @param n
     * @return
     */
    public static int[][] generateMatrix(int n) {
        int maxNum = n * n;
        int curNum = 1;
        int[][] matrix = new int[n][n];
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 右下左上
        int directionIndex = 0;
        while (curNum <= maxNum) {
            matrix[row][column] = curNum;
            curNum++;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= n || matrix[nextRow][nextColumn] != 0) {
                directionIndex = (directionIndex + 1) % 4; // 顺时针旋转至下一个方向
            }
            row = row + directions[directionIndex][0];
            column = column + directions[directionIndex][1];
            view(matrix, n);
        }
        return matrix;
    }

    private static void view(int[][] a, int n) {
        for (int i = 0; i < n; i++) {
            int[] ints = a[i];
            for (int j = 0; j < n; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static boolean isValidSerialization2(String preorder) {
        int n = preorder.length();
        int i = 0;
        int slots = 1;
        while (i < n) {
            if (slots == 0) {
                return false;
            }
            if (preorder.charAt(i) == ',') {
                i++;
            } else if (preorder.charAt(i) == '#') {
                slots--;
                i++;
            } else {
                // 读一个数字
                while (i < n && preorder.charAt(i) != ',') {
                    i++;
                }
                slots++; // slots = slots - 1 + 2
            }
        }
        return slots == 0;
    }

    public static boolean isValidSerialization(String preorder) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(1);
        int length = preorder.length();
        int n = 0;
        while (n < length) {
            if (stack.isEmpty()) {
                return false;
            }

            if (preorder.charAt(n) == '#') {
                int i = stack.pop() - 1;
                if (i > 0) {
                    stack.push(i);
                }
                n++;
            } else if (preorder.charAt(n) == ',') {
                n++;
            } else {
                //是一串数字
                while (n < length && preorder.charAt(n) != ',') {
                    n++;
                }
                int i = stack.pop() - 1;
                if (i > 0) {
                    stack.push(i);
                }
                n++;
                stack.push(2);
            }
        }
        return stack.isEmpty();
    }


    public static int cal(String s) {
        Deque<Integer> deque = new LinkedList<>();
        int num = 0;
        char preSign = '+';
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || n - 1 == i) {
                switch (preSign) {
                    case '+':
                        deque.push(num);
                        break;
                    case '-':
                        deque.push(-num);
                        break;
                    case '*':
                        deque.push(deque.pop() * num);
                        break;
                    case '/':
                        deque.push(deque.pop() / num);
                        break;
                    default:
                        break;
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int sum = 0;
        while (!deque.isEmpty()) {
            sum += deque.pop();
        }
        return sum;
    }

    public static int calculate(String s) {
        Deque<Integer> stack = new LinkedList<Integer>();
        char preSign = '+';
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    //查询最小分割下的回文数字
    public static int minCut(String s) {
        int n = s.length();
        boolean[][] g = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(g[i], true);
        }

        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                g[i][j] = s.charAt(i) == s.charAt(j) && g[i + 1][j - 1];
            }
        }

        int[] f = new int[n];
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int i = 0; i < n; ++i) {
            if (g[0][i]) {
                f[i] = 0;
            } else {
                for (int j = 0; j < i; ++j) {
                    if (g[j + 1][i]) {
                        f[i] = Math.min(f[i], f[j] + 1);
                    }
                }
            }
        }

        return f[n - 1];
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
                list1.add(i - k - 1);
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

    static class TreeNode {
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

    public static TreeNode setTreeNode(int rootIndex,List<Integer> list){
        if (rootIndex >= list.size()) {
            return null;
        }
        TreeNode rootNode = new TreeNode();
        if(list.get(rootIndex)==null){
            return null;
        }
        rootNode.val = list.get(rootIndex);
        rootNode.left = setTreeNode(2 * rootIndex + 1, list);
        rootNode.right = setTreeNode(2 * rootIndex + 2, list);
        return rootNode;
    }

    public static List<String> setList(TreeNode treeNode){
        return null;
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

class MyQueue {
    Stack<Object> inStack;
    Stack<Object> outStack;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        inStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (outStack.isEmpty()) {
            inToOut();
        }
        return (Integer) outStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (outStack.isEmpty()) {
            inToOut();
        }
        return (Integer) outStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        if (inStack.isEmpty() && outStack.isEmpty()) {
            return true;
        }
        return false;
    }

    private void inToOut() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}


