package ArrayExamples.SlidingWindowProblem;

import java.util.HashMap;
import java.util.Map;

public class CountOccurancesOfAnagram {
    public static void countOccurances(String str, String ptr){
        int k = ptr.length(); // window size
        int i = 0, j = 0, count = 0;

        // Step 1: Build frequency map of pattern
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : ptr.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        int distinctCount = countMap.size(); // number of distinct chars

        // Step 2: Start sliding the window
        while (j < str.length()) {
            char endChar = str.charAt(j);
            if (countMap.containsKey(endChar)) {
                countMap.put(endChar, countMap.get(endChar) - 1);
                if (countMap.get(endChar) == 0) {
                    distinctCount--;
                }
            }

            // If window not hit size yet, just expand
            if (j - i + 1 < k) {
                j++;
            }
            // When window size == k
            else if (j - i + 1 == k) {
                if (distinctCount == 0) {
                    count++;
                }

                // Slide the window → remove i
                char startChar = str.charAt(i);
                if (countMap.containsKey(startChar)) {
                    if (countMap.get(startChar) == 0) {
                        distinctCount++;
                    }
                    countMap.put(startChar, countMap.get(startChar) + 1);
                }

                i++;
                j++;
            }
        }

        System.out.println("Total Anagram Occurrences: " + count);
    }
    public static void main(String[] args) {
        String str = "aaabaabaa";
        String ptr = "aaba";
        countOccurances(str, ptr);
    }
}
