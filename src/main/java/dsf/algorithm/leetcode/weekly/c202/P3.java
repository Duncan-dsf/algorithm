package dsf.algorithm.leetcode.weekly.c202;

import java.util.Arrays;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/16 10:48
 */
public class P3 {

    public int maxDistance(int[] position, int m) {

        this.m = m;
        this.position = position;

        Arrays.sort(position);

        int n = position.length, r = (position[n-1] - position[0])/(m-1);
        int l = (int)1e9;
        for (int i=1; i<n; i++) {
            l = Math.min(l, position[i]-position[i-1]);
        }

        for (; l<r; ) {
            int mid = (l+r+1)/2;
            if (check(mid)) {
                l = mid;
            } else {
                r = mid-1;
            }
        }
        return l;
    }

    int[] position;
    int m;

    public boolean check(int d) {

        int last = position[0], c = 0;
        for (int i=1; i<position.length; i++) {
            if (position[i] - last >= d) {
                c++;
                last = position[i];
            }
        }
        return c>=m-1;
    }

    public static void main(String[] args) {
        int res = new P3().maxDistance(new int[]{1, 2, 3, 4, 7}, 3);
        System.out.println(res);
    }
}
