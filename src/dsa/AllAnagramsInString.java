package dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllAnagramsInString {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String t = "abc";
        List<Integer> result = findAnagramIndices(s, t);
        System.out.println("bruteForce " + result);
        List<Integer> res = optimizedFindAnagramIndices(s, t);
        System.out.println("optimized " + res);
    }

    /**
     * brute force method
     *
     * @param s
     * @param t
     * @return
     */
    private static List<Integer> findAnagramIndices(String s, String t) {
        List<Integer> result = new ArrayList<>();
        int sl = s.length();
        int tl = t.length();
        char[] arr2 = t.toCharArray();
        Arrays.sort(arr2);
        String temp = "";
        for (int i = 0; i < sl - 2; i++) {
            for (int j = i; j <= i + 2; j++) {
                temp = temp + s.charAt(j);
            }
            char[] curwin = temp.toCharArray();
            Arrays.sort(curwin);
            temp = "";
            if (Arrays.equals(curwin, arr2)) {
                result.add(i);
            }
        }
        return result;
    }

    /**
     * @param s
     * @param t
     * @return
     */
    private static List<Integer> optimizedFindAnagramIndices(String s, String t) {
        List<Integer> result = new ArrayList<>();
        if (s == null || t == null || s.length() < t.length()) {
            return result;
        }
        int[] targetFrequency = new int[26];
        for (int i = 0; i < t.length(); i++) {
            targetFrequency[t.charAt(i) - 'a']++;
        }
        int[] windowFrequency = new int[26];
        int targetLength = t.length();

        for (int i = 0; i < s.length(); i++) {
            windowFrequency[s.charAt(i) - 'a']++;
            if (i >= targetLength) {
                windowFrequency[s.charAt(i - targetLength) - 'a']--;
            }
            if (Arrays.equals(targetFrequency, windowFrequency)) {
                result.add(i - targetLength + 1);
            }
        }
        return result;
    }
}
