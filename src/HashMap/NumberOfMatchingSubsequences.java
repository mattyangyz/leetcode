package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


// 这题是根据
public class NumberOfMatchingSubsequences {

    public int numMatchingSubseq(String s, String[] words) {

        Map<Character, ArrayList<String>> map = new HashMap<>();
        for(String word: words){
            char firstChar = word.charAt(0);
            if(!map.containsKey(firstChar)){
                map.put(firstChar, new ArrayList<>());
            }
            map.get(firstChar).add(word);
        }

        int res = 0;
        for(char ch: s.toCharArray()){
            ArrayList<String> wordList = map.getOrDefault(ch, new ArrayList<>());
            int size = wordList.size();

            for(int i = 0; i < size; i++){
                String newWord = wordList.get(0).substring(1);      // s: abbc, words: bb,bc返回的是2，而不是一，所以同一个b在s里面可以被用多次
                wordList.remove(0);
                if(newWord.equals("")){                     // 注意这里是这样写的，判断是否所有char都已经找到了
                    res++;
                    continue;
                }
                if(!map.containsKey(newWord.charAt(0))){
                    map.put(newWord.charAt(0), new ArrayList<>());
                }
                map.get(newWord.charAt(0)).add(newWord);
            }
        }
        return res;
    }
}
