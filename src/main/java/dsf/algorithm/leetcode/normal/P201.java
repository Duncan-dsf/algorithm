package dsf.algorithm.leetcode.normal;

import java.util.Scanner;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/24 14:49
 */
public class P201 {

    public int rangeBitwiseAnd(int m, int n) {

        for (; n > m;) {
            n = n & (n-1);
        }
        return n;
    }
}
