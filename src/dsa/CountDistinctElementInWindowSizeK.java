package dsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountDistinctElementInWindowSizeK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 4, 5, 6, 7, 7, 6};
        int k = 4;

        List<Integer> result = countDistinctElementInWindowSize(arr, k);
        System.out.println(result);
    }

    private static List<Integer> countDistinctElementInWindowSize(int[] arr, int k) {
        int length = arr.length;
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int i = 0; i < k; i++) {
            frequency.put(arr[i], frequency.getOrDefault(arr[i], 0) + 1);
        }
        result.add(frequency.size());
        for (int i = k; i < length; i++) {
            frequency.put(arr[i], frequency.getOrDefault(arr[i], 0) + 1);
            frequency.put(arr[i - k], frequency.get(arr[i - k]) - 1);

            if (frequency.get(arr[i - k]) == 0) {
                frequency.remove(arr[i - k]);
            }
            result.add(frequency.size());
        }
        return result;
    }
}
