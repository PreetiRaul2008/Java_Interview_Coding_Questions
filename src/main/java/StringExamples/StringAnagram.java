package StringExamples;

import java.util.HashMap;
import java.util.Map;

public class StringAnagram {

    public static boolean checkAnagram(String s1 , String s2){
        Map<Character, Integer> countMap = new HashMap<>();

        for(char c : s1.toCharArray()){
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        // Subtract counts using s2
        for(char c : s2.toCharArray()){
            countMap.put(c, countMap.getOrDefault(c, 0) - 1);
        }

        boolean isAnagram = true;

        // Print differences
        for(Map.Entry<Character, Integer> entry : countMap.entrySet()){
            if(entry.getValue() != 0){
                isAnagram = false;
                System.out.println("Character '" + entry.getKey() + "' differs by " + entry.getValue());
            }
        }

        return isAnagram;
    }

    public static void main(String[] args) {
        String s1 = "listen";
        String s2 = "silent";
        System.out.println("Are anagrams? " + checkAnagram(s1,s2)); // true

        System.out.println("----");

        String s3 = "hello";
        String s4 = "hellp";
        System.out.println("Are anagrams? " + checkAnagram(s3,s4)); // false
    }
}


