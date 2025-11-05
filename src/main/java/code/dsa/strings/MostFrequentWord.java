package code.dsa.strings;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MostFrequentWord {
    public static String findMostFrequentWord2(String str) {
        Map<String, Long> wordMap = new LinkedHashMap<>();
        for (String word : getWords(str))
            wordMap.put(word, wordMap.getOrDefault(word, 0L) + 1);
        String mostFrequentWord = "";
        long freq = 0;
        for (Map.Entry<String, Long> entry : wordMap.entrySet())
            if(entry.getValue() > freq) {
                mostFrequentWord = entry.getKey();
                freq = entry.getValue();
            }
        return mostFrequentWord;
    }

    public static String findMostFrequentWord(String str) {
        String[] words = getWords(str);
        Map<String, Long> wordMap = Arrays.stream(words).collect(Collectors.groupingBy(Function.identity(),
                Collectors.counting()));
        System.out.println(wordMap);
        return wordMap.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
    }

    private static String[] getWords(String str) {
        return str.toLowerCase().replaceAll("\\W+", " ").split("\\s+");
    }

    public static void main(String[] args) {
        String input = "Ram is employee of ABC company, ram is from Belore, RAM! is good in algorithms.";
        System.out.println(findMostFrequentWord(input));
        System.out.println(findMostFrequentWord2(input));
    }
}
