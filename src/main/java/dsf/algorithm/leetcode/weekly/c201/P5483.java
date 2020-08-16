package dsf.algorithm.leetcode.weekly.c201;

/**
 * TODO
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/9 10:40
 */
public class P5483 {

    public String makeGood(String s) {

        boolean flag = true;
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        while (true) {
            flag = true;
            for (int i=0; i<sb.length()-1; i++) {
                if (Math.abs(sb.charAt(i) - sb.charAt(i+1)) == ('a' - 'A')) {
                    flag = false;
                    sb.delete(i, i+2);
                    i--;
                }
            }
            if (flag) break;
        }

        return sb.toString();
    }
}
