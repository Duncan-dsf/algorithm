package dsf.algorithm.leetcode.offer;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/22 11:04
 */
public class P16 {

    public double myPow(double x, int n) {

        if (x == 0) return 0;
        double res = 1;
        boolean flag = n < 0;
        long m = n;
        if (m < 0) m = -m;

        while (m > 0) {

            if ((m & 1) == 1)
                res *= x;
            x *= x;
            m >>= 1;
        }
        if (flag)
            return 1/res;
        return res;
    }
}
