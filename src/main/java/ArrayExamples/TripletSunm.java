package ArrayExamples;

import java.util.Arrays;

public class TripletSunm {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int target = 9;
        findTriplets(arr,target);
    }
    public static void findTriplets(int[] arr, int target){
        Arrays.sort(arr);
        for(int i = 0; i < arr.length -2; i++){
            int left = i + 1;
            int right = arr.length - 1;

            while(left < right ){
                int sum = arr[i] + arr[left] + arr[right];
                if(sum == target){
                    System.out.println("Triplet found :"+ arr[i]+ " " +arr[left]+" " +arr[right]);
                    left ++;
                    right --;
                }
                else if (sum < target){
                    left++;
                }
                else{
                    right --;
                }
            }
        }
    }
}
