package SlidingWindow;

public class SmallestSubarrayGivenSum {

    public static int smallestSubArray(int targetSum, int[] arr) {

        int minWindowSize = Integer.MAX_VALUE;
        int currentWindowSum = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            currentWindowSum += arr[windowEnd];
            while (currentWindowSum >= targetSum) {
                minWindowSize = Math.min(windowEnd - windowStart + 1, minWindowSize);
                currentWindowSum -= arr[windowStart];                               // this is shirking the left
                windowStart++;                                                      // this is shirking the left
            }
        }
        return minWindowSize;
    }
}
