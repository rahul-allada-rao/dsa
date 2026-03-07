package twoPointers;

import java.util.HashMap;

public class StringAnagrams {
    public static void main(String[] args) {
        String a = "read";
        String b = "dear";
        if (areAnagrams(a, b)){
            System.out.println(a +" and " + b + " are anagrams!");
        }
        else {
            System.out.println(a +" and " + b + " are NOT anagrams");
        }
    }

    private static boolean areAnagrams(String str1, String str2){

        // edge cases
        if (str1 == null || str2 == null) return false;
        if (str1.length() != str2.length()) return false;

        // two strings will be anagrams if each char appears the same number of times in both the strings
        HashMap<Character, Integer> firstCharMap = new HashMap<>();

        // first, loop through the first String and add to the map
        for (int i=0; i < str1.length(); i++){
            firstCharMap.put(str1.charAt(i), firstCharMap.getOrDefault(str1.charAt(i),0)+1);
        }

        // second, loop through the second String and add to the map
        HashMap<Character, Integer> secondCharMap = new HashMap<>();
        for (int i=0; i < str2.length(); i++){
            secondCharMap.put(str2.charAt(i), secondCharMap.getOrDefault(str2.charAt(i),0)+1);
        }

        for (Character character : firstCharMap.keySet()){
            // if char counts don't match, then return false
            if (!firstCharMap.get(character).equals(secondCharMap.get(character))){
                return false;
            }
        }
        return true;
    }
}
