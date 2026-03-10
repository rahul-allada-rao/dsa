package trees;


import java.util.Stack;


/**
 * Problem Statement:
 * Given a string s containing just the characters '(', ')', '{', '}', '[', and ']', determine if the input string is valid.
 * A string is considered valid if:
 * Open brackets must be closed by the same type of brackets.
 * For example, ( must be closed by ), [ by ], and { by }.
 * Open brackets must be closed in the correct order.
 * For example, "([])" is valid, while "([)]" is not.
 * Every closing bracket must have a corresponding opening bracket before it.
 *
 * e.g
 * s = "()[]{}" --> True
 * s = "([)]"   --> False
 * s = "{[]}"   --> True
 */
public class ValidParenthesis {

    private boolean isValidParenthesis(String inputString){
        char[] strArr = inputString.toCharArray();
        Stack<Character> characterStack = new Stack<>();

        // Every closing bracket must have a corresponding opening bracket before it.
        // --> find all possible combinations of the bracket types
        // when to push the character onto the stack
        for (int i = 0; i < strArr.length; i++){

            // if it's an opening bracket, then push it onto the stack
            if (isOpeningBracket(strArr[i])){
                characterStack.push(strArr[i]);
            }
            else {
                // if the current character is not an opening bracket but doesn't have any corresponding entry in the stack,
                // then this is not a valid parenthesis
                if (characterStack.empty()){
                    return false;
                }
                // if it's not an opening bracket but stack is not empty, then check if there is match on the existing stack
                else if (!isClosingBracketMatchFound( characterStack.peek(), strArr[i])){
                    return false;
                }
                else {
                    // if match found, then pop it
                    characterStack.pop();
                }
            }
        }
        return characterStack.empty();
    }

    private boolean isOpeningBracket(char c){
        return c == '(' || c == '{' || c == '[';
    }

    private boolean isClosingBracketMatchFound(char openingBracket, char closingBracket){
        boolean matchFound = false;
        if (openingBracket == '(' && closingBracket == ')')
        {
            matchFound = true;
        }
        else if (openingBracket == '[' && closingBracket == ']')
        {
            matchFound = true;
        } else if (openingBracket == '{' && closingBracket == '}')
        {
            matchFound = true;
        }
        return matchFound;
    }


}
