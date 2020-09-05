package dsf.algorithm.leetcode.normal;

/**
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/30 21:21
 */
public class P557 {

    public String reverseWords(String s) {

        StringBuilder sb = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) != ' ')
                sb.insert(0, s.charAt(i));
            else {
                if (sb.length() != 0) {
                    res.append(sb);
                    sb = new StringBuilder();
                }
                res.append(" ");
            }
        }
        res.append(sb);
        return res.toString();
    }
}
