package ArrayExamples;

public class CheckIfArrayIsSorted {
    public static boolean arrayIsSorted(int[] nums){
        for(int i = 1 ; i < nums.length; i++){
            if(nums[i] >= nums[i-1]){
            }
            else{
                return false;
            }
        }
        return true;
    }
    public static void main( String[] args){
        int[] nums = {3, 3, 6, 7, 9};
        System.out.println(arrayIsSorted(nums));
    }
}
