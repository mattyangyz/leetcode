package BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Same code as WordLadder
 * <p>
 * A gene string can be represented by an 8-character long string, with choices from "A", "C", "G", "T".
 * <p>
 * Suppose we need to investigate about a mutation (mutation from "start" to "end"), where ONE mutation is defined as ONE single character changed in the gene string.
 * <p>
 * For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.
 * <p>
 * Also, there is a given gene "bank", which records all the valid gene mutations. A gene must be in the bank to make it a valid gene string.
 * <p>
 * Now, given 3 things - start, end, bank, your task is to determine what is the minimum number of mutations needed to mutate from "start" to "end". If there is no such a mutation, return -1.
 * <p>
 * Note:
 * <p>
 * Starting point is assumed to be valid, so it might not be included in the bank.
 * If multiple mutations are needed, all mutations during in the sequence must be valid.
 * You may assume start and end string is not the same.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * start: "AACCGGTT"
 * end:   "AACCGGTA"
 * bank: ["AACCGGTA"]
 * <p>
 * return: 1
 * <p>
 * <p>
 * Example 2:
 * <p>
 * start: "AACCGGTT"
 * end:   "AAACGGTA"
 * bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
 * <p>
 * return: 2
 * <p>
 * <p>
 * Example 3:
 * <p>
 * start: "AAAAACCC"
 * end:   "AACCCCCC"
 * bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
 * <p>
 * return: 3
 * <p>
 * 思路: 跟word ladder一模一样，只是level从0开始，最后如果没有合适的结果的话 返回-1。 就这样而已。
 */

public class MinimumGeneticMutation {

    public int minMutation(String start, String end, String[] bank) {

        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();

        for (String singleGene : bank) {
            set.add(singleGene);
        }
        char[] chars = new char[]{'A', 'C', 'G', 'T'};
        queue.offer(start);
        int length = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            length++;

            for (int i = 0; i < size; i++) {

                String candidate = queue.poll();
                for (int j = 0; j < candidate.length(); j++) {            // 这里是level order

                    char preserveChar = candidate.charAt(j);
                    char[] charArray = candidate.toCharArray();

                    for (char ch : chars) {
                        charArray[j] = ch;
                        String newWord = new String(charArray);

                        if (set.contains(newWord)) {                    // 如果转换过程中找到在dict里面出现
                            if (newWord.equals(end)) {
                                return length;
                            }
                            queue.offer(newWord);
                            set.remove(newWord);
                        }

                    }
                    charArray[j] = preserveChar;                        // 这一步可有可无，因为是从candidate.toCharArray()的
                }
            }
        }
        return 0;
    }
}
