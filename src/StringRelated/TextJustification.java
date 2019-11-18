//package String;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class TextJustification {
//
//    public List<String> fullJustify(String[] words, int L) {
//
//        List<String> res = new ArrayList<>();
//        int index = 0;                              // 控制到遍历到那个单词
//        while (index < words.length) {
//            int count = words[index].length();
//            int last = index + 1;
//            while (last < words.length) {
//                if (words[last].length() + count + 1 > L) {
//                    count += 1 + words[last].length();
//                    last++;
//                }
//                StringBuilder builder = new StringBuilder();
//                builder.append(words[index]);
//                int diff = last - index - 1;                // 空格的个数
//            }
//        }
//    }
//}
