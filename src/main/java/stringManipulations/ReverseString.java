package stringManipulations;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReverseString {

    public static void main(String[] args) {
        String input = "Hello World how are you";
        System.out.println(reverseString(input));
    }

    private static String reverseString(String str){
        if (str == null || str.isEmpty()) return str;
        return str.charAt(str.length() - 1) + reverseString(str.substring(0, str.length()-1));
    }

    private static String reverseWordsInAString(String str){

        Stack<Character> stringStack = new Stack<>();
        for (int i=0; i<str.length()-1; i++){
            stringStack.push(str.charAt(i));
        }

        List<String> stringList = new ArrayList<>();

        while (!stringStack.isEmpty()){
            StringBuilder stringBuilder = new StringBuilder();
            if (stringStack.peek() != ' '){
                stringBuilder.append(stringStack.pop());
                stringList.add(reverseString(stringBuilder.toString()));
            }
        }

        StringBuilder result = new StringBuilder();
        for (String s : stringList){
            result.append(s);
        }
        return result.toString();
        // check for space in the given sentence
        // keep account of words
        // reverse the words
    }
}
