import java.util.Scanner;

public class SuffixArray {

    static final int maxn = 200005;

    static int[] a1 = new int[maxn];
    static int[] a2 = new int[maxn];
    static int[] ss = new int[maxn];

    static boolean cmp(int[] r, int i, int j, int len) {
        return (r[i] == r[j] && r[i + len] == r[j + len]);
    }

    static void sa_get(int[] r, int[] sa, int n, int m) {
        int i, j, p;
        int[] x = a1, y = a2, t;

        for (i = 0; i < m; ++i) ss[i] = 0;
        for (i = 0; i < n; ++i) ss[x[i] = r[i]]++;
        for (i = 1; i < m; ++i) ss[i] += ss[i - 1];
        for (i = n - 1; i >= 0; --i) sa[--ss[x[i]]] = i;

        for (j = 1, p = 1; p < n; j *= 2, m = p) {
            for (p = 0, i = n - j; i < n; ++i) y[p++] = Math.max(i, 0);
            for (i = 0; i <= n; ++i) if (sa[i] >= j) y[p++] = sa[i] - j;

            for (i = 0; i < m; ++i) ss[i] = 0;
            for (i = 0; i < n; ++i) ss[x[y[i]]]++;
            for (i = 1; i < m; ++i) ss[i] += ss[i - 1];
            for (i = n - 1; i >= 0; --i) sa[--ss[x[y[i]]]] = y[i];

            for (t = x, x = y, y = t, p = 1, x[sa[0]] = 0, i = 1; i < n; ++i)
                x[sa[i]] = cmp(y, sa[i - 1], sa[i], j) ? p - 1 : p++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int sum = s.length();
        int[] num = new int[maxn];

        for (int b = 0; b < sum; ++b) {
            num[b] = s.charAt(b) - 'a' + 1;
        }
        num[sum++] = 0; // 补上最小字符

        int[] sa = new int[maxn];
        sa_get(num, sa, sum, 128);

        for (int b = 0; b < sum - 1; ++b) {
            System.out.print((sa[b] + 1) + " ");
        }
        System.out.println((sa[sum - 1] + 1));
    }
}


