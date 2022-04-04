package HashMap;

import java.util.HashMap;
import java.util.Map;


// 想想其实A B C D的顺序是没有关系的，只要加起来能找到0就可以了，两个for loop去遍历就行了
public class FourSumII {

    class Solution {
        public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
            int count = 0;
            Map<Integer,Integer> hashMap = new HashMap<>();
            for (int numA : A) {
                for (int numB : B) {
                    int sumAB = numA + numB;
                    hashMap.put(sumAB, hashMap.getOrDefault(sumAB, 0) + 1);
                }
            }

            for (int numC : C){
                for (int numD : D){
                    int sumCD = numC + numD;
                    count += hashMap.getOrDefault(-sumCD,0);
                }
            }
            return count;
        }
    }
}
