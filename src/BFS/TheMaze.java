package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right,
 * but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
 * <p>
 * Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.
 * <p>
 * The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume
 * that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.
 * <p>
 * <p>
 * 思路: 用BFS对四边进行一个走， 对于在directions里的每个方向 用一个while loop走到底，走到底才停。然后判断要不要加入到queue里面。
 * <p>
 * 问题： awesome, I had a doubt though, why do we not check visited[xx][yy] == false in (xx>=0 && xx<m && yy>=0 && yy<n && maze[xx][yy]==0)
 * <p>
 * 答案：Because the point [xx,yy] can be visited again in different direction. For eg: assume the matrix
 * [ 0 0 1 0 0 ]
 * [ 0 0 0 0 0 ]
 * [ 0 0 0 1 0 ]
 * [ 1 1 0 1 1 ]
 * [ 0 0 0 0 0 ]
 * Assume start is [0,4] and dest is [1,2]. Then the direction we will take is [0,4] -> [0,3] -> [1,3] -> [1,2](Cannot stop here) ->
 * [1,1] -> [1,0] -> [2,0] -> [2,1] -> [2,2] ->[1,2](Stop here).
 * (Technically [1,2] is visited twice but only when it is visited in one direction it counts.) Hope this helps.
 */


public class TheMaze {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(start[0], start[1]));

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            visited[cur.x][cur.y] = true;
            if (cur.x == destination[0] && cur.y == destination[1]) {
                return true;
            }
            for (int[] direction : directions) {
                int newX = cur.x;
                int newY = cur.y;
                while (isValid(maze, newX + direction[0], newY + direction[1], visited)) {    //一条道走到黑， 这里保证了一直走下去直到南墙。

                    visited[newX][newY] = true;
                    newX += direction[0];
                    newY += direction[1];

                }
                if (!visited[newX][newY]) {                                                 // 这个是必须的，防止死循环。
                    queue.offer(new Point(newX, newY));
                }
            }
        }
        return false;
    }

    private boolean isValid(int[][] maze, int x, int y, boolean[][] visited) {
        return x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0 && !visited[x][y];
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
