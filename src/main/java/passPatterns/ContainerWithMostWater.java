package passPatterns;


/**
 * Problem Statement:
 * Given an array height of non-negative integers, where each integer represents the height of a vertical line drawn on the x-axis, the width between two lines is always 1. The task is to find two lines, together with the x-axis, that forms a container that holds the most water.
 * Requirements:
 * Return the maximum amount of water a container can store.
 * input : height = [1,8,6,2,5,4,8,3,7]
 * output: 49
 * Explanation:
 * The two lines selected are at positions 1 (height 8) and 8 (height 7).
 * The distance between these lines is 8 - 1 = 7.
 * The area formed is min(8, 7) * 7 = 49.
 * Constraints:
 * n == height.length
 * 2 <= n <= 10^5
 * 0 <= height[i] <= 10^4
 */
public class ContainerWithMostWater {

    private int maxAmountOfWaterStoredByContainer(int[] inputArr){
        int left = 0;
        int right = inputArr.length - 1;
        int maxArea = 0;

        while (left < right){
            int width = right - left;
            int currentArea = Math.min(inputArr[left],inputArr[right]) * width;
            if (currentArea > maxArea){
                maxArea = currentArea;
            }
            if (inputArr[left] < inputArr[right]){
                left++;
            }
            else {
                right--;
            }
        }

        return maxArea;
    }
}