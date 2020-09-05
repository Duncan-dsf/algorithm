package dsf.algorithm.leetcode.normal;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/26 14:42
 */
public class P17 {

    char[][] map = new char[][] {
            {}, {},
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };
    LinkedList<String> res = new LinkedList<>();
    StringBuilder sb = new StringBuilder();
    char[] str;
    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0)
            return res;
        str = digits.toCharArray();
        recursion(0);
        return res;
    }

    public void recursion(int cur) {

        if (cur == str.length) {
            res.add(sb.toString());
            return;
        }

        for (char c : map[str[cur] - '0']) {
            sb.append(c);
            recursion(cur+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
