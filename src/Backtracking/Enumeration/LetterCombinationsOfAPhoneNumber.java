package Backtracking.Enumeration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * <p>
 * Example:
 * <p>
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * <p>
 * 这题简单的backtracking就行，从2开始找到对应的abc然后从a开始进入下一个构成ad，然后再继续ae,af，然后返回到a那里，变成b继续下去。ß
 */

public class LetterCombinationsOfAPhoneNumber {

//    public static void main(String[] args) {
//        LetterCombinationsOfAPhoneNumber.letterCombinations("23");
//    }

    Map<Integer, String> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        if(digits.equals("")){
            return new ArrayList<>();
        }
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        List<String> ans = new ArrayList<>();
        com(ans, "", 0, digits);
        return ans;
    }

    private void com(List<String> res, String tempRes, int index, String digits){
        if(index == digits.length()){
            res.add(tempRes);
            return;
        }

        String candidate = map.getOrDefault(digits.charAt(index) - '0', "");
        for(int i = 0; i < candidate.length(); i++){
            com(res, tempRes + candidate.charAt(i), index + 1, digits);
        }

    }
}

