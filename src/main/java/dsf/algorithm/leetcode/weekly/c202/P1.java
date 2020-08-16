package dsf.algorithm.leetcode.weekly.c202;

/**
 * TODO
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/16 10:43
 */
public class P1 {

    public boolean threeConsecutiveOdds(int[] arr) {

        int n = arr.length;
        int f = 0;
        for (int i=0; i<n; i++) {
            if (arr[i] % 2 == 1) {

                f++;
                if (f == 3) return true;
            }
            else f = 0;
        }
        return false;
    }
}
