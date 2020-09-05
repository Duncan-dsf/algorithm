package dsf.algorithm.leetcode.weekly.c202;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/16 10:36
 */
public class P2 {

    public int minOperations(int n) {

        int res = 0;
        for (int i=0; i<n/2; i++) {
            res += (n - 2*i-1);
        }
        return res;
    }
}
