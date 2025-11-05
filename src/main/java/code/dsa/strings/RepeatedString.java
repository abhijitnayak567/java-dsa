package code.dsa.strings;


// https://www.hackerrank.com/challenges/repeated-string/problem?isFullScreen=true
public class RepeatedString {

    public static void main(String[] args) {
        System.out.println(repeatedString("aba", 10));
        System.out.println(repeatedString("a", 10000));
        System.out.println(repeatedString(
                "kmretasscityylpdhuwjirnqimlkcgxubxmsxpypgzxtenweirknjtasxtvxemtwxuarabssvqdnktqadhyktagjxoanknhgilnm", 736778906400L));
    }

    public static long repeatedString(String s, long n) {
        int len = s.length();
        long countA = len - s.replaceAll("a", "").length();
        long repeat = n / len;
        countA = countA * repeat;
        for (int i = 0; i < n % s.length(); i++) {
            if(s.charAt(i) == 'a')
                countA++;
        }
        return countA;
    }
}
