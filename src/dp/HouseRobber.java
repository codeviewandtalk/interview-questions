package dp;

import java.util.Arrays;

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and
 * it will automatically contact the police if two adjacent houses were broken into on the same night.
 */
public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int maxMoney = rob(nums);
        System.out.println(maxMoney);
    }

    public static int rob(int[] nums) {
        int n = nums.length;
        //if  only 1 element
        if (nums.length < 2) {
            return nums[0];
        }

        // Create array to store maximum loot at each index
        int dp[] = new int[n];

        //Memoize maximum loots at first 2 index
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        //use them to fill full array

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[n - 1];
    }
}
