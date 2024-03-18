package code.dsa;

// https://leetcode.com/problems/custom-sort-string/?envType=daily-question&envId=2024-03-11
public class CustomStringSort {

    public static void main(String[] args) {
        System.out.println(customSortString("cba", "abcd"));
        System.out.println(customSortString("bcafg", "abcd"));
        System.out.println(customSortString("bcafg", "xstklabcdfgct"));
    }

    private static String customSortString(String order, String s) {
        char[] charsArr = s.toCharArray();
        int o = 0;
        int i = -1;

        while(o < order.length() && i < charsArr.length) {
            var c = order.charAt(o);
            for (int j = i + 1; j < charsArr.length; j++) {
                if (c == charsArr[j]) {
                    i++;
                    charsArr[j] = charsArr[i];
                    charsArr[i] = c;
                }
            }
            o++;
        }

        StringBuilder sb = new StringBuilder();
        for(char c : charsArr)
            sb.append(c);

        return sb.toString();
    }

    private static String customSortStringOpt(String order, String s) {
        int[] arr = new int[26];
        for (char ch : s.toCharArray()) {
            arr[ch - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for (char ch : order.toCharArray()) {
            while (arr[ch - 'a'] != 0) {
                sb.append(ch);
                arr[ch - 'a']--;
            }
        }

        for (int i = 0; i < 26; i++) {
            while (arr[i] != 0) {
                sb.append((char)(i + 'a'));
                arr[i]--;
            }
        }


        return sb.toString();
    }
}
