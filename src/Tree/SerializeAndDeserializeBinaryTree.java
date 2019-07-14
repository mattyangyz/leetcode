package Tree;


/**
 *
 * [ 4 5 6 7 1 2 3 ] ，[ 4 5 6 7 ] 和 [ 1 2 3 ] 两段有序。
 *
 * 而对于 [ 1 2 3 4] 这种，可以看做 [ 1 2 3 4 ] 和 [ ] 特殊的两段有序。
 *
 * 而对于我们要找的 target ， target 不在的那一段，所有数字可以看做无穷大，这样整个数组就可以看做有序的了，可以用正常的二分法去找 target 了，例如
 *
 * [ 4 5 6 7 1 2 3] ，如果 target = 5，那么数组可以看做 [ 4 5 6 7 inf inf inf ]。
 *
 * [ 4 5 6 7 1 2 3] ，如果 target = 2，那么数组可以看做 [ -inf -inf - inf -inf 1 2 3]。
 *
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer,
 * or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree.
 * There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 *
 * Example:
 *
 * You may serialize the following tree:
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * as "[1,2,3,null,null,4,5]"
 *
 */

public class SerializeAndDeserializeBinaryTree {

}
