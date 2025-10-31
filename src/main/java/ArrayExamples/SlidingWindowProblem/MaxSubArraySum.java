package ArrayExamples.SlidingWindowProblem;
/**
 * Problem: Given an integer array nums, find the subarray of size K with the largest sum,
 * and return its sum.
 *
 * Technique Used: Sliding Window (Fixed Size)
 * Why Sliding Window?
 * - Brute force would require checking all subarrays of size K (O(n*k)).
 * - Sliding window reduces it to O(n) by reusing previous window sums.
 *
 * You can usually spot sliding window problems when:
 * -- Input is a string or array.
 * -- Problem asks for:
 * -- Subarray/substring of fixed size K.
 * -- Subarray/substring that satisfies some condition (sum, unique chars, max/min, etc.).
 */
public class MaxSubArraySum {
    public static void maxSubArray(int[] nums, int arrSize , int windowSize) {
        // 'i' will point to start of the window
        // 'j' will point to end of the window
        int i = 0;
        int j = 0;
        int sum = 0; // current window sum
        int maxSum = Integer.MIN_VALUE; // stores maximum sum found so far

        while(j < arrSize){
            // STEP 1: Expand the window by including nums[j]
            sum = sum + nums[j];

            // CASE 1: If window size is smaller than required, just move 'j'
            if(j - i + 1 < windowSize){
                j++;
            }
            // CASE 2: If window size equals required size
            else if (j - i + 1 == windowSize){
                // Update max sum if current window sum is greater
                maxSum = Math.max(maxSum, sum);

                // Before sliding the window forward,
                // remove the element going out (nums[i])
                sum = sum - nums[i];

                // Slide the window forward
                i++; // move start forward
                j++; // move end forward
            }
        }
        System.out.println("Maximum subarray sum of size " + windowSize + " = " + maxSum);
    }
    public static void main(String[] args) {
        int[] arr = new int[]{2,1,3,4,1,2,1,5,4};
        maxSubArray(arr, arr.length,3);
    }
}
