package dsf.algorithm.leetcode.normal;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/19 7:25
 */
public class P647 {

    public int countSubstrings(String s) {

        if (s == null || s.length() == 0) return 0;
        int n = s.length(), res = 0;
        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                if (i == j) res++;
                else {
                    boolean flag = true;
                    for (int l=i, r = j; l<r; l++, r--) {
                        if (s.charAt(l) != s.charAt(r)) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) res++;
                }
            }
        }
        return res;
    }
}
