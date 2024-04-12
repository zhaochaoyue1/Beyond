package com.example.test2;


import com.alibaba.fastjson.JSONObject;
import com.example.hashmap_concurrenthashmap.HashM;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.*;

public class Test3 {



    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        /*String[] strings = {"one.two.three", "four.five", "six"};
        List<String> strings1 = splitWordsBySeparator(Arrays.asList(strings), '.');
        System.out.println(JSONObject.toJSONString(strings1));
        Integer[] ints = {5, 10, 1, 5, 2};*/
        //System.out.println(countPaths(5,new int[][]{{1,2},{1,3},{2,4},{2,5}}));
        //System.out.println(minIncrements(7,new int[]{1,5,2,2,3,3,1}));
        //System.out.println(validPartition(new int[]{1,1,1,2}));
        //System.out.println(countPaths2(7,new int[][]{{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}}));
        //System.out.println(firstDayBeenInAllRooms(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
        //List<String> list = new ArrayList<>();
        //backtrack2("abc","",0,list,2);
        //backtrack("abc".toCharArray(),0,list);
        //System.out.println(JSONObject.toJSON(list));
        System.out.println(maximumBinaryString("000110"));
        Deque<Integer> deque = new ArrayDeque<>();

    }

    public String maximumBinaryString2(String binary) {
        int n = binary.length(), i = binary.indexOf('0');
        if (i < 0) {
            return binary;
        }
        int zeros = 0;
        StringBuilder s = new StringBuilder();
        for (int j = 0; j < n; j++) {
            if (binary.charAt(j) == '0') {
                zeros++;
            }
            s.append('1');
        }
        s.setCharAt(i + zeros - 1, '0');
        return s.toString();
    }


    public static String maximumBinaryString(String binary) {
        int n = binary.length();
        char[] s = binary.toCharArray();
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == '0') {
                if(j<=i){
                   j=i+1;
                }
                while (j < n && s[j] == '1') {
                    j++;
                }
                if (j < n) {
                    s[j] = '1';
                    s[i] = '1';
                    s[i + 1] = '0';
                }
            }
        }
        return new String(s);
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }


    public int maximumCount(int[] nums) {
        int positive = 0;
        int negative = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0){
                positive++;
            }
            if(nums[i]<0){
                negative++;
            }
        }
        return Math.max(positive, negative);
    }

    private static void backtrack2(String source,String s, int start, List<String> result,int end) {
        if (start > end) {
            result.add(s);
            return;
        }
        backtrack2(source, s+source.charAt(start),start + 1, result,end);
        backtrack2(source,s,start+1,result,end);
    }

    private static void backtrack(char[] chars, int start, List<String> result) {
        if (start == chars.length - 1) {
            result.add(new String(chars));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = start; i < chars.length; i++) {
            if (set.contains(chars[i])) {
                continue;
            }
            set.add(chars[i]);
            swap(chars, start, i);
            backtrack(chars, start + 1, result);
            swap(chars, start, i);
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static int minOperations(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        List<Integer> sortedUniqueNums = new ArrayList<Integer>(set);
        Collections.sort(sortedUniqueNums);
        int res = n;
        int j = 0;
        for (int i = 0; i < sortedUniqueNums.size(); i++) {
            int left = sortedUniqueNums.get(i);
            int right = left + n - 1;
            while (j < sortedUniqueNums.size() && sortedUniqueNums.get(j) <= right) {
                res = Math.min(res, n - (j - i + 1));
                j++;
            }
        }
        return res;
    }

    public static int minimumSum2(int[] nums) {
        int n = nums.length, res = 1000, mn = 1000;
        int[] left = new int[n];
        for (int i = 1; i < n; i++) {
            left[i] = mn = Math.min(nums[i - 1], mn);
        }
        System.out.println(JSONObject.toJSON(left));
        int right = nums[n - 1];
        for (int i = n - 2; i > 0; i--) {
            if (left[i] < nums[i] && nums[i] > right) {
                res = Math.min(res, left[i] + nums[i] + right);
            }
            right = Math.min(right, nums[i]);
        }

        return res < 1000 ? res : -1;
    }

    public static int minimumSum(int[] nums) {
        int sum = -1;
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if(nums[i]<nums[j]&&nums[k]<nums[j]){
                        int i1 = nums[i] + nums[j] + nums[k];
                        sum = sum>0?Math.min(i1,sum):i1;
                    }
                }
            }
        }
        return sum;
    }

    public static int firstDayBeenInAllRooms(int[] nextVisit) {

        int mod = 1000000007;
        int len = nextVisit.length;
        int[] dp = new int[len];

        dp[0] = 2; //初始化原地待一天 + 访问下一个房间一天
        for (int i = 1; i < len; i++) {
            int to = nextVisit[i];
            dp[i] = 2 + dp[i - 1];
            if (to != 0) {
                dp[i] = (dp[i] - dp[to - 1] + mod) % mod; //避免负数
            }

            dp[i] = (dp[i] + dp[i - 1]) % mod;
        }
        return dp[len - 2]; //题目保证n >= 2
    }

    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }


    public int minNonZeroProduct(int p) {
        if (p == 1) {
            return 1;
        }
        long mod = (int)1e9+7;
        long x = fastPow(2, p, mod) - 1;
        long y = (long) 1 << (p - 1);
        return (int) (fastPow(x - 1, y - 1, mod) * x % mod);
    }

    public long fastPow(long x, long n, long mod) {
        long res = 1;
        for (; n != 0; n >>= 1) {
            if ((n & 1) != 0) {
                res = res * x % mod;
            }
            x = x * x % mod;
        }
        return res;
    }


    public static int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int left = k - 1, right = k + 1;
        int ans = 0;
        for (int i = nums[k];; --i) {
            while (left >= 0 && nums[left] >= i) {
                --left;
            }
            while (right < n && nums[right] >= i) {
                ++right;
            }
            ans = Math.max(ans, (right - left - 1) * i);
            if (left == -1 && right == n) {
                break;
            }
        }
        return ans;
    }



    public long maxArrayValue(int[] nums) {
        long sum = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            sum = nums[i] <= sum ? nums[i] + sum : nums[i];
        }
        return sum;
    }

    public String maximumOddBinaryNumber2(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            cnt += s.charAt(i) - '0';
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cnt - 1; i++) {
            sb.append('1');
        }
        for (int i = 0; i < s.length() - cnt; i++) {
            sb.append('0');
        }
        sb.append('1');
        return sb.toString();
    }

    public static String maximumOddBinaryNumber(String s) {
        char[] arr = s.toCharArray();
        int high = 0;int low = s.length() - 1;
        while (high < low) {
            //找到右边第一个1
            if (low == s.length()-1) {
                if(s.charAt(low) == '1'&& high < low){
                    low--;
                    continue;
                }
                while (s.charAt(low) != '1' && high < low){
                    --low;
                }
                if( high > low){
                    return s;
                }
                arr[low]='0';
                arr[s.length()-1] = '1';
                --low;
                continue;
            }
            if(s.charAt(low) == '0'){
                low--;
            }else {
                while (s.charAt(high)== '1'&&high < low){
                    high++;
                }
                if( high >= low){
                    return new String(arr);
                }
                arr[high]='1';
                arr[low] = '0';
                ++high;
                --low;
            }

        }
        return new String(arr);
    }

    static int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 1000) ? 1000 : n + 1;
    }

    public static int minimumPossibleSum(int n, int target) {
        final int MOD = (int) 1e9 + 7;
        int m = target / 2;
        if (n <= m) {
            return (int) ((long) (1 + n) * n / 2 % MOD);
        }
        return (int) (((long) (1 + m) * m / 2 +
                ((long) target + target + (n - m) - 1) * (n - m) / 2) % MOD);
    }

    public static int countPaths2(int n, int[][] roads) {
        int mod = 1000000007;
        List<int[]>[] e = new List[n];
        for (int i = 0; i < n; i++) {
            e[i] = new ArrayList<int[]>();
        }
        for (int[] road : roads) {
            int x = road[0], y = road[1], t = road[2];
            e[x].add(new int[]{y, t});
            e[y].add(new int[]{x, t});
        }
        long[] dis = new long[n];
        Arrays.fill(dis, Long.MAX_VALUE);
        int[] ways = new int[n];

        PriorityQueue<long[]> pq = new PriorityQueue<long[]>((a, b) -> Long.compare(a[0], b[0]));
        pq.offer(new long[]{0, 0});
        dis[0] = 0;
        ways[0] = 1;

        while (!pq.isEmpty()) {
            long[] arr = pq.poll();
            long t = arr[0];
            int u = (int) arr[1];
            if (t > dis[u]) {
                continue;
            }
            for (int[] next : e[u]) {
                int v = next[0], w = next[1];
                if (t + w < dis[v]) {
                    dis[v] = t + w;
                    ways[v] = ways[u];
                    pq.offer(new long[]{t + w, v});
                } else if (t + w == dis[v]) {
                    ways[v] = (ways[u] + ways[v]) % mod;
                }
            }
        }
        return ways[n - 1];
    }


    public boolean validPartition2(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            if (i >= 2) {
                dp[i] = dp[i - 2] && validTwo(nums[i - 2], nums[i - 1]);
            }
            if (i >= 3) {
                dp[i] = dp[i] || (dp[i - 3] && validThree(nums[i - 3], nums[i - 2], nums[i - 1]));
            }
        }
        return dp[n];
    }

    public boolean validTwo(int num1, int num2) {
        return num1 == num2;
    }

    public boolean validThree(int num1, int num2, int num3) {
        return (num1 == num2 && num1 == num3) || (num1 + 1 == num2 && num2 + 1 == num3);
    }

    public static boolean validPartition(int[] nums) {
        return dsf(nums, 0);
    }

    public static boolean dsf(int[] nums, int num) {
        if (num == nums.length) {
            return true;
        }
        if (num + 1 >= nums.length) {
            return false;
        }
        boolean bool = false;
        if (nums[num] == nums[num + 1]) {
            bool = dsf(nums, num + 2);
        }
        if (nums[num] == nums[num + 1] && nums.length > num + 2 && nums[num] == nums[num + 2]) {
            bool = bool || dsf(nums, num + 3);
        }
        if (nums[num] == nums[num + 1] - 1 && nums.length > num + 2 && nums[num] == nums[num + 2] - 2) {
            bool = bool || dsf(nums, num + 3);
        }
        return bool;
    }

    public static int minIncrements(int n, int[] cost) {
        int ans = 0;
        for (int i = n - 2; i > 0; i -= 2) {
            ans += Math.abs(cost[i] - cost[i + 1]);
            // 叶节点 i 和 i+1 的双亲节点下标为 i/2（整数除法）
            cost[i / 2] += Math.max(cost[i], cost[i + 1]);
        }
        return ans;
    }


    // 埃氏筛
    private static final int N = 100001;
    private static final boolean[] isPrime = new boolean[N];

    static {
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        for (int i = 2; i * i < N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < N; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    public static long countPaths(int n, int[][] edges) {
        List<Integer>[] G = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            G[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int i = edge[0], j = edge[1];
            G[i].add(j);
            G[j].add(i);
        }

        List<Integer> seen = new ArrayList<>();
        long res = 0;
        long[] count = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!isPrime[i]) {
                continue;
            }
            long cur = 0;
            for (int j : G[i]) {
                if (isPrime[j]) {
                    continue;
                }
                if (count[j] == 0) {
                    seen.clear();
                    dfs(G, seen, j, 0);
                    long cnt = seen.size();
                    for (int k : seen) {
                        count[k] = cnt;
                    }
                }
                res += count[j] * cur;
                cur += count[j];
            }
            res += cur;
        }
        return res;
    }

    private static void dfs(List<Integer>[] G, List<Integer> seen, int i, int pre) {
        seen.add(i);
        for (int j : G[i]) {
            if (j != pre && !isPrime[j]) {
                dfs(G, seen, j, i);
            }
        }
    }

    /**
     * public TreeNode buildTree(int[] preorder, int[] inorder) {
     * if (preorder == null || preorder.length == 0) {
     * return null;
     * }
     * TreeNode root = new TreeNode(preorder[0]);
     * Deque<TreeNode> stack = new LinkedList<TreeNode>();
     * stack.push(root);
     * int inorderIndex = 0;
     * for (int i = 1; i < preorder.length; i++) {
     * int preorderVal = preorder[i];
     * TreeNode node = stack.peek();
     * if (node.val != inorder[inorderIndex]) {
     * node.left = new TreeNode(preorderVal);
     * stack.push(node.left);
     * } else {
     * while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
     * node = stack.pop();
     * inorderIndex++;
     * }
     * node.right = new TreeNode(preorderVal);
     * stack.push(node.right);
     * }
     * }
     * return root;
     * }
     * <p>
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solutions/255811/cong-qian-xu-yu-zhong-xu-bian-li-xu-lie-gou-zao-9/
     */

    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.size(); ++i) {
            if (bitCount(i) == k) {
                ans += nums.get(i);
            }
        }
        return ans;
    }

    public int bitCount(int x) {
        int cnt = 0;
        while (x != 0) {
            cnt += (x % 2);
            x /= 2;
        }
        return cnt;
    }

    public static List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> list = new ArrayList<>();
        for (String str : words) {
            int start = 0;
            int end = 0;
            for (int w = 0; w < str.length(); w++) {
                if (str.charAt(w) == separator) {
                    if (start == end) {
                        start++;
                        end++;
                        continue;
                    }
                    list.add(str.substring(start, end));
                    start = w + 1;
                    end = start;
                    continue;
                }
                end++;
            }
            if (start != end) {
                list.add(str.substring(start, end));
            }
        }
        return list;
    }

    public static long minimumRemoval(int[] beans) {
        int n = beans.length;
        Arrays.sort(beans);
        long total = 0; // 豆子总数
        for (int i = 0; i < n; i++) {
            total += beans[i];
        }
        long res = total; // 最少需要移除的豆子数
        for (int i = 0; i < n; i++) {
            res = Math.min(res, total - (long) beans[i] * (n - i));
        }
        return res;
    }

    public static int maximumNumberOfStringPairs(String[] words) {
        HashSet<String> strings = new HashSet<>();
        int sum = 0;
        for (String s : words) {
            if (strings.contains(s.charAt(1) + "" + s.charAt(0))) {
                sum++;
            }
            strings.add(s);
        }
        return sum;
    }

    public static int count(String num1, String num2, int min_sum, int max_sum) {
        int m = 10 ^ 9 + 7;
        int sum = 0;
        for (long i = Long.parseLong(num1); i <= Long.parseLong(num2); i++) {
            long j = i;
            int a = 0;
            while (j > 0) {
                a += j % 10;
                j = j / 10;
            }
            if (a >= min_sum && a <= max_sum) {
                sum = (sum + 1) % m;
            }
        }
        return sum;
    }

    public static int countWords(String[] words1, String[] words2) {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        Arrays.stream(words1).forEach(s -> map1.put(s, map1.getOrDefault(s, 0) + 1));
        Arrays.stream(words2).forEach(s -> map2.put(s, map2.getOrDefault(s, 0) + 1));
        int sum = 0;
        Set<String> strings = map1.keySet();
        for (Map.Entry<String, Integer> entrySet : map2.entrySet()) {
            if (entrySet.getValue() == 1) {
                sum++;
            }
        }

        return sum;
    }
}
