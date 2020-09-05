package dsf.algorithm.interview.pdd.c20200901;

import java.util.HashMap;
import java.util.Scanner;

/**
 * TODO https://leetcode-cn.com/problems/making-a-large-island/ P827
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/9/1 20:35
 */
public class P2 {

    static int n;
    static int m;
    static int[] father;
    static HashMap<Integer, Integer> size = new HashMap<>();
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            int[][] arr = new int[n][m];
            father = new int[n*m+1];
            size.clear();
            for (int i=0; i<n; i++) {

                for (int j=0; j<m; j++)
                    arr[i][j] = scanner.nextInt();
            }
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    if (arr[i][j] == 1)
                        continue;
                    arr[i][j] = 1;

                }
            }
        }
    }

    public static int getMax(int[][] arr) {

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (arr[i][j] == 1) {
                    spread(i, j, arr);
                }
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
//                map.put(father[], )
            }
        }
        return 0;
    }

    public static void spread(int i, int j, int[][] arr) {

        int v = i * n + j;
        if (i>0 && arr[i-1][j] == 1)
            union(v, v-n);
        if (i < n-1 && arr[i+1][j] == 1)
            union(v, v+n);
        if (j>0 && arr[i][j-1] == 1)
            union(v, v-1);
        if (j<m-1 && arr[i][j+1] == 1)
            union(v, v+1);
    }

    public static int find(int v) {
        if (father[v+1] != v+1) {
            father[v+1] = find(father[v+1]);
        }
        return father[v+1];
    }

    public static void union(int v1, int v2) {

        if (find(v1) != find(v2)) {
            int f1 = father[v1], f2 = father[v2];
            int nf = Math.max(f1, f2);
            int f = Math.min(f1, f2);
            father[nf] = f;
        }
    }
}
