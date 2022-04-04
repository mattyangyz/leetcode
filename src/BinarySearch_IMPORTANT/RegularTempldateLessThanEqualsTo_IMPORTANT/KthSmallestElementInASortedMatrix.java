package BinarySearch_IMPORTANT.RegularTempldateLessThanEqualsTo_IMPORTANT;

/**
 * 思路: 整体思路是binary search。第一个数和最后一个数作为一个range。然后取一个mid，然后数比mid小的个数，如果是这个个数是小于K的话，
 * 就不要这些小的，取右边。
 * <p>
 * [100, 200, 600]
 * [201, 300, 700] k = 8-> 第一次mid == 500, 然后 在count函数里面500跟350对比 因为if(matrix[i][j] < target) 把所100 201 350都算上，
 * [350, 450, 900]         然后以后450， 继续把200 300 450都拿，然后到900 不拿， 往上挪到700，600 700都不能拿 第一次count返回的是6。
 */

public class KthSmallestElementInASortedMatrix {


    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];

        while (left <= right) {                 // 经典的binary search， <= 加 mid - 1, mid + 1 return left
            int mid = left + (right - left) / 2;
            int num = count(matrix, mid);

            if (num >= k) {                 // 注意这里找到了其实还是需要走下去的， 因为暂时还不知道具体的数字是什么，只是知道这个这个mid的范围里面是第K个的。
                right = mid - 1;            // 所以要走下去确定具体的数字是什么。
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static int count(int[][] matrix, int target) {
        int n = matrix[0].length;
        int res = 0;
        int i = n - 1;      // start from the first column of the last row. Since we know that all cols and rows are in 升序
        int j = 0;

        while (i >= 0 && j < n) {
            if (matrix[i][j] <= target) {
                res += i + 1;  // 把这一个col里面 所有row的值都拿 因为row也是升序的
                j++;
            } else {
                i--;
            }
        }
        return res;
    }
}
