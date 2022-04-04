package HashMap;

import java.util.HashMap;
import java.util.Map;

public class FindAndReplaceInString {

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        // 注意这里一定不能存Integer到string，一定得是int int
        // key是这个需要替换的index，value是对应在source和value中的index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < indices.length; i++) {
            if(s.startsWith(sources[i], indices[i])){
                map.put(indices[i], i);
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if(map.containsKey(i)){
                sb.append(targets[map.get(i)]);
                i += sources[map.get(i)].length();
            }
            else{
                sb.append(s.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }
}
