package BFS;

import java.util.LinkedList;
import java.util.Queue;

// 中规中矩的题目，没有看答案做出来的
public class ShortestPathToGetFood {

    private static int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int getFood(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] startingPoint = findStartingPoint(grid);
        System.out.println(startingPoint[0]);
        System.out.println(startingPoint[1]);
        boolean[][] seen = new boolean[m][n];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(startingPoint);
        int steps = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] curr = queue.poll();
                if(grid[curr[0]][curr[1]] == '#'){
                    return steps;
                }

                for(int[] dir: dirs){
                    int neigR = curr[0] + dir[0];
                    int neigC = curr[1] + dir[1];

                    if(neigR >= 0 && neigR < m && neigC >= 0 && neigC < n){

                        if(seen[neigR][neigC] == true || grid[neigR][neigC] == 'X'){
                            continue;
                        }
                        else{

                            seen[neigR][neigC] = true;
                            queue.offer(new int[]{neigR, neigC});
                        }
                    }
                }
            }
            steps++;
        }
        return -1;

    }


    private int[] findStartingPoint(char[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '*'){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}
