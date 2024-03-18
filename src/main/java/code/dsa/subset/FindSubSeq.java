package code.dsa.subset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindSubSeq {

    public static void main(String[] args) {

        System.out.println(findSubSeq("", "abc"));
    }

    private static List<String> findSubSeq(String p, String up) {
        if(up.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);

        List<String> left = findSubSeq(p + ch, up.substring(1));
        List<String> right =  findSubSeq(p, up.substring(1));
        left.addAll(right);

        return left;
    }
}
