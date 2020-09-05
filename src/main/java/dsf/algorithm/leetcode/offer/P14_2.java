package dsf.algorithm.leetcode.offer;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/22 10:13
 */
public class P14_2 {

    int m = (int) (1e9 + 7);

    public int cuttingRope(int n) {

        if (n < 4) return n - 1;
        if (n % 3 == 0) {
            return (int) pow(3, n / 3);
        }
        if (n % 3 == 2) {
            return (int) ((pow(3, n / 3) * 2) % m);
        }

        return (int) ((pow(3, (n - 4) / 3) * 4) % m);
    }


    public long pow(long a, long b) {

        long res = 1;
        while (b > 0) {

            if ((b & 1) == 1) {
                res *= a;
                if (res > m)
                    res %= m;
            }

            a *= a;
            if (a > m) a %= m;
            b = b >> 1;
        }
        return res;
    }

}
