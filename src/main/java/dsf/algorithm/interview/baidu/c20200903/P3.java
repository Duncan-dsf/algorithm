package dsf.algorithm.interview.baidu.c20200903;

import java.util.Scanner;

/**
 * TODO
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/9/3 20:16
 */
public class P3 {

    static int mod = (int)1e9+7;
    static int n;
    static int m;
    static int[][] dp;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            dp = new int[n][m*m+m];
            dfs(0, -1, -1);
            System.out.println(dp[0][0]);
            for (int i=1; i<=m; i++) {
                for (int j=1; j<=m; j++) {
                    if (i == 1 || j == 1 || i == j) continue;
                    dp[n-1][i*m+j] = 1;
                }
            }

            for (int i=n-2; i>=0; i--) {
                int c = 0;
                for (int j=1; j<=m; j++) {

                    if (j + i > n) break;
                    for (int j1=1; j1<=m; j1++) {
                        for (int j2=1; j2<=m; j2++) {
                            if (j1 == j2) continue;

                        }
                    }
//                    c += dp[i+]
                }
            }
        }
    }

    public static int dfs(int cur, int last2, int last1) {

        if (cur == n) {
            return 1;
        }
        int v = 0;
        if (last1 != -1)
            v+=last1;
        if (last2 != -1)
            v += last2*m;
        if (dp[cur][v] != 0)
            return dp[cur][v];
        int c = 0;
        for (int i=1; i<=m; i++) {
            if (cur + i > n) break;
            if (i == last1 || i == last2) continue;
            int t = dfs(cur+i, last1, i);
            c = (c+t)%mod;
        }
        dp[cur][v] = c;
        return c;
    }
}
