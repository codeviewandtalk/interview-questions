package Test;

import java.util.Arrays;

public class TestCode {
    public static void main(String[] args) {
        int[] nums = {7,7,7,7,7,7,7};

        int maxLength = longestSubSequence(nums);
        System.out.println(maxLength);

    }

    private static int longestSubSequence(int[] nums) {
        int length = nums.length;
        int[] n = new int[length];  //0,1,0,3,2,3

        for (int i = 0; i < length; i++) {
            n[i] = 1;
        }

        int maxLength = 1;

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    n[i] = Math.max(n[i], n[j]+1);
                }
            }
            maxLength = Math.max(maxLength, n[i]);
        }
        return maxLength;
    }
}
