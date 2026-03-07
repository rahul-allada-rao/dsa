package stringManipulations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class FindDuplicatesInString {
    public static void main(String[] args) {
        String str = "programming";
        duplicateCharacters(str);
    }

    private static char[] duplicateCharacters(String str){
        // if str is null or empty, return an empty int[]
        if (str == null || str.isEmpty()) return new char[]{};

        str = str.toLowerCase();

        HashMap<Character, Integer> charCount = new HashMap<>();
        // add all character's count to a map
        for (Character c : str.toCharArray()){
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // if any of character's count > 1, they are duplicates
        List<Character> duplicates = new ArrayList<>();
        for (Character c : charCount.keySet()){
            if (charCount.get(c) > 1){
                duplicates.add(c);
            }
        }

        // form the resultant char[] for those duplicates
        char[] result = new char[duplicates.size()];
        for (int i=0; i< duplicates.size(); i++){
            result[i] = duplicates.get(i);
        }
        return result;
    }
}
