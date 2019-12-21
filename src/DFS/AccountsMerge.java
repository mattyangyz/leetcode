package DFS;

import java.util.*;


/**
 * Given a list accounts, each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.
 * <p>
 * Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some email that is common to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.
 * <p>
 * After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.
 * <p>
 * Example 1:
 * Input:
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 * Explanation:
 * The first and third John's are the same person as they have the common email "johnsmith@mail.com".
 * The second John and Mary are different people as none of their email addresses are used by other accounts.
 * We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
 * ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
 * Note:
 * <p>
 * The length of accounts will be in the range [1, 1000].
 * The length of accounts[i] will be in the range [1, 10].
 * The length of accounts[i][j] will be in the range [1, 30].
 * <p>
 * 思路: 把email想成图中的每个node，然后把他们链接起来。然后从每一个node，开始 向它的邻居扩散。
 */


public class AccountsMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();

        if (accounts == null || accounts.size() == 0) {
            return res;
        }

        //把每个email于name一一对应
        Map<String, String> emailToName = new HashMap<>();

        //把每个email与它的邻居联通email一一对应
        Map<String, Set<String>> graph = new HashMap<>();
        Set<String> emails = new HashSet<>();

        Set<String> visited = new HashSet<>();

        for (List<String> list : accounts) {
            String name = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                String email = list.get(i);
                emails.add(email);
                emailToName.put(email, name);
                graph.putIfAbsent(email, new HashSet<>());
                if (i == 1) {   // 直到第二个才能做链接
                    continue;
                }
                //链接当前node和前一个node，使其成为无向图 双向链接
                graph.get(list.get(i - 1)).add(email);
                graph.get(email).add(list.get(i - 1));
            }
        }       //以上都是构建无向图的

        for (String e : emails) {
            if (!visited.contains(e)) {
                visited.add(e);
                List<String> temp = new ArrayList<>();
                temp.add(e);
                dfs(e, graph, visited, temp);                  // dfs要拿到所有的neighbor email，然后一层一层的遍历
                Collections.sort(temp);
                temp.add(0, emailToName.get(e));
                res.add(temp);
            }
        }
        return res;
    }

    private void dfs(String e, Map<String, Set<String>> graph, Set<String> visited, List<String> temp) {
        for (String neigh : graph.get(e)) {
            if (!visited.contains(visited)) {
                visited.add(neigh);
                temp.add(neigh);
                dfs(neigh, graph, visited, temp);
            }
        }
    }
}
