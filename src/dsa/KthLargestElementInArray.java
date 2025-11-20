package dsa;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInArray {
    public static void main(String[] args) {
        // Find the Kth largest element in an array
        int[] arr = {4, 6, 3, 7, 9, 10};
        int k = 2;

        int kthLargestElement = findKthLargestElement(arr, k);
        System.out.println(kthLargestElement);

    }

    private static int findKthLargestElement(int[] arr, int k) {
        int length = arr.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < length; i++) {
            queue.offer(arr[i]);
        }

        for (int j = 1; j < k; j++) {
            queue.poll();
        }

        return queue.peek();

    }
}
