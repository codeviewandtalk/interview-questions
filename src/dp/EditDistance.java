package dp;

import java.util.Arrays;

public class EditDistance {
    public static void main(String[] args) {
//        Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
//        You have the following three operations permitted on a word:
//        Insert a character
//        Delete a character
//        Replace a character
//        Example 1:
//        Input: word1 = "horse", word2 = "ros"
//        Output: 3

//        EditDistance solver = new EditDistance();
//        System.out.println(solver.minDistance("horse", "ros")); // Output: 3
//        System.out.println(solver.minDistance("intention", "execution")); // Output: 5

        int minMove = findMinimumNumberOfOperation("horse", "ros");
        System.out.println(minMove);
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        // Initialize base cases
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i; // delete all characters from word1
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j; // insert all characters to word1
        }

        // Compute edit distance
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // characters match, no operation needed
                } else {
                    dp[i][j] = 1 + Math.min(
                            dp[i - 1][j - 1], // replace
                            Math.min(dp[i - 1][j], // delete
                                    dp[i][j - 1]) // insert
                    );
                }
            }
        }

        return dp[m][n];
    }


    public static int findMinimumNumberOfOperation(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j < n; j++) {
            dp[0][j] = j;
        }

        for(int i=1; i<=m; i++){
            for(int j=1;j<=n;j++){

                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    int topLeft=dp[i-1][j-1];
                    int top= dp[i-1][j];
                    int left=dp[i][j-1];
                    dp[i][j] = Math.min(topLeft,Math.min(top,left))+1;
                }
            }
        }
        return dp[m][n];
    }
}
