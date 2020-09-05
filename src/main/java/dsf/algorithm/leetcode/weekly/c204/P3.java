package dsf.algorithm.leetcode.weekly.c204;

/**
 * TODO
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/30 11:26
 */
public class P3 {

    int[] father;
    int n;
    int m;
    public int minDays(int[][] grid) {

        n = grid.length;
        m = grid[0].length;
        father = new int[n*m];
        int l = -1, r = -1, u = -1, d = -1;
        int c = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] == 1) {
                    father[i*n+j] = i*n+j;
                    if (l == -1) {
                        l = r = j;
                        u = d = i;
                    } else {
                        if (j<l) l = j;
                        else if (j > r) r = j;
                        if (i < d) d = i;
                        else if (i > u) u = i;
                    }
                    c++;
                } else {
                    father[i*n+j] = -1;
                }
            }
        }
        int sum = (r-l+1) * (u-d+1);
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] == 1) {
                    spread(i, j);
                }
            }
        }

        int f = -1;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (father[i*n+j] != -1) {
                    if (f != -1) return 0;
                    f = father[i*n+j];
                }
            }
        }

        if (sum == 2) return 2;
        return sum/2-sum+c;
    }

    public void union(int i1, int j1, int i2, int j2) {

        if (i1 < 0 || j1 < 0 || i1 >= n || j1 >= m || i2 < 0 || j2 < 0 || i2 >= n || j2 >= m) return;
        int v1 = i1 * n + j1;
        int v2 = i2 * n + j2;
        if (father[v1] == -1 || father[v2] == -1) return;
        if (find(v1) != find(v2)) {
            int v = Math.min(father[v1], father[v2]);
            father[v1] = v;
            father[v2] = v;
        }
    }

    public int find(int v) {
        if (father[v] != v) {
            father[v] = find(father[v]);
        }
        return father[v];
    }

    public void spread(int i, int j) {

        if (i < 0 || j < 0 || i >= n || j >= m) return;
        union(i, j, i-1, j);
        union(i, j, i+1, j);
        union(i, j, i, j-1);
        union(i, j, i, j+1);
    }
}
