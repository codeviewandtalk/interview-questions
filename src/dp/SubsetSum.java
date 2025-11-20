package dp;

import java.util.Arrays;

public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        boolean result = findSubsetSum(arr, sum);
        System.out.println(result);

    }

    private static boolean findSubsetSum(int[] arr, int sum) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < sum+1; j++) {
                if (i == 0) {
                    dp[i][j] = false;
                }
                if (j == 0) {
                    dp[i][j] = true;
                }
            }
        }
       // System.out.println(Arrays.deepToString(dp));
        return isSubsetSum(arr, sum, n, dp);
    }

    private static boolean isSubsetSum(int[] arr, int sum, int n, boolean[][] dp) {

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i][j - arr[i - 1]] || dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
