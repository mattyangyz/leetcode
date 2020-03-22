//package StringRelated;
//
//
///**
// *
// *
// * 思路: 暴力解。
// */
//
//public class CountAndSay {
//
//    public String countAndSay(int n) {
//        int i = 1;                      // i controls n
//        String res = "1";
//
//        while (i < n) {
//            int count = 0;              //需要表明的数字的个数    n = 3, 21 ->
//            StringBuilder sb = new StringBuilder();
//            char c = res.charAt(0);     //需要表明的数字         n = 3, 21 -> c = 2
//
//            for (int j = 0; j <= res.length(); j++) {           // j controls the length of the res that needs to iterate
//                if (j != res.length() && res.charAt(j) == c) {
//                    count++;
//                }
//                else{
//                    sb.append(count);
//                    sb.append(c);
//                    if (j != res.length()) {
//                        count = 1;
//                        c = res.charAt(j);
//                    }
//                }
//            }
//            res = sb.toString();
//            i++;
//        }
//        return res;
//    }
//}
