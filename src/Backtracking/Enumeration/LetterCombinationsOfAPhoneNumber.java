package Backtracking.Enumeration;

import java.util.ArrayList;
import java.util.List;

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

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber.letterCombinations("23");
    }

    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {
        if (digits.equals("")) {
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        combination("", digits, 0, ans);
        return ans;
    }

    private static void combination(String prefix, String digits, int offset, List<String> ans) {

        if(offset >= digits.length()){
            ans.add(prefix);
            System.out.println(prefix);
            return;
        }
        String letters = KEYS[(digits.charAt(offset)) - '0'];
        for(int i = 0; i < letters.length(); i++) {
            combination(prefix + letters.charAt(i), digits, offset + 1, ans);
        }
    }}

