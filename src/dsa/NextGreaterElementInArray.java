package dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NextGreaterElementInArray {
    public static void main(String[] args) {
        int[] arr = {6, 8, 0, 1, 3};
        int[] res = nextLargerElement(arr);
        System.out.println(Arrays.toString(res));
    }

    private static int[] nextLargerElement(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>(); // stack stores indices

        for (int i = n - 1; i >= 0; i--) {
            // Pop elements that are less than or equal to nums[i]
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }

            // If stack is empty, no greater element to the right
            result[i] = stack.isEmpty() ? -1 : nums[stack.peek()];

            // Push current index to stack
            stack.push(i);
        }

        return result;
    }
}
