package dsa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumProblem {
    public static void main(String[] args) {

        // LeetCode Problem -1
        int[] arr = {2,7,11,15};
        int target=9;
        int[] res= twoSumProblem(arr,target);
        System.out.println(Arrays.toString(res));
    }

    private static int[] twoSumProblem(int[] arr, int target) {
        Map<Integer,Integer> map= new HashMap<>();
        for(int i=0; i<arr.length; i++){
            map.put(arr[i],i);
        }

        for(int i=0; i< arr.length; i++){
            int complement = target-arr[i];
            if(map.containsKey(complement) && map.get(complement)!=i){
                return new int[]{i,map.get(complement)};
            }
        }
        return null;
    }
}
