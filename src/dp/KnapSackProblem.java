package dp;

import java.util.Arrays;

public class KnapSackProblem {


    public static void main(String[] args) {
        int profit[] = new int[]{60, 100, 120};
        int weight[] = new int[]{10, 20, 30};
        int W = 50;
        int n = profit.length;


        int maxProfit = knapSackUsingTopDownApproach(weight, profit, n, W);
        System.out.println("Maximum Profit " + maxProfit);
    }

    /**
     * Recursive way of solving knapsack
     *
     * @param profit
     * @param weight
     * @param w
     * @param n
     * @return
     */
    private static int knapSack(int[] profit, int[] weight, int w, int n) {

        if (w == 0 || n == 0) {
            return 0;
        }
        if (weight[n - 1] <= w) {
            return Math.max(profit[n - 1] + knapSack(profit, weight, w - weight[n - 1], n - 1), knapSack(profit, weight, w, n - 1));

        } else {
            return knapSack(profit, weight, w, n - 1);
        }
    }

    static int knapSackDp(int[] wt, int[] profits, int n, int w) {
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < w + 1; j++) {
                dp[i][j] = -1;
            }
        }
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < w + 1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return knapSackRec(wt, profits, n, w, dp);
    }

    private static int knapSackRec(int[] weight, int[] profit, int n, int w, int[][] dp) {


        if (w == 0 || n == 0) {
            return 0;
        }

        if (dp[n][w] != -1) {
            return dp[n][w];
        }
        if (weight[n - 1] <= w) {
            return dp[n][w] = Math.max(profit[n - 1] + knapSackRec(weight, profit, n - 1, w - weight[n - 1], dp), knapSackRec(weight, profit, n - 1, w, dp));

        } else {
            return dp[n][w] = knapSackRec(weight, profit, n - 1, w, dp);
        }
    }

    /**
     * KnapSack using top dowm approach
     */

    public static int knapSackUsingTopDownApproach(int[] wt, int[] val, int n, int W) {

        int dp[][] = new int[n + 1][W + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }


        return dp[n][W];
    }

}
