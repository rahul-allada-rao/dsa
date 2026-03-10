package passPatterns;


import java.util.HashMap;


public class ClimbingStairs {
    public int countDistinctClimbingStairs(int n){
        return countDistinctClimbingStairs(n, new HashMap<>());
    }

    public int countDistinctClimbingStairs(int n, HashMap<Integer, Integer> memo){
        if (n <= 1) {
            return 1;
        }
        if (memo.containsKey(n)){
            return memo.get(n);
        }
        int result = countDistinctClimbingStairs(n-1, memo) + countDistinctClimbingStairs(n-2, memo);
        memo.put(n, result);
        return result;
    }

    public int countDistinctClimbingStairsUsingArray(int n){
        if (n <=1){
            return 1;
        }
        int[] arr = new int[n+1];
        // base cases
        arr[0] = 1;
        arr[1] = 1;

        for (int i=2; i<= n; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }

        return arr[n];
    }

    public int climbStairs(int n) {
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }
}