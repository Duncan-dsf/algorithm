package dsf.algorithm.leetcode.weekly.c203;

import java.util.LinkedList;
import java.util.List;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/23 11:39
 */
public class P1 {

    public List<Integer> mostVisited(int n, int[] rounds) {

        int[] arr = new int[n+1];
        int max = 1;
        arr[rounds[0]] = 1;
        for (int i=0; i< rounds.length-1; i++) {
            for (int j=rounds[i]+1; ; j++) {
                if (j > n) j -= n;
                arr[j]++;
                max = Math.max(max, arr[j]);
                if (j == rounds[i+1]) break;

            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        for (int i=1; i<=n; i++) {
            if (arr[i] == max) res.add(i);
        }
        return res;
    }
}
