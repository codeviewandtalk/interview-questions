package dp;

public class LongestCommonSubSequence {
    public static void main(String[] args) {
        String s1 = "ABC";
        String s2 = "ACD";
        int result = LCSUsingRecursion(s1, s2, s1.length(), s2.length());
        System.out.println(result);
        int res = LcsUsingTopDownDp(s1, s2, s1.length(), s2.length());
        System.out.println(res);
        System.out.println(printLongestCommonSubsequence(s1, s2, s1.length(), s2.length()));
    }

    /**
     * using recursion
     *
     * @param s1
     * @param s2
     * @param m
     * @param n
     * @return
     */
    public static int LCSUsingRecursion(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return 1 + LCSUsingRecursion(s1, s2, m - 1, n - 1);
        } else {
            return Math.max(LCSUsingRecursion(s1, s2, m - 1, n), LCSUsingRecursion(s1, s2, m, n - 1));
        }
    }

    public static int LcsUsingTopDownDp(String s1, String s2, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static String printLongestCommonSubsequence(String s1, String s2, int m, int n) {

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        StringBuilder result = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                result.append(s1.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i][j - 1] > dp[i - 1][j]) {
                    j--;
                } else {
                    i--;
                }
            }
        }
        return new StringBuilder(result).reverse().toString();
    }
}
