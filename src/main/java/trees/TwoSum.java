package trees;


import java.util.HashMap;
import java.util.Map;

/**
 * Problem Statement:
 * Given an array of integers nums and an integer target, return the indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
public class TwoSum {

    /* brute force method
    * Time complexity = O(n^2)
    * Space complexity = O(2)
    * */
    public int[] findTwoSum(int[] nums, int target){
        int[] twoSumIndices = new int[2];

        for (int i=0; i< nums.length; i++) {
            for (int j=i+1; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    twoSumIndices = new int[] {i,j};
                }
            }
        }
        return twoSumIndices;
    }

    public int[] findTwoSumUsingHashMap(int[] nums, int target){
        Map<Integer, Integer> integerMap = new HashMap<>();

        for (int i=0; i < nums.length; i++){
            int diff = target - nums[i];
            if (integerMap.containsKey(diff)){
                return new int[] {integerMap.get(diff), i};
            }
            integerMap.put(nums[i], i);
        }
        return new int[]{};
    }
}
