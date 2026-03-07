package stringManipulations;

public class StringPalindrome {

    public static void main(String[] args) {
        String str0 = "Race car";
        String str1 = "Madam";
        String str2 = "112211";
        String str = str2;
        if (checkIfStringIsPalindromeImproved(str)) {
            System.out.println(str + " is a palindrome!");
        }
        else {
            System.out.println(str + " is NOT a palindrome!");
        }
    }

    private static boolean checkIfStringIsPalindrome(String str) {
        // check for nulls or empty strings
        if (str == null || str.isEmpty()){
            return false;
        }
        // convert to lower case
        str = str.toLowerCase();
        // remove any spaces to avoid any ambiguity
         str = str.replace(" ", "");
        boolean isPalindrome = true;

        for (int i=0, j=str.length()-1; i<str.length(); i++, j--){
            if (str.charAt(i) != str.charAt(j)){
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }

    private static boolean checkIfStringIsPalindromeImproved(String str) {
        // check for nulls or empty strings
        if (str == null || str.isEmpty())
            return false;

        // convert to lower case
        str = str.toLowerCase().replace(" ", "");
        int i = 0;
        int j = str.length() - 1;
        while (i < j){
            if (str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
