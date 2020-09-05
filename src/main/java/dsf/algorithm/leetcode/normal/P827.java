package dsf.algorithm.leetcode.normal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.Executors;

/**
 * TODO 通过 时间50% 空间20%
 * TODO 优化：dfs 访问过标记并保存岛的大小
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/9/2 8:30
 */
public class P827 {

    int[] father;
    int[][] grid;
    int n;
    public int largestIsland(int[][] grid) {

        n = grid.length;
        if (n == 1) return 1;

        father = new int[n*n];
        this.grid = grid;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1)
                    father[i*n+j] = i*n+j;
                else father[i*n+j] = -1;
            }
        }

        for (int i=0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    spread(i, j);
                }
            }
        }
        int max = 0;
        HashMap<Integer, Integer> size = new HashMap<>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (father[i*n+j] != -1) {

                    size.put(father[i*n+j], size.getOrDefault(father[i*n+j], 0)+1);
                    max = Math.max(max, size.get(father[i*n+j]));
                }
            }
        }
        HashSet<Integer> set = new HashSet<>(8);
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 0) {
                    int c = 1;
                    int v = i*n+j;
                    if (i>0 && father[v-n] != -1) {
                        set.add(father[v-n]);
                        c += size.get(father[v-n]);
                    }
                    if (i<n-1 && father[v+n] != -1 && !set.contains(father[v+n])) {
                        set.add(father[v+n]);
                        c += size.get(father[v+n]);
                    }
                    if (j>0 && father[v-1] != -1 && !set.contains(father[v-1])) {
                        set.add(father[v-1]);
                        c += size.get(father[v-1]);
                    }
                    if (j<n-1 && father[v+1] != -1 && !set.contains(father[v+1])) {
                        set.add(father[v+1]);
                        c += size.get(father[v+1]);
                    }
                    max = Math.max(c, max);
                    set.clear();
                }
            }
        }
        return max;
    }

    public void spread(int i, int j) {
        if (grid[i][j] != 1) return;
        grid[i][j] = 2;
        int v = i*n+j;
        if (i>0 && grid[i-1][j] == 1) {

            union(v, v-n);
            spread(i-1, j);
        }
        if (i<n-1 && grid[i+1][j] == 1) {

            union(v, v+n);
            spread(i+1, j);
        }
        if (j>0 && grid[i][j-1] == 1) {

            union(v, v-1);
            spread(i, j-1);
        }
        if (j<n-1 && grid[i][j+1] == 1) {

            union(v, v+1);
            spread(i, j+1);
        }
    }

    public int find(int v) {

        if (father[v] != v) {
            father[v] = find(father[v]);
        }
        return father[v];
    }

    public void union(int v1, int v2) {

        if (find(v1) != find(v2)) {
            father[v1] = Math.min(father[v1], father[v2]);
            father[v2] = Math.min(father[v1], father[v2]);
        }
    }

    public static void main(String[] args) {
        new P827().largestIsland(new int[][]{
                {1,0,0,1,1},{1,0,0,1,0},{1,1,1,1,1},{1,1,1,0,1},{0,0,0,1,0}
        });
    }

}
