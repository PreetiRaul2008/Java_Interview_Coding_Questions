package ArrayExamples;

import java.util.HashMap;
import java.util.Map;

public class CommonElementsInArray {
    public static void main(String[] args) {
        int[] arr1 = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        int[] arr2 = new int[] { 1, 3, 4, 5, 6, 9, 8 };
        findCommonElements(arr1, arr2);
    }
    public static void findCommonElements(int[] arr1, int[] arr2){
        Map<Integer, Integer> commonElements = new HashMap<>();

        for(int i = 0; i < arr1.length; i++){
            if (commonElements.containsKey(arr1[i])) {
                commonElements.put(arr1[i], commonElements.get(arr1[i]) +1 );
            }
            else{
                commonElements.put(arr1[i],1);
            }
        }
        System.out.print(" [ ");
        for(int i = 0; i < arr2.length; i++){
            if (commonElements.containsKey(arr2[i])){
                System.out.print(arr2[i]+" ");
                commonElements.remove(arr2[i]);
            }
        }
        System.out.println("]");
    }
}
