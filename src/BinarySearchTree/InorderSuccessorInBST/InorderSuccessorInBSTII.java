package BinarySearchTree.InorderSuccessorInBST;

/**
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 * <p>
 * The successor of a node p is the node with the smallest key greater than p.val.
 * <p>
 * You will have direct access to the node but not to the root of the tree. Each node will have a reference to its parent node.
 * <p>
 * <p>
 * 思路: 更多的是想x是在哪个位置。根据情况， 做出判断。
 * 1. 一开始判断如果x有右边的话， 它的successor一定是在右边 或者 右边的最最最左边，这个是很容易理解的。
 * 2. 如果当前这个node没有右边的话， 那就要往parent上面找啦。 如果当前节点是parent的左边下来的，就不进入第二个while loop，直接
 * return parent就好了， 但是如果是parent的右边下来的话， 那么parent就不是答案啦。 要考绿一个极端的例子就是给定的node已经是整个数
 * 的最右边的时候，这样返回的结果应该是null。
 * <p>
 * 5
 * 3       6
 * 2      4
 * 1     3.5
 * <p>
 * 考虑以上的例子。
 */
public class InorderSuccessorInBSTII {

    public Node inorderSuccessor(Node x) {
        if (x.right != null) {          // 第一种情况，右边的
            x = x.right;
            while (x.left != null) {
                x = x.left;
            }
            return x;
        }
        // x的右边是空的， 往上面的parent找
        // 如果是parent的左边下来的，不进入这个loop。
        while (x.parent != null && x == x.parent.right) {      // 防止x是最上面的root
            x = x.parent;
        }
        return x.parent;
    }

    class Node {
        int val;
        Node left;
        Node right;
        Node parent;
    }
}
