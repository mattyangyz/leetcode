import Array.BestTimeToBuyAndSellStockII;
import Array.FirstMissingPositive;
import Array.GasStation;
import Array.Sorting.SortColors;
import Backtracking.Combinations;
import Backtracking.Enumeration.LetterCombinationsOfAPhoneNumber;
import Backtracking.FactorCombinations;
import Backtracking.Subsets;
import Backtracking.SubsetsII;

public class Main {

    public static void main(String args[]){

//        int result = BestTimeToBuyAndSellStockII.maxProfit(new int[]{7,1,5,3,6,4});
//        System.out.println(result);

        int[] input = new int[]{2,1,0,0,1,2,2};

        SortColors.sortColors(input);
        for (int i : input) {
            System.out.println(i);
        }
    }
}
