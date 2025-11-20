package dsa;

public class MaximumProductSubArray {
    public static void main(String[] args) {
        int[] arr = {2, 3, -2, 4};
        int max1 = findMaximumProductSubArray(arr);
        System.out.println(max1);
    }

    private static int findMaximumProductSubArray(int[] arr) {
        int prefix = 1, suffix = 1;
        int max = Integer.MIN_VALUE;
        int n = arr.length - 1;
        for (int i = 0; i <= n; i++) {
            if (prefix == 0) {
                prefix = 1;
            }

            if (suffix == 0) {
                suffix = 1;
            }

            prefix = prefix * arr[i];
            suffix = suffix * arr[n - i];
            max = Math.max(max, Math.max(prefix, suffix));
        }
        return max;
    }
}
