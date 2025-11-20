package dsa;

import java.util.ArrayList;
import java.util.List;

public class SplitArrayInChunkOfK {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 6, 7, 8,9};
        int N = nums.length;
        int K = 4;
        List<List<Integer>> ans = divideArray(nums, K, N);
        System.out.println(ans);
    }

    private static List<List<Integer>> divideArray(int[] nums, int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            temp.add(nums[i]);
            if ((i + 1) % k == 0) {
                ans.add(temp);
                temp = new ArrayList<>();
            }
        }
        if(!temp.isEmpty()){
            int a = temp.size();
            while (a!=k){
                temp.add(0);
                a++;
            }
            ans.add(temp);
        }
        return ans;
    }
}
