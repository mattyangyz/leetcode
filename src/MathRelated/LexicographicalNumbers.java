//package MathRelated;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class LexicographicalNumbers {
//
//    public List<Integer> lexicalOrder(int n){
//        List<Integer> res = new ArrayList<>();
//        int cur = 1;
//        for(int i = 1; i <= n; i++){
//            res.add(cur);
//            if(cur * 10 < n){
//                cur *= 10;
//            }
//            else if(cur % 10 != 9 && cur + 1 <= n){
//                cur++;
//            }
//        }
//    }
//}
