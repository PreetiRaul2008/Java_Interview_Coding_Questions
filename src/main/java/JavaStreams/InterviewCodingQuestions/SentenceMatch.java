package JavaStreams.InterviewCodingQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SentenceMatch {
    public static void main(String[] args) {
        List<String> sentences = Arrays.asList(
                "I like to eat apple and banana",
                "Mango is my favorite fruit",
                "Banana milkshake is tasty",
                "Cherry pie is sweet"
        );

        String match = "is";

        List<String> updatedSentences = sentences.stream()
                .map(sentence -> Arrays.stream(sentence.split("\\s"))
                        .map(word -> word.equalsIgnoreCase(match) ? "#" : word)
                        .collect(Collectors.joining(" ")))
                .toList();

        updatedSentences.forEach(System.out::println);
    }
}
