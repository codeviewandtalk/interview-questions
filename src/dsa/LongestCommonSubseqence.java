package dsa;

public class LongestCommonSubseqence {
    public static void main(String[] args) {
        String s1 = "ABCBDAB";
        String s2 = "BDCAB";

        // Find the length of the LCS
        int length = longestCommonSubsequence(s1, s2);
        System.out.println("Length of LCS: " + length);

        // Find the actual LCS string
        String lcs = printLCS(s1, s2);
        System.out.println("LCS: " + lcs);
    }

    // Function to find the length of LCS
    public static int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        // Create a DP table to store lengths of LCS
        int[][] dp = new int[m + 1][n + 1];

        // Build the DP table from bottom up
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;  // If characters match
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);  // Otherwise, take the max of excluding one character
                }
            }
        }

        // The length of the LCS will be in dp[m][n]
        return dp[m][n];
    }

    // Function to reconstruct the LCS from the DP table
    public static String printLCS(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        // Create the DP table again
        int[][] dp = new int[m + 1][n + 1];

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // Reconstruct the LCS from the DP table
        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;

        // Trace back the LCS
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs.insert(0, s1.charAt(i - 1));  // Add to the front of the result
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return lcs.toString();
    }


    }

