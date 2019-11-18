package Array.BinarySearch;

/**
 *
 * Topic: Binary Search, 2d Array,
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * Example 1:
 * <p>
 * Input:
 * matrix = [
 * [1,   3,  5,  7], ['
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 * Example 2:
 * <p>
 * Input:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 *
 *
 * Or you can look at it another way, reshape the M-by-N matrix matrix1 into 1-by-MN matrix matrix2, for example,
 *
 * 0, 1, 2
 * 3, 4, 5  -->  0, 1, 2, 3, 4, 5, 6, 7, 8
 * 6, 7, 8
 *
 * Hence, matrix1[i][j] becomes matrix2[i * col_num + j], where i, j = 0, 1, 2,
 * col_num = 3. Denote i * col_num + j by mid, then i = mid / col_num,
 * and j = mid % col_num, hence matrix2[mid] = matrix1[mid / col_num][mid % col_num] = matrix1[i][j].
 *
 *
 * From my understanding, if you write out the entire matrix as one single list, it looks something like this:
 *
 * [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50]]
 * 0 1 2 3 | 0 1 2 3 | 0 1 2 3
 *
 * Initially, to get the high variable value, we do high = row * col - 1 right?
 * So if we solve that for row, (which is what is put in the "row" parameter in matrix[row][col]),
 * we can get row = high / col + 1. Now to get the column number, it's between 0-3 because in each segmented row,
 * there's only values between 0 - #cols.
 *
 *
 */

public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        if (rows == 0) {
            return false;
        }

        int cols = matrix[0].length;
        int left = 0;
        int right = rows * cols - 1;

        while (left < right) {

            int mid = (left + right) / 2;
            int temp = matrix[mid / cols][mid % cols];    // 注意这里为什么是 row跟col都是跟cols运算
            if (temp == target) {
                return true;
            } else if (temp < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
