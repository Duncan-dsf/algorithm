package dsf.algorithm.leetcode.offer;

import java.util.Stack;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/20 20:43
 */
public class P9 {

    class CQueue {

        private final Stack<Integer> in = new Stack<>();

        private final Stack<Integer> out = new Stack<>();

        public CQueue() {

        }

        public void appendTail(int value) {
            in.push(value);
        }

        public int deleteHead() {

            if (in.empty() && out.empty()) return -1;

            if (out.empty()) {
                while (!in.empty()) out.push(in.pop());
            }
            return out.pop();
        }
    }
}
