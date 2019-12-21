package DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 高频 150
 * <p>
 * Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.
 * <p>
 * Example:
 * Given a / b = 2.0, b / c = 3.0.
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 * return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 * <p>
 * The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.
 * <p>
 * According to the example above:
 * <p>
 * equations = [ ["a", "b"], ["b", "c"] ],
 * values = [2.0, 3.0],
 * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 * <p>
 * <p>
 * 思路: map存的是   "a" -> graphNode: 'b' 2.0
 * "b" -> graphNode: 'a' 1/2.0, graphNode: 'c' 3.0
 * "c" -> graphNode: 'b' 1/3.0
 * <p>
 * start = "a" end = "c" value = 1 set(empty)
 * <p>
 * sub = start = "b" end = "c" value = 2.0 set("a")
 * <p>
 * sub = start = "a" end = "c" value = 2.0 set("a", "b") == -1 被省略掉直接进行下一次的
 * sub = start = "c" end = "c" value = 2.0 * 3.0 set("a", "b")
 */

public class EvaluateDivision {

    HashMap<String, List<GraphNode>> map;                                           // 用来构建图

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            if (!map.containsKey(equation.get(0))) {                                            // "a" -> graphNode: 'b' 2.0
                map.put(equation.get(0), new ArrayList<>());
            }
            map.get(equation.get(0)).add(new GraphNode(equation.get(1), values[i]));

            if (!map.containsKey(equation.get(1))) {
                map.put(equation.get(1), new ArrayList<>());
            }
            map.get(equation.get(1)).add(new GraphNode(equation.get(1), (1 / values[i])));      // "b" -> graphNode 'a' 1/2.0
        }// 构建图结束


        double[] res = new double[queries.size()];

        for (int i = 0; i < res.length; i++) {                                                    // 这里是对queries 进行一个处理
            res[i] = find(queries.get(i).get(0), queries.get(i).get(1), 1, new HashSet<>());
        }
        return res;
    }

    private double find(String start, String end, double value, HashSet<String> visited) {       // visited 防止死循环的出现
        if (visited.contains(start)) {
            return -1;
        }
        if (!map.containsKey(start)) {
            return -1;
        }
        if (start.equals(end)) {
            return value;
        }
        visited.add(start);
        for (GraphNode next : map.get(start)) {
            double sub = find(next.den, end, value * next.val, visited);
            if (sub != -1.0) {                                                                  // 不等于-1的话 就返回， 如果等于-1的话
                // 这个结果就省略掉 直接进行下一个循环
                return sub;
            }
        }
        visited.remove(start);                                                                  // 这里要理解
        return -1;
    }

    class GraphNode {
        String den;
        double val;

        GraphNode(String den, double val) {
            this.den = den;
            this.val = val;
        }
    }
}
