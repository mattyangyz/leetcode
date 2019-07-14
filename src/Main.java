import Array.BestTimeToBuyAndSellStockII;
import Array.FirstMissingPositive;
import Array.GasStation;
import Array.MergeIntervals;
import Array.Sorting.SortColors;
import Backtracking.Combinations;
import Backtracking.Enumeration.LetterCombinationsOfAPhoneNumber;
import Backtracking.FactorCombinations;
import Backtracking.Subsets;
import Backtracking.SubsetsII;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String args[]) {

//        int result = BestTimeToBuyAndSellStockII.maxProfit(new int[]{7,1,5,3,6,4});
//        System.out.println(result);

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        priorityQueue.offer(1);
        priorityQueue.offer(2);
        priorityQueue.offer(3);
        priorityQueue.offer(4);
        priorityQueue.offer(5);

        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.peek());

        int[][] integer = {{1,3},{2,6},{8,10},{15,18}};

        MergeIntervals.merge(integer);

        System.out.println(integer[0]);


    }
}
