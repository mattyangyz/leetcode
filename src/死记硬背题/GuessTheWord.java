//package 死记硬背题;
//
//import java.util.ArrayList;
//import java.util.List;
//
// //非常难理解！！！！！！
//public class GuessTheWord {
//
//    public void findSecretWord(String[] wordlist, Master master) {
//        for(int k = 0; k < 10; k++){
//            int[][] count = new int[6][26];
//            int best = 0;
//            for (String word : wordlist) {
//                for (int i = 0; i < 6; i++) {
//                    count[i][word.charAt(i) - 'a']++;
//                }
//            }
//
//            String potentialCandidate = wordlist[0];
//            for (String word : wordlist) {
//                int score = 0;
//                for(int i = 0; i < 6; i++){
//                    score += count[i][word.charAt(i) - 'a'];
//                }
//                if (score > best) {
//                    potentialCandidate = word;
//                    best = score;
//                }
//            }
//
//            int similarity = master.guess(potentialCandidate);
//            List<String> wordList2 = new ArrayList<>();
//            for (String word : wordlist) {
//                if (match(potentialCandidate, word) == similarity) {
//                    wordList2.add(word);
//                }
//            }
//            wordlist = wordList2.toArray(new String[0]);
//        }
//    }
//
//    private int match(String a, String b) {
//        int count = 0;
//        for (int i = 0; i < a.length(); i++) {
//            if(a.charAt(i) == b.charAt(i)){
//                count++;
//            }
//        }
//        return count;
//    }
//
//    class Master {
//        public int guess(String s) {
//            return 0;
//        }
//    }
//
//}
