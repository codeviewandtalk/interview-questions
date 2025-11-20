package Test;

public class CountOccrance {
    public static void main(String[] args) {
        int arr[] = {1, 1, 2, 2, 2, 2, 3};
        int x = 2;
        CountOccrance obj = new CountOccrance();
        int result = obj.findFirstOccurance(arr, x);
        int res = obj.findLastOccurance(arr, x);
        System.out.println(res - result + 1);
    }

    private int findFirstOccurance(int[] arr, int x) {
        int high = arr.length - 1;
        int low = 0;
        int count = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                count = mid;
                high = mid - 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return count;
    }

    private int findLastOccurance(int[] arr, int x) {
        int high = arr.length - 1;
        int low = 0;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                result = mid;
                low = mid + 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
}
