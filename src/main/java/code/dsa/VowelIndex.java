package code.dsa;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class VowelIndex {
    private final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    public List<Integer> findVowelIndexes1(String str) {
        return IntStream.range(0, str.length())
                .filter(i -> vowels.contains(str.charAt(i)))
                .boxed().collect(Collectors.toList());
    }

    public List<Integer> findVowelIndexes2(String str) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (vowels.contains(str.charAt(i)))
                indexes.add(i);
        }
        return indexes;
    }

    public List<Integer> findVowelIndexes3(String str) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case 'a':
                case 'A':
                case 'e':
                case 'E':
                case 'i':
                case 'I':
                case 'o':
                case 'O':
                case 'u':
                case 'U':
                    indexes.add(i);
                    break;
            }

        }
        return indexes;
    }

    public List<Integer> findVowelIndexes4(String str) {
        String vowelStr = "aeiouAEIOU";
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if(vowelStr.indexOf(str.charAt(i)) >= 0) {
                indexes.add(i);
            }
        }
        return indexes;
    }

    public List<Integer> findVowelIndexes5(String str) {
        String vowelStr = "aeiouAEIOU";
        return IntStream.range(0,str.length())
                .filter(i -> vowelStr.indexOf(str.charAt(i)) >= 0)
                .boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        VowelIndex vi = new VowelIndex();
        String in = "I am a Java Developer";
        System.out.println(vi.findVowelIndexes1(in));
        System.out.println(vi.findVowelIndexes2(in));
        System.out.println(vi.findVowelIndexes3(in));
        System.out.println(vi.findVowelIndexes4(in));
        System.out.println(vi.findVowelIndexes5(in));
    }
}
