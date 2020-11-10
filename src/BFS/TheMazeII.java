package BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
 * <p>
 * Given the ball's start position, the destination and the maze, find the shortest distance for the ball to stop at the destination. The distance is defined by the number of empty spaces traveled by the ball from the start position (excluded) to the destination (included). If the ball cannot stop at the destination, return -1.
 * <p>
 * The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.
 * <p>
 * Input 1: a maze represented by a 2D array
 * <p>
 * 0 0 1 0 0
 * 0 0 0 0 0
 * 0 0 0 1 0
 * 1 1 0 1 1
 * 0 0 0 0 0
 * <p>
 * Input 2: start coordinate (rowStart, colStart) = (0, 4)
 * Input 3: destination coordinate (rowDest, colDest) = (4, 4)
 * <p>
 * Output: 12
 * <p>
 * Explanation: One shortest way is : left -> down -> left -> down -> right -> down -> right.
 * The total distance is 1 + 1 + 3 + 1 + 2 + 2 + 2 = 12.
 * <p>
 * Example 2:
 * <p>
 * Input 1: a maze represented by a 2D array
 * <p>
 * 0 0 1 0 0
 * 0 0 0 0 0
 * 0 0 0 1 0
 * 1 1 0 1 1
 * 0 0 0 0 0
 * <p>
 * Input 2: start coordinate (rowStart, colStart) = (0, 4)
 * Input 3: destination coordinate (rowDest, colDest) = (3, 2)
 * <p>
 * Output: -1
 * <p>
 * Explanation: There is no way for the ball to stop at the destination.
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * There is only one ball and one destination in the maze.
 * Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
 * The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
 * The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.
 * <p>
 * <p>
 * 意思: 这一题不需要记录visited，这是一个很大的区别于theMaze。
 */

public class TheMazeII {

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int[][] distance = new int[maze.length][maze[0].length];

        for (int[] dis : distance) {
            Arrays.fill(dis, -1);
        }

        distance[start[0]][start[1]] = 0;

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(start[0], start[1]));
        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int[] dir : directions) {
                int x = point.x;
                int y = point.y;
                int count = distance[x][y];
                while (isVliad(maze, x, y, dir[0], dir[1])) {
                    x += dir[0];
                    y += dir[1];
                    count++;
                }

                // A point (x,y) can be visited several times but if the new distance ('count' variable) is greater than or equal to old distance[x][y],
                // the re-visited (x,y) point would not be added to 'q'. The distance[][] array can be used as 'visited'.

                if (distance[x][y] == -1 || distance[x][y] > count) {   // 若是第一次，或者是当前count小于之前走过的话
                    queue.add(new Point(x, y));
                    distance[x][y] = count;
                }
            }
        }
        return distance[destination[0]][destination[1]];

    }

    private boolean isVliad(int[][] maze, int x, int y, int dirX, int dirY) {
        if (x + dirX >= 0 && x + dirX < maze.length && y + dirY >= 0 && y + dirY < maze[0].length && maze[x + dirX][y + dirY] != 1) {
            return true;
        }
        return false;
    }
}
