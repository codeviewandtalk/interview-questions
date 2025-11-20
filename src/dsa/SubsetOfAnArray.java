package dsa;

import java.util.HashSet;
import java.util.Set;

public class SubsetOfAnArray {
    public static void main(String[] args) {
        //Check if an array is subset of another array
        int[] a = { 11, 1, 13, 21, 3, 7 };
        int[] b = { 11, 3, 7, 1 };

        if (isSubset(a, b)) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }

    private static boolean isSubset(int[] arr1, int[] arr2) {

        Set<Integer> set = new HashSet<>();
        for(int i=0; i<arr1.length;i++){
            set.add(arr1[i]);
        }
        for(int j=0; j<arr2.length;j++){
            if(!set.contains(arr2[j])){
                return false;
            }
        }
        return true;
    }
}
