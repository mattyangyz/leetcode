package BFS;

import java.util.*;


/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 * <p>
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 * <p>
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 * <p>
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * Output: 5
 * <p>
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * <p>
 * 思路: 用BFS, 类似于level order去做。跟MinimumGeneticMutation一模一样。
 * <p>
 * 1. 把dict变成一个set。
 * 2. 然后把beginWord放入到queue中， 然后根据level order的pattern。
 * 3. 根据poll出来的word，进行每个位置 a到z的转换， 如果转换过程中有 在 set中，则判断是否endword。 如果不是就加入到queue中
 * 4. 记得要从set中remove转换符合条件在dict中的word，不然会导致死循环。
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>(wordList);
        queue.offer(beginWord);
        int length = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            length++;

            for (int i = 0; i < size; i++) {

                String candidate = queue.poll();
                for (int j = 0; j < candidate.length(); j++) {            // 这里是level order

                    char preserveChar = candidate.charAt(j);
                    char[] charArray = candidate.toCharArray();

                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        charArray[j] = ch;
                        String newWord = new String(charArray);

                        if (set.contains(newWord)) {                    // 如果转换过程中找到在dict里面出现
                            if (newWord.equals(endWord)) {
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
