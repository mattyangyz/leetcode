package Array;

import java.util.ArrayList;
import java.util.List;


/**
 * Input: 5
 * Output:
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * 第一第二行都是1， 然后index0 和 最后一个index也是1. 这个就是规律。
 *
 * 2020 Jun 8
 */


public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (i == 1 || i == 0) {
                    temp.add(1);
                } else {
                    if (j == 0 || j == i) {
                        temp.add(1);
                    } else {
                        temp.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
                    }
                }
            }

            list.add(temp);
        }
        return list;
    }
}
