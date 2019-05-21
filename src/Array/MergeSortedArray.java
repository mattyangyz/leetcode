package Array;

public class MergeSortedArray {

    public void merge(int[] first, int m, int[] second, int n) {
        int location = m + n -1;
        int left = m - 1;
        int right = n - 1;

        while (left >= 0 || right >= 0) {
            if (left >= 0 && right >= 0) {
                first[location--] = first[left] >= second[right] ? first[left--] : second[right--];
            }
            else{
                first[location--] = left >= 0 ? first[left--] : second[right--];
            }
        }
    }
}
