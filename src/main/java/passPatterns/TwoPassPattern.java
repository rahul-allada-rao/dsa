package passPatterns;

import java.util.HashMap;
import java.util.Map;

public class TwoPassPattern {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }

    public static int firstUniqChar(String s) {
        Map<Character, Integer> char_freq_counter = new HashMap<>();
        int count = 0;
        for (char element : s.toCharArray()){
            if (!char_freq_counter.containsKey(element)){
                char_freq_counter.put(element, count++);
            }
            else{
                char_freq_counter.put(element, char_freq_counter.get(element)+1);
            }
        }

        for (char element : s.toCharArray()){
            if (char_freq_counter.get(element) == 1){
                return s.indexOf(element);
            }
        }
        return -1;
    }

    public static boolean areIsomorphic(String s, String t){
        if (s.length() != t.length()){
            return false;
        }
        Map<Character, Character> s_t = new HashMap<>();
        Map<Character, Character> t_s = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (s_t.containsKey(c1)){
                if (s_t.get(c1) != c2)
                    return false;
            }
            else {
                s_t.put(c1, c2);
            }

            if (t_s.containsKey(c2)){
                if (t_s.get(c2) != c1)
                    return false;
            }
            else {
                t_s.put(c2, c1);
            }
        }

        return true;
    }
}
