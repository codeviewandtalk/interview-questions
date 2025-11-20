package dsa;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        // Sort array by using merge sort algorithm
        int[] arr = {9, 5, 2, 18, 27, 65, 1};
        System.out.println("***** Unsorted Array ********");
        System.out.println(Arrays.toString(arr));
        int end = arr.length;
        sort(arr, 0, end-1);
        System.out.println("***** Sorted Array ********");
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int start, int end) {

        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;

        sort(arr, start, mid);
        sort(arr, mid + 1, end);
        merge(arr, start, mid, end);


    }

    private static void merge(int[] arr, int start, int mid, int end) {

        int[] merged = new int[end - start + 1];

        int idx1 = start;
        int idx2 = mid + 1;
        int k = 0;

        while (idx1 <= mid && idx2 <= end) {

            if (arr[idx1] <= arr[idx2]) {
                merged[k++] = arr[idx1++];
            } else {
                merged[k++] = arr[idx2++];
            }
        }

        while (idx1 <= mid) {
            merged[k] = arr[idx1];
            idx1++;
            k++;
        }

        while (idx2 <= end) {
            merged[k] = arr[idx2];
            idx2++;
            k++;

        }

        for (int i = 0, j = start; i <merged.length; i++, j++) {
            arr[j] = merged[i];
        }

    }

}


