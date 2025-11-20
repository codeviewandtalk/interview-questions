package dsa;

import java.util.Arrays;

public class RowWithMaximumOne {
    public static void main(String[] args) {
        int[][] mat = {{0, 0, 0}, {0, 1, 1}};
        int[] ans =rowAndMaximumOnes(mat);
        System.out.println(Arrays.toString(ans));

    }

    public static int[] rowAndMaximumOnes(int[][] mat) {
        int row = 0;
        int countOfOne = 0;
        int max = 0;
        int[] ans = new int[2];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    countOfOne++;
                }
            }
            if (ans[1] < countOfOne) {
                ans[1] = countOfOne;
                ans[0] = i;
            }
            countOfOne = 0;
        }
        return ans;
    }
}
