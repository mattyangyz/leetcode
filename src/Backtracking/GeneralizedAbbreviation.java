package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviation {

    public static void main(String[] args) {
        GeneralizedAbbreviation.generateAbbreviations("word");
    }

    public static List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        char[] array = word.toCharArray();
        dfs(array, sb, 0, 0, res);
        return res;
    }

    private static void dfs(char[] array, StringBuilder sb, int index, int num, List<String> res) {

        int len = sb.length();
        if (index == array.length) {
            if (num > 0) {
                sb.append(num);
            }
            res.add(sb.toString());
        } else {
            dfs(array, sb, index + 1, num + 1, res);
            if (num > 0) {
                sb.append(num);
            }
            sb.append(array[index]);
            dfs(array, sb, index + 1, 0, res);
        }
        sb.setLength(len);

    }
}
