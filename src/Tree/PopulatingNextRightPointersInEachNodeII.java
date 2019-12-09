package Tree;

/**
 * Given a binary tree
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 * <p>
 * <p>
 * 思路: 每一层去处理，然后处理每一层的时候处理最左边的node
 * <p>
 * 要点是，处于当前层数的时候，预先处理下一层。
 * <p>
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/discuss/37828/O(1)-space-O(n)-complexity-Iterative-Solution
 */
public class PopulatingNextRightPointersInEachNodeII {

    // based on level order traversal
    public PopulatingNextRightPointersInEachNode.Node connect(PopulatingNextRightPointersInEachNode.Node root) {

        PopulatingNextRightPointersInEachNode.Node cur = root;
        PopulatingNextRightPointersInEachNode.Node levelHead = null;
        PopulatingNextRightPointersInEachNode.Node levelPrev = null;

        while (cur != null) {                   // iterator on the level

            while (cur != null) {                 // iterate on the current level

                // left child
                if (cur.left != null) {
                    if (levelPrev != null) {
                        levelPrev.next = cur.left;
                    } else {                       // 如果没有prev的话，这个cur就是下一层的第一个node
                        levelHead = cur.left;
                    }
                    levelPrev = cur.left;
                }

                // right child
                if (cur.right != null) {
                    if (levelPrev != null) {
                        levelPrev.next = cur.right;
                    } else {
                        levelHead = cur.left;
                    }
                    levelPrev = cur.right;
                }
                cur = cur.next;
            }
            cur = levelHead;
            levelHead = null;
            levelPrev = null;
        }
        return root;
    }
}
