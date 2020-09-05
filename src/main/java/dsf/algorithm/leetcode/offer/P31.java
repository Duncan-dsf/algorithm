package dsf.algorithm.leetcode.offer;

import java.util.Stack;

/**
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/28 17:52
 */
public class P31 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {

        if (pushed == null || popped == null || pushed.length != popped.length)
            return false;
        if (pushed.length == 0) return true;

        int n = pushed.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, j = 0; i < n; i++) {
            if (pushed[i] == popped[j]) {
                j++;
                while (j<n && !stack.empty() && stack.peek() == popped[j]) {
                    stack.pop();
                    j++;
                }
            } else {
                stack.push(pushed[i]);
            }
        }
        return stack.empty();
    }

}
