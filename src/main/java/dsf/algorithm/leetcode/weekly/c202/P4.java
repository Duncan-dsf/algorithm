package dsf.algorithm.leetcode.weekly.c202;

import java.util.HashMap;

/**
 * TODO
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/16 11:07
 */
public class P4 {


    HashMap<Integer, Integer> map = new HashMap<>();
    public int minDays(int n) {
        if (n <= 2)
            return n;
        if (n == 3)
            return 2;
        if (map.containsKey(n))
            return map.get(n);

        map.put(n, Math.min(minDays(n/2)+1+n%2, minDays(n/3)+1+n%3));
        return map.get(n);
    }

//
//    int[] dp;
//
//    public int minDays2(int n) {
//
//        if (n <= 2)
//            return n;
//        if (n == 3)
//            return 2;
//        dp = new int[n+1];
//        dp[1] = 1;
//        dp[2] = 2;
//        dp[3] = 2;
//        for (int i=4; i<=n; i++) {
//            dp[i] = dp[i-1]+1;
//            if (i % 2 == 0) {
//                dp[i] = Math.min(dp[i], dp[i/2]+1);
//            }
//            if (i % 3 == 0) {
//                dp[i] = Math.min(dp[i], dp[i/3]+1);
//            }
//        }
//        return dp[n];
//    }
//
//    public int minDays1(int n) {
//
//        if (n <= 2)
//            return n;
//        if (n == 3)
//            return 2;
//        dp = new int[n+1];
//        dp[1] = 1;
//        dp[2] = 2;
//        dp[3] = 2;
//
//        return recursion(n);
//    }
//
//    public int recursion(int n) {
//
//        if (dp[n] != 0)
//            return dp[n];
//
//        int min1 = recursion(n-1) + 1;
//        int min2 =Integer.MAX_VALUE, min3 = Integer.MAX_VALUE;
//        if (n % 2 == 0) {
//            min2 = recursion(n/2) + 1;
//        }
//        if (n % 3 == 0) {
//            min3 = recursion(n/3) + 1;
//        }
//        return Math.min(min1, Math.min(min2, min3));
//    }
}
