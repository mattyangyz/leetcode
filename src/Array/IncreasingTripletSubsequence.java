package Array;

/**
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 * <p>
 * Formally the function should:
 * <p>
 * Return true if there exists i, j, k
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 * <p>
 * <p>
 * Your algorithm should run in O(n) time complexity and O(1) space complexity.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,4,5]
 * Output: true
 * Example 2:
 * <p>
 * Input: [5,4,3,2,1]
 * Output: false
 * <p>
 * <p>
 * <p>
 * Assume we found one number A and another number B that is larger than A.
 * If we could find a third number C that is larger than B, we can return a true.
 * So the problem becomes how to update A and B to make them ready for C to be discovered.
 * <p>
 * Now the process becomes simple and clear,
 * keep updating A to be the minimum value ever visited and keep B being the smallest value that is larger than A.
 * Once C > B is encountered, return true;
 */

public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {

        int min = Integer.MAX_VALUE;
        int secMin = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= min) {
                min = num;
            } else if (num <= secMin) {
                secMin = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
