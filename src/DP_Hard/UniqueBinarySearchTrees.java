package DP_Hard;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 * <p>
 * Example:
 * <p>
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * <p>
 * n = 3
 * <p>
 * root 1 -> left : 0, right 2    f(0) * f(2)
 * root 2 -> left : 1, right 1    f(1) * f(1)
 * root 3 -> left : 2, right 0    f(2) * f(0)
 * <p>
 * <p>
 * 思路: 如果只有0的时候只有一种情况。 res[j]代表左边有多少种，res[i - 1 - j] 代表右边减去root再减去左边有多少种就是右边
 * 有多少种的个数。用 * 法是因为cartisen product。
 */
public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        int[] res = new int[n + 1];

        res[0] = 1;

        for (int i = 1; i <= n; i++) {              // i 代表我当前有 1个节点，2个节点，3个节点 一直到n个节点
            for (int j = 0; j < i; j++) {
                res[i] += res[j] * res[i - 1 - j];  // 相当于左边的孩子有多少个，右边的孩子有多少个. i - 1是相当于i减去根节点
            }
        }
        return res[n];
    }

}
