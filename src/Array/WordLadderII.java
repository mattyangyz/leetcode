//package Array;
//
//
//// 无向图 -> BFS -> 树 -> DFS -> 结果
//// 把无向图用BFS转换成树， 然后对数进行DFS操作
//
//import java.util.*;
//
//public class WordLadderII {
//
//    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//
//        List<List<String>> res = new ArrayList<>();
//        if (wordList.size() == 0) {
//            return res;
//        }
//        int curNumber = 1;
//        int nextNumber = 0;
//
//        boolean found = false;
//
//        Queue<String> queue = new LinkedList<>();
//        HashSet<String> unvisted = new HashSet<>(wordList);
//        HashSet<String> visited = new HashSet<>();
//
//        HashMap<String, List<String>> tree = new HashMap<>();
//
//        queue.offer(beginWord);
//        while(!queue.isEmpty()){
//            String word = queue.poll();
//            curNumber--;
//            for (int i = 0; i < word.length(); i++) {       //
//                StringBuilder builder = new StringBuilder();
//                for (char ch = 'a'; ch <= 'z'; ch++) {
//                    builder.setCharAt(i, ch);
//                    String newWord = builder.toString();
//                    if (unvisted.contains(newWord)) {
//                        if (visited.add(newWord)) {         // 这里要理解
//                            nextNumber++;
//                            queue.offer(newWord);
//                        }
//                        if (tree.containsKey(newWord)) {
//                            tree.get(newWord).add(word);
//                        }
//                        else{
//                            List<String> list = new ArrayList<>();
//                            list.add(word);
//                            tree.put(newWord, list);
//                        }
//                        if (newWord.equals(endWord)) {
//                            found = true;
//                        }
//                    }
//                }
//            }
//            if (curNumber == 0) {                       // 当前bfs中的层数有多少元素
//                if (found) {
//                    break;;
//                }
//                curNumber = nextNumber;
//                nextNumber = 0;                         // 数当前元素有几个元素
//                unvisted.remove(visited);
//                visited.clear();
//
//            }
//        }
//    }
//}
