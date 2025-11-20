package dsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        //Subarray With Given Sum (Sliding window)
        //LeetCode- 560
        int[] arr = {15, 2, 4, 8, 9, 5, 10, 23};
        int target = 23;
        List<Integer> res = subarraySum(arr, target);
        System.out.println(res);

        int ress = subarraySums(arr, target);
        System.out.println(ress);
    }

    private static List<Integer> subarraySum(int[] arr, int target) {
        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = 0;
        int sum = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (sum < target) {
                right++;
                sum += arr[right];
            } else if (sum > target) {
                sum -= arr[left];
                left++;
            } else {
                while (left <= right) {
                    result.add(arr[left]);
                    left++;
                }

            }
        }
        return result;
    }

   private static int subarraySums(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
