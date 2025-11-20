package dp;

/**
 * Given an integer array of coins[] of size n representing different types of denominations
 * and an integer sum,
 * the task is to count all combinations of coins to make a given value sum.
 * Note: Assume that you have an infinite supply of each type of coin.
 */
public class CoinChange2 {
    public static void main(String[] args) {
        int[] coins = {1, 2,3}; //[{1,1,1,1}{1,1,2}{2,2}{1,3}]
        int amount = 4;
        int numberOfCombinations = coinChange2(coins, amount);
        System.out.println("Number of combinations for given sum: " + numberOfCombinations);
    }

    private static int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // There's 1 way to make amount 0 — by choosing no coins
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
