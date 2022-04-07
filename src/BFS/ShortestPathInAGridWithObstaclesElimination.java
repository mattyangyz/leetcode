package BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// google 高频重要
// https://www.youtube.com/watch?v=2pLhH2eLaP8, 重点是6:50分那里的解说
// 这里关键的点就是，不像传统的BFS，这个BFS的写法，其实对于同一个点 可以visit多次的。这个要理解，视频里面有讲。
// 同时搞清楚什么时候push进去queue里面。
public class ShortestPathInAGridWithObstaclesElimination {

    public static void main(String[] args){

        int[] first = new int[] {0, 1, 0};
        int[] second = new int[] {1, 1, 0};
        int[] third = new int[] {0, 1, 0};
        int[][] array = new int[3][3];
        array[0] = first;
        array[1] = second;
        array[2] = third;
        shortestPath(array, 1);
    }

    private static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] seen = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                Arrays.fill(seen[i], Integer.MAX_VALUE);
            }
        }

        seen[0][0] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0});
        int steps = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];
                if(row == m - 1 && col == n - 1){
                    return steps;
                }

                for(int[] d: dirs){
                    int neigR = d[0] + row;
                    int neigC = d[1] + col;

                    if(neigR >= 0 && neigR < m && neigC >= 0 && neigC < n){
                        int o = grid[neigR][neigC] + curr[2];
                        if(o >= seen[neigR][neigC] || o > k){
                            continue;
                        }
                        seen[neigR][neigC] = o;
                        queue.offer(new int[]{neigR, neigC, o});
                    }
                    else{
                        continue;
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
