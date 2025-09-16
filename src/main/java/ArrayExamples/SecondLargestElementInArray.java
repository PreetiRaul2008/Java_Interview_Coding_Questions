package ArrayExamples;

public class SecondLargestElementInArray {
    public static int secondLargestElement(int[] nums) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > largest ) {
                secondLargest = largest;
                largest = num;
            }
            else if(num > secondLargest  && num != largest){
                secondLargest = num;
            }
        }
        return secondLargest;
    }

    public static void main( String[] args){
        int[] nums = {3, 3, 6, 1, 4};
        System.out.println("Second Largest number is : "+ secondLargestElement(nums));
    }
}
