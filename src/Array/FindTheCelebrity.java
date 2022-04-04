package Array;


/**
 *
 * Suppose you are at a party with n people (labeled from 0 to n - 1)
 * and among them, there may exist one celebrity. The definition of a celebrity
 * is that all the other n - 1 people know him/her but he/she does not know any of them.
 *
 * Now you want to find out who the celebrity is or verify that there is not one.
 * The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?"
 * to get information of whether A knows B. You need to find out the celebrity
 * (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).
 *
 * You are given a helper function bool knows(a, b) which tells you whether A knows B.
 * Implement a function int findCelebrity(n). There will be exactly one celebrity if he/she
 * is in the party. Return the celebrity's label if there is a celebrity in the party.
 * If there is no celebrity, return -1.
 *
 *
 *
 * 思路: The first loop is to find the candidate as the author explains.
 * In detail, suppose the candidate after the first for loop is person k,
 * it means 0 to k-1 cannot be the celebrity, because they know a previous or current candidate.
 * Also, since k knows no one between k+1 and n-1, k+1 to n-1 can not be the celebrity either.
 * Therefore, k is the only possible celebrity, if there exists one.
 *
 * The remaining job is to check if k indeed does not know a
 * ny other persons and all other persons know k.
 *
 * To this point, I actually realize that we can further shrink
 * the calling of knows method. For example, we don't need to check if
 * k knows k+1 to n-1 in the second loop, because the first loop has already done that.
 *
 * 第一个loop是找possible，如果找到K如何条件。说明两种情况， 0 到 k-1的肯定不能为名人，因为他们
 * 认识之前的或现在的candidate，而且 k+1 到 n-1也不能 因为k 到 n - 1的人里面，k一个都不认识。
 * 所以如果有结果的话，这个就必须是结果。但是我们还需要验证一下，因为存在没有结果的情况。 验证的其实就是两部分，
 * 第一部分他有没认识的人在0到k-1里面，第二部分是k+1到n里面有没人不认识他。
 */

// 需要two past来做，只是nesting for loop还是平衡for loop的问题!
// https://www.youtube.com/watch?v=QDehNYXlCAg
public class FindTheCelebrity {

    public int findCelebrity(int n) {

        int possible = 0;

        // 如果know(possible,i)成立，这个candidate肯定不是名人， 那么i有可能是名人。
        for (int i = 1; i < n; i++) {
            if (knows(possible, i)) {
                possible = i;
            }
        }
        // 最后要么不存在，要么possible就是我们的名人。
        // 0, 1, 2, 3, 4, 5  比如: 3 是名人
        // 比如 0认识1， 1认识2， 2认识4， 4认识5，5认识1.所有人都认识3.

        for (int i = 0; i < n; i++) { // 验证
            if (i == possible) {
                continue;
            }
            // 第一个是是k+1到n里面有没人不认识他 第二个是他有没认识的人在0到k-1里面
            if (!knows(i, possible) || knows(possible, i)) {
                return -1;
            }
        }
        return possible;
    }

    private boolean knows(int i, int j) {
        return true;
    }
}
