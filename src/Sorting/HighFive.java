package Sorting;

import java.util.Arrays;

/**
 * Given a list of scores of different students, return the average score of each student's top five scores in the order of each student's id.
 * <p>
 * Each entry items[i] has items[i][0] the student's id, and items[i][1] the student's score.  The average score is calculated using integer division.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
 * Output: [[1,87],[2,88]]
 * Explanation:
 * The average of the student with id = 1 is 87.
 * The average of the student with id = 2 is 88.6. But with integer division their average converts to 88.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= items.length <= 1000
 * items[i].length == 2
 * The IDs of the students is between 1 to 1000
 * The score of the students is between 1 to 100
 * For each student, there are at least 5 scores
 */

public class HighFive {

    public int[][] highFive(int[][] items) {

        Arrays.sort(items, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        int count = 0;
        int amountOfTotalStudent = items[items.length - 1][0];
        int[][] result = new int[amountOfTotalStudent][2];
        int sum = 0;
        int id = 1;
        for (int[] item : items) {
            if (count != 5 && id == item[0]) {
                sum += item[1];
                count++;
            }

            if (count == 5) {
                int average = sum / 5;
                result[id - 1][0] = id;
                result[id - 1][1] = average;
                sum = 0;
                count = 0;
                id++;
            }
        }
        return result;
    }
}
