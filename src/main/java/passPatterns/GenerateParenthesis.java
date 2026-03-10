package passPatterns;


import java.util.*;


public class GenerateParenthesis {

    List<String> generateParenthesis(int n) {

        Set<String> braces = new LinkedHashSet<>();
        StringBuilder localBraces = new StringBuilder();
        for (int i=0; i<n; i++){
            localBraces.append("(");
        }

        for (int j=0; j<n; j++){
            localBraces.append(")");
        }
        braces.add(localBraces.toString());


        String preCombination = "()" + generateParenthesisString(n-1);
        braces.add(preCombination);
        String postCombination = generateParenthesisString(n-1) + "()";
        braces.add(postCombination);

        List<String> finalList = new ArrayList<>(braces);
        return finalList;
    }

    private String generateParenthesisString(int n){
        if (n < 1){
            return "";
        }
        if (n == 1){
            return "()";
        }
        return generateParenthesisString(n-1);
    }
}