package StringExamples;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;


/*Input: "programming"
Output: p: 1 r: 2 o: 1 g: 2 a: 1 m: 2 i: 1 n: 1*/
public class CharacterOccurences {
    public static void main(String[] args) {
        String s = "Programming";
        Map<Character, Integer> countMap = new LinkedHashMap<>();

        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0)+1);
        }
        for(Map.Entry<Character, Integer> map : countMap.entrySet()){
            System.out.println(map.getKey() + " : " + map.getValue() + " ");
        }
        Map<Character, Long> countMap2 = s.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println(countMap2);
    }
}
