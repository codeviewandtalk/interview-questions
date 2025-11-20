package dp;

import java.util.Arrays;

public class ClimbStairs {
    public static void main(String[] args) {
        int n = 3;
        int min = minNumberToGoTop(n);
        System.out.println(min);
        int min1 = countWays(n);
        System.out.println("second " + min1);
        System.out.println("Dp " + climbStairsUsingDp(n));
    }

    private static int minNumberToGoTop(int n) {

        int[] dp = new int[n + 1];

        Arrays.fill(dp, -1);

        if (n < 0) {
            return 0;
        }
        if (n == 0 || n == 1) {
            return dp[n] = 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        dp[n] = minNumberToGoTop(n - 1) + minNumberToGoTop(n - 2);
        return dp[n];
    }

    // Java program to count number of ways to
    // reach nth stair using Space Optimized DP
    static int countWays(int n) {

        // variable prev1, prev2 - to store the
        // values of last and second last states
        int prev1 = 1;
        int prev2 = 1;

        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        // In last iteration final value
        // of curr is stored in prev.
        return prev1;
    }

    public static int climbStairsUsingDp(int n) {
        if (n == 1)
            return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <=n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }

}
