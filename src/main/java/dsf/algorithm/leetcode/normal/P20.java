package dsf.algorithm.leetcode.normal;

import java.util.Stack;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/14 8:43
 */
public class P20 {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {

            char c = s.charAt(i);
            if (!stack.empty() && match(stack.peek(), c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.empty();
    }

    public boolean match(char c1, char c2) {

        switch (c1) {
            case '(' : return c2 == ')';
            case '[' : return c2 == ']';
            case '{' : return c2 == '}';
            default: return false;
        }
    }

    public static void main(String[] args) {
        System.out.println('('-')');
        System.out.println('['-']');
        System.out.println('{'-'}');
    }
}
