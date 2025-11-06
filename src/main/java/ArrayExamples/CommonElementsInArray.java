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

        for (int j : arr1) {
            if (commonElements.containsKey(j)) {
                commonElements.put(j, commonElements.get(j) + 1);
            } else {
                commonElements.put(j, 1);
            }
        }
        System.out.print(" [ ");
        for (int j : arr2) {
            if (commonElements.containsKey(j)) {
                System.out.print(j + " ");
                commonElements.remove(j);
            }
        }
        System.out.println("]");
    }
}
