package twoPointers;

import java.util.ArrayList;
import java.util.LinkedList;

public class RemoveDuplicates {

    public static void main(String[] args) {
//        int[] nums = {1,1,2};
//        int[] nums = {0,0,1,1,1,2,2,3,3,4};
//        System.out.println("\nUnique elements count " + removeDuplicates(nums));

//        int[] nums2 = {3, 2, 2, 3};
//        int val = 3;
//        System.out.println(removeElement(nums2, val));

//        String haystack = "sadbutsad";
//        String needle = "sad";

//        String haystack = "leetcode";
//        String needle = "leeto";
//        System.out.println(strStr(haystack, needle));

//        System.out.println(getSumOfSquares(323));
//        System.out.println("3*3 = " + 3*3);
//        System.out.println("3^2 = " + (3^2)); // ^ is Bitwise XOR and not the exponentiation power

        // 1,7,10,13,19 are Happy numbers
//        int[] numbers = {1,7,10,13,19,11,4,5,22};
//        for (int n : numbers){
//            System.out.println("Is " + n + " a happy number? " + isHappy(n));
//        }

        System.out.println(extractDigits(11298));
    }

    public static boolean isHappy(int n) {
        if ((0 <= n) && (n <=3) && n != 1){
            return false;
        }
        if (n == 1){
            return true;
        }
        int slow = n;
        int fast = getSumOfSquares(n);
        while (slow != fast && fast != 1){
            slow = getSumOfSquares(slow);
            fast = getSumOfSquares(getSumOfSquares(fast));
        }

        return fast == 1;
    }

    private static int getSumOfSquares(int num){
        int sum = 0;
        while(num > 0){
            int digit = num % 10; // modulo to get the last digit
            sum = sum + (digit*digit);
            num = num / 10; // divide to get the quotient as the next number
        }
        return sum;
    }

    private static ArrayList<Integer> extractDigits(int num){
        ArrayList<Integer> digitList = new ArrayList<>();

        while (num > 0){
            int digit = num % 10;
            digitList.add(digit);
            num = num / 10;
        }
        return digitList;
    }

    public static int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0; // there are no elements, thereby, 0 unique numbers
        }

        int k = 1; // assuming that there is at least 1 unique number and taking it as the first element.

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public static int removeElement(int[] nums, int val) {
        // [3,2,2,3], val = 3
        int i = 0; // write index

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }

        return i;
    }

    public static int strStr(String haystack, String needle) {
        int foundIndex = -1;
        int lengthOfSearchStr = needle.length();
        if (lengthOfSearchStr == 0) return foundIndex;

        if (haystack.length() == 1 && lengthOfSearchStr == 1 && haystack.charAt(0) == needle.charAt(0)){
            return 0;
        }

        for (int i = 0; i < haystack.length() - lengthOfSearchStr; i++) {
            if (haystack.substring(i, i + lengthOfSearchStr).equals(needle)) {
                foundIndex = i;
                break;
            }
        }

        return foundIndex;
    }


}
