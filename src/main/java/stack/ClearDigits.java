package stack;

import java.util.Stack;

public class ClearDigits {

    public static void main(String[] args) {

    }

    /*
        Input: s = "cb34"
        Output: ""
     */
    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();
        for (int i=0; i<chars.length; i++){
            if (Character.isLetter(chars[i])){
                stack.push(chars[i]);
            } else if (Character.isDigit(chars[i]) && !stack.isEmpty()) {
                stack.pop();
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }
}
