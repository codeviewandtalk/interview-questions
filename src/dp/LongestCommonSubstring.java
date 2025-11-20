package dp;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "abfce";
        int result = longestCommonSubstring(s1, s2, s1.length(), s2.length());
        System.out.println(result);
    }

    /**
     * Using top-down approach(parent question is lcs)
     * @param s1
     * @param s2
     * @param m
     * @param n
     * @return
     */
    public static int longestCommonSubstring(String s1, String s2, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int maxLength = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLength = Math.max(dp[i][j], maxLength);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return maxLength;
    }
}
