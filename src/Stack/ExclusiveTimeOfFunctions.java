package Stack;


import java.util.List;
import java.util.Stack;

/**
 * Linkedin
 * <p>
 * https://www.youtube.com/watch?v=Ka4cDRolnBE 解答
 * <p>
 * https://leetcode.com/problems/exclusive-time-of-functions/
 * <p>
 * On a single threaded CPU, we execute some functions.  Each function has a unique id between 0 and N-1.
 * <p>
 * We store logs in timestamp order that describe when a function is entered or exited.
 * <p>
 * Each log is a string with this format: "{function_id}:{"start" | "end"}:{timestamp}".
 * For example, "0:start:3" means the function with id 0 started at the beginning of timestamp 3.
 * "1:end:2" means the function with id 1 ended at the end of timestamp 2.
 * <p>
 * A function's exclusive time is the number of units of time spent in this function.  Note that this does not include any recursive calls to child functions.
 * <p>
 * The CPU is single threaded which means that only one function is being executed at a given time unit.
 * <p>
 * Return the exclusive time of each function, sorted by their function id.
 * <p>
 * <p>
 * <p>
 * 3          ----
 * 2        --------
 * 1    -----------------
 * 0                        -----------
 */

// 思路: 碰见end的时候才开始行动， 关键点是in order to exclude某段，peek top的time slot，先
// 减去当前的time。譬如到了👆 3的结束时候， 计算完结果后把3的长度先从2的res array那里先减去，之后到了
// 2 结尾的时候，加上这个已经被减去过的结果 也就是line 65.
public class ExclusiveTimeOfFunctions {

    private static class Log {
        private int id;
        private boolean isStart;
        private int time;

        public Log(String content) {
            String[] strs = content.split(":");
            id = Integer.valueOf(strs[0]);
            isStart = strs[1].equals("start");
            time = Integer.valueOf(strs[2]);
        }
    }

    public static int[] exclusiveTime(int n, List<String> logs) {
        Stack<Log> stack = new Stack<>();

        int[] result = new int[n];
        for (String content : logs) {
            Log currLog = new Log(content);

            if (currLog.isStart) {
                stack.push(currLog);
            } else {
                Log popedLog = stack.pop();
                result[currLog.id] += currLog.time - popedLog.time + 1;
                if (!stack.empty()) {
                    result[stack.peek().id] -= currLog.time - popedLog.time + 1;
                    // 注意这里必须是这样，不能直接 减result[currLog.id]， 因为上面例子那里 若我们在1号线
                    // 减去result[currLog.id]的话，就只会exclude2号线的结果(不包含1号线)，如果按
                    // currLog.time - popedLog.time + 1 这样的写法，就会exclude整条2号线。
                }
            }
        }
        return result;
    }
}

