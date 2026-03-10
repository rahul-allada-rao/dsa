package passPatterns;
import java.util.Objects;

public class ClosestPalindrome {
    public String nearestPalindromicRahul(String n) {

        int left = 0;
        int right = n.length()-1;

        int leftValue;
        int rightValue;
        boolean changed=false;
        StringBuilder closestPalindrome = new StringBuilder();

        while (left < right){
            if (n.charAt(left) != n.charAt(right)){
                leftValue = n.charAt(left);
                rightValue = n.charAt(right);
                if (leftValue < rightValue){
                    closestPalindrome.append(n.charAt(left)).append(n.charAt(right));
                }
                else {
                    closestPalindrome.append(n.charAt(right)).append(n.charAt(left));
                }
            }
            left++;
            right--;
        }
        return closestPalindrome.toString();
    }

    public String nearestPalindromic(String n) {
        if (Objects.equals(n, "0")){
            return "1";
        }
        if (n.length() == 1){
            return String.valueOf(Integer.valueOf(n)-1);
        }
        if (n.equals("10") || n.equals("11")) return "9";

        int num = Integer.valueOf(n);
//        System.out.println(num);

        int lengthOfNumber = n.length();
        StringBuilder divideBy = new StringBuilder("1");
        for (int i=0; i<lengthOfNumber/2; i++){
            divideBy.append("0");
        }
        int div = Integer.parseInt(String.valueOf(divideBy));
//        System.out.println(divideBy);

        int firstPart = num/div;
//        System.out.println(firstPart);
        String reverseFirstPart = new StringBuilder(String.valueOf(firstPart)).reverse().toString();
//        System.out.println(reverseFirstPart);

        if (n.length()%2 != 0){
            reverseFirstPart = reverseFirstPart.substring(1, reverseFirstPart.length());
        }


        String output = firstPart + reverseFirstPart;
//        System.out.println(output);
        return output;
    }


}