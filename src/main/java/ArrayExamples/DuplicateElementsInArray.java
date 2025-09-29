package ArrayExamples;

import java.util.HashMap;

public class DuplicateElementsInArray {
    public static void findDuplicateElements(int[] arr) {
        HashMap<Integer, Integer> duplicateMap = new HashMap<>();

        System.out.print("[ ");
        for (int j : arr) {
            if (!duplicateMap.containsKey(j)) {
                duplicateMap.put(j, 1);
            } else {
                System.out.print(arr[j] + " ");
                duplicateMap.put(j, duplicateMap.get(j + 1));
            }
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 2, 3, 3, 4, 5};
        findDuplicateElements(arr1);
    }
}
