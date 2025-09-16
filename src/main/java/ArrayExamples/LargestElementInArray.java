package ArrayExamples;
public class LargestElementInArray {

        public static int largestElement(int[] nums) {

            int largest = 0;
            for (int num : nums) {
                if (num > largest) {
                    largest = num;
                }
            }
            return largest;
        }

        public static void main( String[] args){
            int[] nums = {3, 3, 6, 1};
           System.out.println("Largest number is : "+ largestElement(nums));
        }
}
