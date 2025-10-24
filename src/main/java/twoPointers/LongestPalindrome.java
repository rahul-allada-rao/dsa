package twoPointers;

public class LongestPalindrome {
    static int start = 0;
    static int maxLen = 0;


    public static String longestPalindrome(String s) {

        int n = s.length();
        if (n < 2) {
            return s; // single char or empty string is palindrome itself
        }

        for (int i = 0; i < n - 1; i++) {
            // Expand around i for odd-length palindrome
            expandAroundCenter(s, i, i);

            // Expand around i and i+1 for even-length palindrome
            if (i+1 < n){
                expandAroundCenter(s, i, i + 1);
            }
        }

        return s.substring(start, start + maxLen);
    }

    private static void expandAroundCenter(String s, int left, int right) {
        int n = s.length();

        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // After while loop breaks, substring between (left + 1) and (right - 1) is palindrome
        int len = right - left - 1;
        if (len > maxLen) {
            maxLen = len;
            start = left + 1;
        }
    }

    public static void main(String[] args) {

    }
}
