package dsf.algorithm.leetcode.biweekly.c33;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/22 22:49
 */
public class P1 {

    public String thousandSeparator(int n) {
        String str = String.valueOf(n);
        int len = str.length();
        StringBuilder sb = new StringBuilder(str);
        for (int i=sb.length()-1, c=1; i>=0; i--, c++) {
            if (c == 3 && i != 0) {
                c = 0;
                sb.insert(i, '.');
            }
        }
        return sb.toString();
    }
}
