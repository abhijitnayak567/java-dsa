package code.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public static void main(String[] args) {
        findStringPermutation("", "abc");
        System.out.println(findStringPermutationList("", "abc"));
        System.out.println(getNumberOfPermutations(3,3));
    }

    private static void findStringPermutation(String p, String up) {
        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i);
            findStringPermutation(f + ch + s, up.substring(1));
        }
    }
    private static List<String> findStringPermutationList(String p, String up) {
        if(up.isEmpty())
            return List.of(p);

        char ch = up.charAt(0);
        List<String> ans = new ArrayList<>();
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i);
            ans.addAll(findStringPermutationList(f + ch + s, up.substring(1)));
        }

        return ans;
    }

    private static long getNumberOfPermutations(int totalNumberOfElements, int numberOfElementsTaken) {
        return fact(totalNumberOfElements)/fact(totalNumberOfElements - numberOfElementsTaken);
    }

    private static long fact(long n) {
        if (n <= 1) return 1;

        return n * fact(n - 1);
    }
}
