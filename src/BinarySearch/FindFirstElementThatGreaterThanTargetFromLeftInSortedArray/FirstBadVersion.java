package BinarySearch.FindFirstElementThatGreaterThanTargetFromLeftInSortedArray;


/**
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * <p>
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * <p>
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 * <p>
 * Example:
 * <p>
 * Given n = 5, and version = 4 is the first bad version.
 * <p>
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * <p>
 * Then 4 is the first bad version.
 * <p>
 * <p>
 * 思路: 例子 pppppfff 就是找第一个f的地方。思路跟searchInsertPosition一样。
 */

public class FirstBadVersion {

    public int firstBadVersion(int n) {
        int right = n;
        int left = 0;

        while (left < right) {

            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;        //因为这个mid有可能是结果，所以这个mid要保留，如果这里是mid-1的话 这个mid就被skip了
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean isBadVersion(int n) {
        return true;
    }
}
