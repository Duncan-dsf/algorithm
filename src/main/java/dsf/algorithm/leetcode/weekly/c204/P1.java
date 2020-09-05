package dsf.algorithm.leetcode.weekly.c204;

/**
 * TODO
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/30 10:33
 */
public class P1 {

    public boolean containsPattern(int[] arr, int m, int k) {

        int n = arr.length;
        if (m*k > n)
            return false;
        for (int i=0; i<n-m*k; i++) {
            int c = 0;
            int[] sub = new int[m];
            for (int j=0; j<m; j++) {
                sub[j] = arr[i+j];
            }
            c++;
            for (int j=i+m; j<n; j++) {
                int x=j;
                for (; c<k; x++) {
                    boolean flag = true;
                    int y=0;
                    for (; x<n && y<m; x++) {
                        if (arr[x] != sub[y]) {
                            flag = false;
                            break;
                        } else y++;
                    }
                    if (flag && y == m) c++;
                }
            }
        }
        return false;
    }
}
