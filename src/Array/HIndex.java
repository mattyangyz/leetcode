package Array;


import java.util.Arrays;

/**
 * Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
 * <p>
 * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
 * <p>
 * Example:
 * <p>
 * Input: citations = [3,0,6,1,5]
 * Output: 3
 * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had
 * received 3, 0, 6, 1, 5 citations respectively.
 * Since the researcher has 3 papers with at least 3 citations each and the remaining
 * two with no more than 3 citations each, her h-index is 3.
 * <p>
 * <p>
 * 思路: [3, 0, 6, 1, 5]  --> 1: 4, 2: 3, 3: 3, 4: 2, 5: 2, 6: 1 所以3: 3是答案。
 * 求的是引用n次的有n篇文章，找这个n。以上的例子解释为 如果2，我有三篇文章的
 */

public class HIndex {

    // time -> O(nlogn) space: o(1)
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int res = 0;
        while (res < citations.length && citations[citations.length - 1 - res] > res) {
            res++;
        }
        return res;
    }


}
