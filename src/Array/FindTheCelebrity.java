package Array;


/**
 *
 * 题意不明，陌生人之间认识吗
 */
public class FindTheCelebrity {

    public int findCelebrity(int n) {

        int candidate = 0;

        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i == candidate) {
                continue;
            }
            if (!knows(i, candidate) || knows(candidate, i)) {
                return -1;
            }
        }
        return candidate;
    }

    private boolean knows(int i, int j) {
        return true;
    }
}
