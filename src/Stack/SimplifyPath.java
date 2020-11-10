package Stack;

import java.util.Stack;

/**
 * Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.
 * <p>
 * In a UNIX-style file system, a period . refers to the current directory.
 * Furthermore, a double period .. moves the directory up a level.
 * For more information, see: Absolute path vs relative path in Linux/Unix
 * <p>
 * Note that the returned canonical path must always begin with a slash /,
 * and there must be only a single slash / between two directory names.
 * The last directory name (if it exists) must not end with a trailing /.
 * Also, the canonical path must be the shortest string representing the absolute path.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "/home/"
 * Output: "/home"
 * Explanation: Note that there is no trailing slash after the last directory name.
 * Example 2:
 * <p>
 * Input: "/../"
 * Output: "/"
 * Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
 * Example 3:
 * <p>
 * Input: "/home//foo/"
 * Output: "/home/foo"
 * Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
 * Example 4:
 * <p>
 * Input: "/a/./b/../../c/"
 * Output: "/c"
 * Example 5:
 * <p>
 * Input: "/a/../../b/../c//.//"
 * Output: "/c"
 * Example 6:
 * <p>
 * Input: "/a//b////c/d//././/.."
 * Output: "/a/b/c"
 * <p>
 * <p>
 * 思路: The main idea is to push to the stack every valid file name (not in {"",".",".."}),
 * popping only if there's smth to pop and we met "..".
 */

// 先把string用split分开，然后对于..的话就pop一个出来，对于 . 和 ""的话不予理会，因为split的时候会有 "" 所以要注意，
// 然后对于正常的dir名字，放到stack里面。
// 最后处理剩下的dir的时候，要注意顺序的问题。
public class SimplifyPath {

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/");
        for (String s : paths) {
            if (s.equals("..")) {                         // pop一个东西出来，以致于返回上一个目录。
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!s.equals(".") && !s.equals("")) { // 如果是 . 以及 "" 然后就不做任何事情。
                stack.push(s);
            }
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }
        if (res.length() == 0) {
            return "/";
        }
        return res;
    }
}
