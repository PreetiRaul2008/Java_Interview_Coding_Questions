package ArrayExamples.SlidingWindowProblem;

public class MaximumsubArraySum {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(findMaxSubarraySum(arr));
    }

    public static int findMaxSubarraySum(int[] arr) {
        int currentSum = 0 ;
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){
            currentSum += arr[i];
            if(currentSum > maxSum ){
                maxSum = currentSum;
            }
            if(currentSum < 0){
                currentSum = 0;
            }
        }
        return maxSum;
    }
}

