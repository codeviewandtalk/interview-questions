package dp;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String str = "MAM";
        String result = longestPalindromicSubString(str);
        System.out.println("result====" + result);
    }

    private static String longestPalindromicSubString(String str) {
        int n = str.length();
        int low = 0;
        int high = 0;
        String lps = "";
        if(str.length()<=1){
            return str;
        }
        for (int i = 1; i < n; i++) {
            low = i;
            high = i;
            while (str.charAt(low) == str.charAt(high)) {
                low--;
                high++;
                if (low == -1 || high == n) {
                    break;
                }
            }

            String palindrome = str.substring(low + 1, high);
            if (palindrome.length() > lps.length()) {
                lps = palindrome;
            }

            //consider even length
            low=i-1;
            high=i;
            while(str.charAt(low)==str.charAt(high)){
                low--;
                high++;
                if(low==-1 || high==n){
                    break;
                }
            }
            palindrome= str.substring(low+1,high);
            if(palindrome.length()>lps.length()){
                lps=palindrome;
            }
        }
        return lps;
    }
}
