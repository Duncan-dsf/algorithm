package dsf.algorithm.leetcode.normal;

import java.util.ArrayList;

/**
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/9/5 15:21
 */
public class P60 {

    public String getPermutation(int n, int k) {

        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>(n);
        int[] fac = new int[n+1];
        fac[0] = 1;
        for (int i=1; i<=n; i++) {
            fac[i] = fac[i-1]*i;
            list.add(i);
        }
        k--;
        for (int i=0; i<n; i++) {

            int index = k / (fac[n - 1 - i]);
            sb.append(list.get(index));
            list.remove(index);
            k = k % fac[n-1-i];
        }
        return sb.toString();
    }

}
