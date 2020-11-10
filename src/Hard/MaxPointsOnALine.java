package Hard;

import java.util.HashMap;
import java.util.Map;

/**
 * 149. Max Points on a Line
 * Hard
 * <p>
 * 831
 * <p>
 * 1924
 * <p>
 * Add to List
 * <p>
 * Share
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,1],[2,2],[3,3]]
 * Output: 3
 * Explanation:
 * ^
 * |
 * |        o
 * |     o
 * |  o
 * +------------->
 * 0  1  2  3  4
 * Example 2:
 * <p>
 * Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 * Explanation:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */


//这题虽然是line，但是还是两个两个点去对比的。 两个点的斜率计算完，存到一个map里面，看还有几个点是跟这个两个点连起来的斜率是相同的。
//要注意的是，必须是两个for loop，这里要想清楚为什么。index 1 跟 index 2 3 4的计算完，还需要从index 2开始 和 index 3 4 去计算
//因为index 1 分别于 index 2 3 4去计算的，当前这个slope是以index 1为基准的，所以还需要以index 2为基准的
//而且这题要知道GCD怎么求
//Math
public class MaxPointsOnALine {

    public static void main(String[] args) {
        MaxPointsOnALine.gcd(18, 24);
    }

    public int maxPoints(int[][] points) {

        if (points == null) {
            return 0;
        }

        int solution = 0;

        for (int i = 0; i < points.length; i++) {

            Map<String, Integer> map = new HashMap<>();         // 这是用来存slope的
            int duplicate = 0;
            int max = 0;                                        // 这是一个localMax

            for (int j = i + 1; j < points.length; j++) {

                int deltaX = points[j][0] - points[i][0];
                int deltaY = points[j][1] - points[i][1];

                if (deltaX == 0 && deltaY == 0) {               // 重复的点这是
                    duplicate++;
                    continue;
                }

                int gcd = gcd(deltaX, deltaY);
                int dX = deltaX / gcd;
                int dY = deltaY / gcd;

                map.put(dX + "," + dY, map.getOrDefault(dX + "," + dY, 0) + 1);
                max = Math.max(max, map.get(dX + "," + dY));
            }
            solution = Math.max(solution, max + duplicate + 1);
        }
        return solution;
    }

    public static int gcd(int a, int b) // 只有这种gcd是work的 其他都是不work的
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

}
