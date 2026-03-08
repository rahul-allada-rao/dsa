package stack;

import java.util.HashMap;
import java.util.Stack;

public class BalanceParenthesis {

    public static void main(String[] args) {

    }

    private static boolean isBalanced(String input){
        // edge cases
        if (input == null || input.isEmpty()) return true;

        // data set up
        HashMap<Character, Character> bracesMap = new HashMap<>();
        bracesMap.put('(', ')');
        bracesMap.put('[', ']');
        bracesMap.put('{', '}');

        Stack<Character> stack = new Stack<>();

        for (Character c : input.toCharArray()){
            // if opening brace, then push into the stack
            if (bracesMap.containsKey(c)){
                stack.push(c);
            }
            // if it's a closing brace, then check if the top of stack is the corresponding opening brace
            // if not, then its not balanced
            else {
                if (stack.isEmpty() || bracesMap.get(stack.peek()) != c){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
