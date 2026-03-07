package stringManipulations;

public class MissingDigit {
    public static void main(String[] args) {

    }

    private static int missingNumber(int[] nums){
        // not sure of this return
        if (nums == null || nums.length == 0) return -1;

        // a series of numbers till N, sorted or unsorted, would actually be an arithmetic progression
        int n = nums.length + 1;
        int arithmeticProgression = ((n) * (n+1))/2;

        // we'll keep a running total of all the elements of the array
        int runningTotal = 0;
        for (int num : nums){
            runningTotal += num;
        }
        // the missing number is actually the gap between the actual sum and runningTotal
        return arithmeticProgression - runningTotal;
    }
}
