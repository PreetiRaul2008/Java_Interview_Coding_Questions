package ArrayExamples.SlidingWindowProblem;

import java.util.ArrayList;
import java.util.List;
/**
 * Problem: Given an array of integers nums[] and a window size k,
 * print the first negative integer in every contiguous subarray (window) of size k.
 * If a window does not contain a negative integer, print 0.
 *
 * Example:
 * Input: nums = [-2, 1, -3, 4, -1, 2, 1, 5, 4], k = 3
 * Output: -2 -3 -3 -1 -1 0 0
 *
 * Approach:
 * - Use the Sliding Window technique with two pointers (i, j).
 * - Maintain a list of indices of negative numbers.
 * - For each window:
 *   - Add the current index if nums[j] is negative in th list.
 *   - When window size == k:
 *       - Remove indices that fall outside the window.
 *       - The first element in the list is the first negative number.
 *       - If the list is empty, output 0.
 *   - Slide the window forward by using i++ and j++.
 */

public class FindFirstNegativeNumber {
    public static void printFirstNegativeNumber(int[] nums, int arrSize, int windowSize) {
        int i = 0;
        int j = 0;

        List<Integer> negative = new ArrayList<>();

        while (j < arrSize) {
            //Find and Store the indexes of negative element in the ArrayList to avoid duplicates
            if(nums[j] < 0 ){
                negative.add(j);
            }

            if ((j - i + 1) < windowSize) {
                j++;
            }
            else if ((j - i + 1) == windowSize) {
                //if no negative element is found in the window then return 0
                if(negative.isEmpty()){
                    System.out.print(" "+0);
                }
                else{
                    //if found the negative number then print the 0th element as it would be the first one in the list
                    System.out.print(nums[negative.get(0)]+" ");
                }

                //remove the first element from the list as the calculations are already done so it is outdated
                while (!negative.isEmpty() && negative.get(0) < i) {
                    negative.remove(0);
                }

                //Increment the pointers
                i++;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, 5, 4};
        printFirstNegativeNumber(arr, arr.length, 3);
    }
}
