package spring;
import java.util.*;

public class VowelSorter {
    
    private static int countVowels(String sentence) {
        int count = 0;
        String vowels = "aeiouAEIOU";
        for (char ch : sentence.toCharArray()) {
            if (vowels.indexOf(ch) != -1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<String> sentences = Arrays.asList(
            "Sakshi Sukhani",
            "mobility employee",
            "associate software developer",
            "java training"
        );

        sentences.sort((s1, s2) -> Integer.compare(countVowels(s1), countVowels(s2)));

        System.out.println("Sorted sentences based on vowel count:");
        for (String sentence : sentences) {
            System.out.println(sentence + " (Vowels: " + countVowels(sentence) + ")");
        }
    }
}