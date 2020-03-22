//package Backtracking;
//
//import java.util.List;
//
//public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {
//
//    public int dfs(List<String> arr, int index, int flag){
//        if (index >= arr.size()) {
//            return 0;
//        }
//
//        int max = 0;
//        for(int i = index; i < arr.size(); i++){
//            int f = 0;
//            String str = arr.get(i);
//
//            for (char c : str.toCharArray()) {
//                if((f & 1 << (c - 'a')) != 0){
//                    f = 0;
//                    break;
//
//                }
//            }
//        }
//    }
//}
