package TreeSet;

import java.util.Comparator;
import java.util.TreeSet;

public class SlidingWindowMedian {

    public double[] medianSlidingWindow(int[] nums, int k) {

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (nums[o1] != nums[o2]) {
                    return Integer.compare(nums[o1], nums[o2]);
                } else {
                    return o1 - o2;
                }
            }
        };

        TreeSet<Integer> left = new TreeSet<>(comparator.reversed());
        TreeSet<Integer> right = new TreeSet<>(comparator);

        double[] res = new double[nums.length - k + 1];

        for (int i = 0; i < k; i++) {
            left.add(i);
        }

        balance(left, right);
        res[0] = getMedian(k, nums, left, right);

        int resIndex = 1;
        for (int i = k; i < nums.length; i++) {
            if (!left.remove(i - k)) {
                right.remove(i - k);
            }

            right.add(i);
            left.add(right.pollFirst());
            balance(left, right);
            res[resIndex] = getMedian(k, nums, left, right);
            resIndex++;
        }
        return res;
    }

    private void balance(TreeSet<Integer> left, TreeSet<Integer> right) {
        while (left.size() > right.size()) {
            right.add(left.pollFirst());
        }
    }

    private double getMedian(int k, int[] nums, TreeSet<Integer> left, TreeSet<Integer> right) {
        if (k % 2 == 0) {
            return ((double) nums[left.first()] + nums[right.first()]) / 2;
        } else {
            return (double) nums[right.first()];
        }
    }
}
