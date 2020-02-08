package BinarySearch.FindFirstElementThatGreaterThanTargetFromLeftInSortedArray;


/**
 * Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find the smallest element in the list that is larger than the given target.
 * <p>
 * Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.
 * <p>
 * Examples:
 * Input:
 * letters = ["c", "f", "j"]
 * target = "a"
 * Output: "c"
 * <p>
 * Input:
 * letters = ["c", "f", "j"]
 * target = "c"
 * Output: "f"
 * <p>
 * Input:
 * letters = ["c", "f", "j"]
 * target = "d"
 * Output: "f"
 * <p>
 * Input:
 * letters = ["c", "f", "j"]
 * target = "g"
 * Output: "j"
 * <p>
 * Input:
 * letters = ["c", "f", "j"]
 * target = "j"
 * Output: "c"
 * <p>
 * Input:
 * letters = ["c", "f", "j"]
 * target = "k"
 * Output: "c"
 * Note:
 * letters has a length in range [2, 10000].
 * letters consists of lowercase letters, and contains at least 2 unique letters.
 * target is a lowercase letter.
 * <p>
 * 思路: 题目意思是找到第一个比target大的ch，符合总结里面的意思，所以用适合这类型的template去做。但是注意不需要check ==
 * 因为即使找到了target也不return。
 */

public class FindSmallestLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] letters, char target) {
        if (target >= letters[letters.length - 1]) {
            target = (char) (letters[0] - 1);
        }
        int left = 0;
        int right = letters.length - 1;

        while (left < right) {
            int middle = left + (right - left) / 2;
            if (letters[middle] > target) {
                right = middle;                 // 这个middle有可能是结果 所以不能skip。
            } else {
                left = middle + 1;              // letters[middle] < target 所以不是结果可以skip。
            }
        }
        return letters[left];
    }
}
