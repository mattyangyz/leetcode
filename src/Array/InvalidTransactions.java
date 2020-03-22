package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A transaction is possibly invalid if:
 * <p>
 * the amount exceeds $1000, or;
 * if it occurs within (and including) 60 minutes of another transaction with the same name in a different city.
 * Each transaction string transactions[i] consists of comma separated values representing the name, time (in minutes), amount, and city of the transaction.
 * <p>
 * Given a list of transactions, return a list of transactions that are possibly invalid.  You may return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: transactions = ["alice,20,800,mtv","alice,50,100,beijing"]
 * Output: ["alice,20,800,mtv","alice,50,100,beijing"]
 * Explanation: The first transaction is invalid because the second transaction occurs within a difference of 60 minutes, have the same name and is in a different city. Similarly the second one is invalid too.
 * Example 2:
 * <p>
 * Input: transactions = ["alice,20,800,mtv","alice,50,1200,mtv"]
 * Output: ["alice,50,1200,mtv"]
 * Example 3:
 * <p>
 * Input: transactions = ["alice,20,800,mtv","bob,50,1200,mtv"]
 * Output: ["bob,50,1200,mtv"]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * transactions.length <= 1000
 * Each transactions[i] takes the form "{name},{time},{amount},{city}"
 * Each {name} and {city} consist of lowercase English letters, and have lengths between 1 and 10.
 * Each {time} consist of digits, and represent an integer between 0 and 1000.
 * Each {amount} consist of digits, and represent an integer between 0 and 2000.
 * <p>
 * 意思: 对于每个name，建立一个map。key是这个name下面的所有transaction。 然后每一条input transaction遍历看是否违反对应那个name下面
 * 的其他transactions。 transactions间 只会跟同一名字的比较。
 */


public class InvalidTransactions {

    public List<String> invalidTransactions(String[] transactions) {
        List<String> result = new ArrayList<>();

        List<String[]> splitTransations = new ArrayList<>();

        // map person name to all transactions with that person's name
        Map<String, List<String[]>> map = new HashMap<>();


        for (String currTransaction : transactions) {
            String[] splitTransaction = currTransaction.split(","); // name, time, amount, city
            splitTransations.add(splitTransaction);

            map.putIfAbsent(splitTransaction[0], new ArrayList<>());
            map.get(splitTransaction[0]).add(splitTransaction);
        }

        for (int i = 0; i < splitTransations.size(); i++) { // 对于每条记录，看是否在同一名字下面 有违反条件的。

            String[] currTransaction = splitTransations.get(i);

            if (Integer.parseInt(currTransaction[2]) > 1000) {
                result.add(transactions[i]);
            } else {
                for (String[] sameNameTransaction : map.get(currTransaction[0])) {
                    if (Math.abs(Integer.parseInt(currTransaction[1]) - Integer.parseInt(sameNameTransaction[1])) <= 60 &&
                            !currTransaction[3].equals(sameNameTransaction[3])) {
                        result.add(transactions[i]);
                        break;
                    }
                }
            }
        }
        return result;
    }
}
