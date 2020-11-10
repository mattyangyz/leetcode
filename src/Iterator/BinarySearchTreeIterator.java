package Iterator;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 *
 * Calling next() will return the next smallest number in the BST.
 *
 * 思路:  下去找左节点的时候，把找左节点的路径都push到stack上。 然后pop stack， 如果pop完 这个有右节点的话 就push 右节点 找最左 的path。
 * 如此类推
 *
 * 这题是要快速求一个二叉搜索数是否有下一个最小结点。我们知道二叉搜索数的性质，结点左边的值比根节点小，结点右边的值比根节点大。
 * 那么利用这个性质可以知道最小的结点应该是在最左边，其实也就是中序遍历是依次增大的。知道了这样我们其实可以利用一个栈将所有结点按照:
 * 根->右结点->左节点的方式入栈然后再依次出栈即可。这样在时间复杂度上可以达到O(1)，但空间复杂度是O(n)，ｎ为结点个数。这样不符合要求的O(h)的时间复杂度。
 *
 * 我们还可以初始只让根的左子树入栈直到最左结点，每次结点出栈的时候再把他的右子树入栈，这样就可以达到O(h)的时间复杂度。举个栗子：
 *
 *          4
 *
 *     2       7
 *
 * 1    3   6   8
 *
 * 这样一个二叉搜索树，先依次让4->2->1入栈，每次调用next函数则让一个元素出栈。
 *
 * 第一次调用next的时候１出栈。
 *
 * 第二次调用next的时候２出栈，因为２有右子树，因此让２的右子树３入栈
 *
 * 第三次调用next的时候３出栈
 *
 * 第四次调用next的时候４出栈，并且４有右子树，但是此时４的右子树并不是最小结点，他还有左子树，因此一直遍历到左子树的叶子结点，依次入栈。
 *
 * 重复以上操作即可。
 *
 * 平均时间复杂度还是O(1)，空间复杂度降为O(h)。
 * ---------------------
 *
 * 另外一种做法就是 用inorder去做， 把inorder在constructor的时候去call。
 */

// 关键点是binary search tree 然后next是返回next smallest number 这两点。
// 在constructor的时候把左边的path push进去，然后next出来的时候判断curr pop有没有右边，如果有的话
// 同理把左边的path push进去。
public class BinarySearchTreeIterator {

    private Stack<TreeNode> stack;

    public BinarySearchTreeIterator(TreeNode root) {

        stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null) {
            stack.push(curr);

            if (curr.left != null) {
                curr = curr.left;
            }
            else{
                break;
            }
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        TreeNode node = stack.pop();
        TreeNode curr = node;

        if (curr.right != null) {
            curr = curr.right;
            while (curr != null) {
                stack.push(curr);
                if (curr.left != null) {
                    curr = curr.left;
                }
                else{
                    break;
                }
            }
        }
        return node.val;
    }


    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class BSTIterator {

        List<Integer> nodes;
        int index;

        public BSTIterator(TreeNode root) {
            nodes = new ArrayList<>();
            this.index = -1;
            this.inOrder(root);
        }

        private void inOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            this.inOrder(root.left);
            nodes.add(root.val);
            this.inOrder(root.right);
        }

        public int next() {
            return this.nodes.get(++index);
        }

        public boolean hasNext() {
            return this.index + 1 < this.nodes.size();
        }
    }
}
