package code.dsa.subset;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
public class DialPadCombo {
    private static final String[] DIAL_CHARS = {"abc", "def", "ghi", "jkl", "nmo", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        System.out.println(findCombos("", "23"));
        System.out.println(findCombos("", ""));
        System.out.println(findCombos("", "2"));

    }

    private static List<String> findCombos(String p, String up) {
        List<String> list = new ArrayList<>();
        if (up.isEmpty()) {
            if (!p.isEmpty()) list.add(p);
            return list;
        }

        int digit = up.charAt(0) - '2';
        char[] chars = DIAL_CHARS[digit].toCharArray();

        for (char c : chars)
            list.addAll(findCombos(p + c, up.substring(1)));

        return list;
    }
}
