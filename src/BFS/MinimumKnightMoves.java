package BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * In an infinite chess board with coordinates from -infinity to +infinity, you have a knight at square [0, 0].
 * <p>
 * A knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction, then one square in an orthogonal direction.
 * <p>
 * Return the minimum number of steps needed to move the knight to the square [x, y].  It is guaranteed the answer exists.
 * <p>
 * 思路: 跟正常bfs找最短路径一样，但是就是注意需要优化，做需要走右边即可。因为两边是对称的。这题还可以用DP去解。
 * <p>
 * 2020-JUN-09
 */

public class MinimumKnightMoves {

    private final int[][] direction = new int[][]{{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};

    public int minKnightMoves(int x, int y) {

        int realX = Math.abs(x);
        int realY = Math.abs(y);

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});

        Set<String> visited = new HashSet<>();
        visited.add("0,0");

        int res = 0;

        while (!queue.isEmpty()) {

            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {

                int[] potentialPos = queue.poll();
                if (potentialPos[0] == realX && potentialPos[1] == realY) {
                    return res;
                }

                for (int[] dir : direction) {

                    int newX = dir[0] + potentialPos[0];
                    int newY = dir[1] + potentialPos[1];
                    if (!visited.contains(newX + "," + newY) && newX >= -1 && newY >= -1) { // 注意这里必须是 -1 -1 不能是 0 0，因为考虑 1 1 这种input情况，只需两部就够了。
                        queue.add(new int[]{newX, newY});
                        visited.add(newX + "," + newY);
                    }
                }
            }
            res++;
        }

        return -1;
    }
}
