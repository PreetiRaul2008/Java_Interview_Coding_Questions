package StringExamples;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String s ="code";
        Map<Character, Integer> countMap = new LinkedHashMap<>();

        for(char c : s.toCharArray()){
            countMap.put(c, countMap.getOrDefault(c,0)+1);
        }

        for(Map.Entry<Character,Integer> map : countMap.entrySet()){
            if(map.getValue() == 1){
                System.out.println(map.getKey() + " : "+ map.getValue());
                break;
            }
        }
    }
}
