package Array.MonetoneStack;

import java.util.HashMap;
import java.util.Stack;

/**
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
 * <p>
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.
 * <p>
 * Example 1:
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * Output: [-1,3,-1]
 * Explanation:
 * For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
 * For number 1 in the first array, the next greater number for it in the second array is 3.
 * For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
 * Example 2:
 * Input: nums1 = [2,4], nums2 = [1,2,3,4].
 * Output: [3,-1]
 * Explanation:
 * For number 2 in the first array, the next greater number for it in the second array is 3.
 * For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
 * Note:
 * All elements in nums1 and nums2 are unique.
 * The length of both nums1 and nums2 would not exceed 1000.
 * <p>
 * 思路: 用一个stack去作比较。 对于当前的num小于stack的top(number x)的话， push当前number(number y)到stack中，不用担心说number被
 * 忽略了，因为只要约到下一个比number x 和 number y大的数， 会一直while这样把之前的number pop出来的。
 */

// 先遍历nums2，构建一个mono stack，这个stack是单调递减的，一旦遇到比curr比stack top大的话，就pop出来计算放到map里面，因为对于stack的top
// 来说，这个curr就是比自己要大的 所以要处理。这里要用while loop。
public class NextGreaterElementI {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();        // map存的是number和后面比它大的结果
        Stack<Integer> stack = new Stack<>();                   // stack存的是正常的num

        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);

        }
        return res;
    }

    public int[] nextGreaterElementBruteForce(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            boolean found = false;
            boolean finished = false;
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == nums1[i]) {
                    found = true;
                }
                if (found == true && finished == false && nums2[j] > nums1[i]) {
                    ans[i] = nums2[j];
                    finished = true;
                }
            }
            if (finished == false) {
                ans[i] = -1;
            }
        }
        return ans;
    }
}
