package DFS.ClassicalDFSTemplate;


/**
 * You are given a m x n 2D grid initialized with these three possible values.
 * <p>
 * -1 - A wall or an obstacle.
 * 0 - A gate.
 * INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
 * <p>
 * Example:
 * <p>
 * Given the 2D grid:
 * <p>
 * INF  -1  0  INF
 * INF INF INF  -1
 * INF  -1 INF  -1
 * 0  -1 INF INF
 * After running your function, the 2D grid should be:
 * <p>
 * 3  -1   0   1
 * 2   2   1  -1
 * 1  -1   2  -1
 * 0  -1   3   4
 * <p>
 * 思路: 直接用dfs，但是要从有0的地方开始，不能从inf的位置开始。而且如果遇到当前的值已经比原来的curr到这
 * 的步数要小，直接返回就行， 不进行下去。代码跟numberOfIslands基本一模一样。
 */

public class WallsAndGates {

    public void wallsAndGates(int[][] rooms) {

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    dfs(rooms, i, j, 0);
                }
            }
        }
    }

    private void dfs(int[][] rooms, int i, int j, int dis) {
        // rooms[i][j] 之前已经遍历过更小的， 所以 直接return 不走下去
        if (i < 0 || j < 0 || i >= rooms.length || j >= rooms[0].length || rooms[i][j] < dis) {
            return;
        }
        rooms[i][j] = dis;
        dfs(rooms, i - 1, j, dis + 1);
        dfs(rooms, i + 1, j, dis + 1);
        dfs(rooms, i, j - 1, dis + 1);
        dfs(rooms, i, j + 1, dis + 1);

    }
}
