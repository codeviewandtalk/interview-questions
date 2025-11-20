package dsa;

public class MinimumStepAnagram {
    public static void main(String[] args) {

        String s1 = "ddcf";
        String s2 = "cedk";
       int count= minSteps(s1, s2);
        System.out.println(count);
    }

    public static int minSteps(String s1, String s2) {
        int count = 0;

        // store the count of character
        int char_count[] = new int[26];

        // iterate though the first String and update
        // count
        for (int i = 0; i < s1.length(); i++) {
            System.out.println(s1.charAt(i) - 'a');
            char_count[s1.charAt(i) - 'a']++;
        }
        // iterate through the second string
        // update char_count.
        // if character is not found in char_count
        // then increase count
        for (int i = 0; i < s2.length(); i++) {

            char_count[s2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; ++i) {
            System.out.print(char_count[i] +" ");
            if (char_count[i] != 0) {
                count += Math.abs(char_count[i]);
            }
        }

        System.out.println("count " + count);

        return count / 2;
    }
}
