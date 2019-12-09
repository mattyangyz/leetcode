package Array;


// 无向图 -> BFS -> 树 -> DFS -> 结果
// 把无向图用BFS转换成树， 然后对数进行DFS操作


/**
 * 非常难
 * <p>
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
 * <p>
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 * <p>
 * Return an empty list if there is no such transformation sequence.
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
 * Output:
 * [
 * ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 * <p>
 * <p>
 * 先把这个无向图 转换成tree
 * hit
 * |
 * hot
 * |      |
 * dot    lot          currNumber
 * |      |
 * dog    log          nextNumber
 * |      |
 * cog   cog
 * <p>
 * <p>
 * tree : hot (hit)
 * dot (hot)
 * lot (hot)
 * dog (dot)
 * log (lot)
 * cog (dog, log)
 */

import java.util.*;

public class WordLadderII {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> res = new ArrayList<>();
        if (wordList.size() == 0) {
            return res;
        }
        int curNumber = 1;
        int nextNumber = 0;

        boolean found = false;

        Queue<String> queue = new LinkedList<>();
        HashSet<String> unvisted = new HashSet<>(wordList);     // 无向图转换成tree的时候用的
        HashSet<String> visited = new HashSet<>();              // 无向图转换成tree的时候用的

        HashMap<String, List<String>> tree = new HashMap<>();   // 这是一个反向的存储

        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            curNumber--;
            for (int i = 0; i < word.length(); i++) {
                StringBuilder builder = new StringBuilder();
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    builder.setCharAt(i, ch);
                    String newWord = builder.toString();
                    if (unvisted.contains(newWord)) {           // 进行BFS，
                        if (visited.add(newWord)) {             // 能加入， 这个单词以前没有。这个别忘了
                            nextNumber++;
                            queue.offer(newWord);
                        }
                        if (tree.containsKey(newWord)) {        // 这里要注意 hashmap存的key是新变化呢的词， value是list
                            tree.get(newWord).add(word);
                        } else {
                            List<String> list = new ArrayList<>();
                            list.add(word);
                            tree.put(newWord, list);
                        }
                        if (newWord.equals(endWord)) {
                            found = true;
                        }
                    }
                }
            }
            if (curNumber == 0) {                       // 当前bfs中的层数有多少元素, 这些元素都是通过字母变换得来的
                if (found) {
                    break;
                }
                curNumber = nextNumber;
                nextNumber = 0;                         // 数下一层层数有几个元素
                unvisted.removeAll(visited);            // 防止inifinate loop 所以这里要这样做
                visited.clear();

            }
        }
        dfs(res, new ArrayList<>(), tree, endWord, beginWord);

        return res;
    }

    private void dfs(List<List<String>> res, List<String> list, HashMap<String, List<String>> map, String word, String start) {
        if (word.equals(start)) {
            list.add(0, start);
            res.add(new ArrayList<>(list));
            list.remove(0);
            return;
        }
        list.add(0, word);
        if (map.get(word) != null) {
            for (String s : map.get(word)) {
                dfs(res, list, map, s, start);
            }
        }
        list.remove(0);
    }
}
