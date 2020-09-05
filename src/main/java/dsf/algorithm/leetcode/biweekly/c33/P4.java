package dsf.algorithm.leetcode.biweekly.c33;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/22 23:33
 */
public class P4 {

    char[][] grid;
    int n;
    int m;
    int[][] flag;
    public boolean containsCycle(char[][] grid) {

        n = grid.length;
        m = grid[0].length;

        if (n < 2 || m < 2) return false;
        this.grid = grid;
        flag = new int[n][m];

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {

                if (flag[i][j] != 0) continue;
                flag[i][j] = 1;
                if (dfs(i, j, grid[i][j], 1)) return true;
            }
        }
        return false;
    }

    public boolean dfs(int i, int j, char val, int k) {

        if (i < 0 || j < 0 || i >= n || j>= m) return false;
        if (grid[i][j] != val) return false;
        if (flag[i][j] != 0) {
            return k - flag[i][j] > 2;
        }
        flag[i][j] = k;
        boolean res =  dfs(i, j-1, val, k+1) ||
                dfs(i, j+1, val, k+1) ||
                dfs(i-1, j, val, k+1) ||
                dfs(i+1, j, val, k+1);
        flag[i][j] = 0;
        return res;
    }

    public static void main(String[] args) {

        boolean b = new P4().containsCycle(new char[][]{
                {'a', 'b', 'b'},
                {'b', 'z', 'b'},
                {'b', 'b', 'a'}
        });
        System.out.println(b);
    }
}
