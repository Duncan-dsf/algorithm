package dsf.algorithm.leetcode.weekly.c189;

/**
 * TODO
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/5/17 10:45
 */
public class P5412 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {

        int n = startTime.length, res = 0;
        for (int i=0; i<n; i++) {
            if (startTime[i] <= queryTime && queryTime <= endTime[i])
                res++;
        }
        return res;
    }
}
