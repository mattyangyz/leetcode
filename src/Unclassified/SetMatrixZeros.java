package Unclassified;

/**
 *  https://www.youtube.com/watch?v=5LU0pv0-ZtI
 */

public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {

        boolean rowZero = false;
        boolean colZero = false;

        int m = matrix.length;
        int n = matrix[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                if(matrix[i][j] == 0){
                    if(i == 0){
                        rowZero = true;
                    }
                    if(j == 0){
                        colZero = true;
                    }

                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < m; i++){             // 这里必须是从1开始，不然就全部都是0了，之前第一行第一列的那些0的记录全没了！！！
            if(matrix[i][0] == 0){
                for(int j = 1; j < n; j++){
                    matrix[i][j] = 0;
                }
            }
        }

        for(int i = 1; i < n; i++){
            if(matrix[0][i] == 0){
                for(int j = 1; j < m; j++){
                    matrix[j][i] = 0;
                }
            }
        }

        if(rowZero){

            for(int i = 0; i < n; i++){
                matrix[0][i] = 0;
            }
        }

        if(colZero){

            for(int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }
    }
}
