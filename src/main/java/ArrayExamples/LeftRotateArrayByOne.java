package ArrayExamples;

import java.util.Arrays;

public class LeftRotateArrayByOne {

    public static int[] rotateArrayByOne(int[] nums) {
    int temp = nums[0];
    int size = nums.length;
    for(int j = 1; j < nums.length; j++){
        nums[j-1] = nums[j];
    }
    nums[size-1] = temp;
    return nums;
    }

    public static void main( String[] args){
        int[] nums = {1,2,3,4,5};
        System.out.println(Arrays.toString(rotateArrayByOne(nums)));

    }
}
