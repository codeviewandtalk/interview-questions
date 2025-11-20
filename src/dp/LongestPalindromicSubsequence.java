package dp;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String s1 = "bbabcbcab";
        String s2 = new StringBuilder(s1).reverse().toString();
        int result = longestPalindromicSubsequence(s1, s2, s1.length(), s2.length());
        System.out.println(result);
    }

    private static int longestPalindromicSubsequence(String s1, String s2, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[j][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
