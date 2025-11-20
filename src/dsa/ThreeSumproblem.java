package dsa;

import java.util.*;

public class ThreeSumproblem {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        int target = 0;

        List<List<Integer>> results = threeSumProblemSortAlgorithm(arr, target);
        System.out.println(results);
    }



    private static List<List<Integer>> threeSumProblemSortAlgorithm(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || arr[i] != arr[i - 1]) {
                twoSumSorted(i + 1, arr.length - 1, arr, 0 - arr[i], result);
            }
        }
        return result;

    }

    private static void twoSumSorted(int i, int j, int[] arr, int target, List<List<Integer>> result) {
        int a = arr[i - 1];

        while (i < j) {

            if (arr[i] + arr[j] > target) {
                j--;
            } else if (arr[i] + arr[j] < target) {
                i++;
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(a);
                list.add(arr[i]);
                list.add(arr[j]);

                result.add(list);

                //Duplicate b and c
                while (i < j && arr[i] == arr[i + 1]) {
                    i++;
                }

                while (i < j && arr[j] == arr[j - 1]) {
                    j--;
                }
                i++;
                j--;
            }
        }
    }

}
