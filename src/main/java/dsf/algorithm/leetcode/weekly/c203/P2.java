package dsf.algorithm.leetcode.weekly.c203;

import java.util.Arrays;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/23 11:59
 */
public class P2 {

    public int maxCoins(int[] piles) {

        Arrays.sort(piles);
        int n = piles.length;
        int res = 0;
        for (int i=n-2; i>=n/3; i-=2) {
            res += piles[i];
        }
        return res;
    }
}
