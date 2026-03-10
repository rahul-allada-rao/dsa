package trees;


import java.util.*;


/**
 * Problem Statement:
 * Given an array of integers nums, find all unique triplets in the array that sum up to a target value of 0. A triplet is defined as three numbers a, b, and c such that:
 * 𝑎 + 𝑏 + c = a+b+c=0
 * Requirements:
 * The solution must not contain duplicate triplets.
 * The solution should aim for a time complexity better than O(n³), where n is the number of elements in the array.
 * Example: nums = [-1, 0, 1, 2, -1, -4]
 * [[-1, 0, 1], [-1, -1, 2]]
 * Explanation:
 *
 * The triplet [-1, 0, 1] adds up to 0.
 * The triplet [-1, -1, 2] also adds up to 0.
 * Duplicate triplets are not included in the output.
 * Constraints:
 * 0 <= nums.length <= 3000
 * -10⁵ <= nums[i] <= 10⁵
 */
public class ThreeSum {

    private List<List<Integer>> findTripletList(int[] arr){
        // bail out early
        if (arr == null || arr.length < 3) return new ArrayList<>();

        // sort the elements
        Arrays.sort(arr);
        Set<List<Integer>> tripletHashSet = new HashSet<>();

        for (int i=0; i < arr.length; i++){
            int left = i+1;
            int right = arr.length - 1;

            while (left < right){
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == 0){
                    tripletHashSet.add(Arrays.asList(arr[i], arr[left], arr[right]));
                    left++;
                    right--;
                }
                else if (sum < 0){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return new ArrayList<>(tripletHashSet);
    }
}
