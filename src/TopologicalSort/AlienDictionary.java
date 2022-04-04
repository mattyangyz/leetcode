package TopologicalSort;

import java.util.*;

/**
 * There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you.
 * You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language.
 * Derive the order of letters in this language.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [
 * "wrt",
 * "wrf",
 * "er",
 * "ett",
 * "rftt"
 * ]
 * <p>
 * Output: "wertf"
 * <p>
 * wrt, wrf -> tf
 * wrf, er -> we            -> we rtf
 * er, ett -> rt
 * ett, rftt -> er
 * <p>
 * You may assume all letters are in lowercase.
 * You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
 * If the order is invalid, return an empty string.
 * There may be multiple valid order of letters, return any one of them is fine.
 * <p>
 * <p>
 * 思路 -> 图 -> 入度为0 -> BFS
 */

// 思路在这里 -> https://www.youtube.com/watch?v=B5hxqxBL2d0
public class AlienDictionary {

    Map<Character, List<Character>> graph = new HashMap<>();
    Map<Character, Integer> indegree = new HashMap<>();
    boolean valid = true;

    public String alienOrder(String[] words) {
        build(words);
        if(!valid){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for (char c : indegree.keySet()) {
            if(indegree.get(c) == 0){
                queue.add(c);
            }
        }


        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            for(Character nei: graph.getOrDefault(c, new ArrayList<>())){   // 这里一定要有这个getOrDefault，不然对于单独没有任何nei的char，会得到null的
                indegree.put(nei, indegree.get(nei) - 1);
                if(indegree.get(nei) == 0){
                    queue.add(nei);
                }
            }
        }
        return sb.length() < indegree.size() ? "" : sb.toString();
    }

    private void build(String[] words){
        for(String word: words){                // 建图， 构建一个indegree的base，
            for (char c : word.toCharArray()) {
                indegree.put(c, 0);
                graph.put(c, new ArrayList<>());
            }
        }

        for(int i = 0; i < words.length - 1; i++){ // 构件图和enrich indegree，注意有一个edge case看到后要马上set valid = false
            String word1 = words[i];
            String word2 = words[i + 1];
            if(word1.length() > word2.length() && word1.startsWith(word2)){
                valid = false;
            }
            for(int j = 0; j < Math.min(word1.length(), word2.length()); j++){
                if (word1.charAt(j) != word2.charAt(j)) {
                    graph.get(word1.charAt(j)).add(word2.charAt(j));
                    indegree.put(word2.charAt(j), indegree.get(word2.charAt(j)) + 1);
                    break;
                }
            }
        }
    }
}
