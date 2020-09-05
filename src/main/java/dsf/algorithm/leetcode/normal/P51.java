package dsf.algorithm.leetcode.normal;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/9/3 6:16
 */
public class P51 {

    char[][] chs;
    int n;
    ArrayList<List<String>> res;
    boolean[] flagJ;
    boolean[] flagD;
    boolean[] flagS;
    public List<List<String>> solveNQueens(int n) {

        this.n = n;
        flagJ = new boolean[n];
        flagD = new boolean[2*n-1];
        flagS = new boolean[2*n-1];
        chs = new char[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                chs[i][j] = '.';
            }
        }
        res = new ArrayList<>(n);
        dfs(0);
        return res;
    }

    public void dfs(int cur) {

        if (cur == n) {
            ArrayList<String> sub = new ArrayList<>(n);
            for (char[] ch : chs) {
                sub.add(new String(ch));
            }
            res.add(sub);
            return;
        }

        for (int j=0; j<n; j++) {
            if (flagJ[j] || flagD[cur-j+n-1] || flagS[cur+j]) continue;
            chs[cur][j] = 'Q';
            flagJ[j] = true;
            flagD[cur-j+n-1] = true;
            flagS[cur+j] = true;
            dfs(cur+1);
            flagJ[j] = false;
            flagD[cur-j+n-1] = false;
            flagS[cur+j] = false;
            chs[cur][j] = '.';
        }
    }
}
