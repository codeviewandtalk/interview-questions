package dp;

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed.
 * All houses at this place are arranged in a circle.
 * That means the first house is the neighbor of the last one.
 * Meanwhile, adjacent houses have a security system connected,
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 */
public class HouseRobber2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int n = nums.length;
        int r1 = robber1(nums, 1, n - 1);
        int r2 = robber1(nums, 0, n - 2);
        System.out.println(Math.max(r1, r2));
    }

    private static int robber1(int[] nums, int start, int end) {
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[end];
    }
}
