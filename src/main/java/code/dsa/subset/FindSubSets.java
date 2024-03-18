package code.dsa.subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindSubSets {

    public static void main(String[] args) {
        System.out.println(findSubSets(new int[]{1,2,2,3}));
    }

    private static List<List<Integer>> findSubSets(int[] arr) {
        List<List<Integer>> out = new ArrayList<>();
        out.add(new ArrayList<>());
        for(int num : arr) {
            int n = out.size();
            for (int i = 0; i < n; i++) {
                List<Integer> inte = new ArrayList<>(out.get(i));
                inte.add(num);
                out.add(inte);
            }
        }

        return out;
    }

    private static List<List<Integer>> findSubSetsDuplicate(int[] arr) {
        List<List<Integer>> out = new ArrayList<>();
        out.add(new ArrayList<>());

        for(int num : arr) {
            int n = out.size();
            for (int i = 0; i < n; i++) {
                List<Integer> inte = new ArrayList<>(out.get(i));
                inte.add(num);
                out.add(inte);
            }
        }

        return out;
    }
}
