package dsf.algrithm.archive.graph;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : dongshaofei
 * @version V1.0
 * @Project: algorithm
 * @Package dsf.algrithm.archive.graph
 * @Description: TODO
 * @date Date : 2020年01月14日 10:39
 *
 * 最短路径
 */
public class ShortestPath {

    public static void main(String[] args) {
        wu();
    }

    // 牛客竞赛 15522 武 求源点到个点最短路径中 第k短的长度
    // https://ac.nowcoder.com/acm/problem/15522
    public static void wu() {

        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextInt()) {
            int n = scanner.nextInt(), p = scanner.nextInt(), k = scanner.nextInt();
            int[][] graph = initGraph(n);
            for (int i=1; i<n; i++) {
                int x = scanner.nextInt(), y = scanner.nextInt(), d = scanner.nextInt();
                graph[x-1][y-1] = d;
                graph[y-1][x-1] = d;
            }

            int[] dis = Dijkstra.dijkstra(graph, p-1);
            Arrays.sort(dis);
            System.out.println(dis[k]);
        }
    }

    public static int[][] initGraph(int n) {

        int[][] graph = new int[n][n];
        for (int i=0, j; i<n; i++) {
            for (j = 0; j<n; j++) {
                if (i == j) graph[i][j] = 0;
                else graph[i][j] = Integer.MAX_VALUE;
            }
        }
        return graph;
    }

    public static class Dijkstra {

        /**
         * 返回每个点到 源点origin的最短距离
         * @param graph 邻接矩阵 应该是n*n大小 不相邻的点 graph[x][y] = MAX 表示不相邻
         * @param origin 源点编号 0-n-1
         * @return 每个点到源点的最短距离
         */
        public static int[] dijkstra(int[][] graph, int origin) {

            int n = graph.length;
            int[] dis = new int[n];

            System.arraycopy(graph[origin], 0, dis, 0, n);

            int[] mark = new int[n];
            mark[origin] = 1;
            for (int i=1; i<n; i++) {
                int min = Integer.MAX_VALUE, minPoint = origin;
                for (int j=1; j<n; j++) {
                    if (mark[j] == 0 && dis[j]<min) {
                        min = dis[j];
                        minPoint = j;
                    }
                }

                mark[minPoint] = 1;
                if (min == Integer.MAX_VALUE)
                    continue;
                for (int j=0; j<n; j++) {
                    if (graph[minPoint][j] == Integer.MAX_VALUE) continue;
                    dis[j] = Math.min(dis[j], min+graph[minPoint][j]);
                }
            }

            return dis;
        }
    }


    /**
     * 深度优先遍历 求两点间最短路径
     */
    public static class DFS {

        static int min = Integer.MAX_VALUE;
        static int target = -1;
        static int[][] graph;
        static int[] visited;


        /**
         * 牛客 https://ac.nowcoder.com/acm/problem/17511 两点最短路径
         * DFS超时 只能过35%
         * @param args
         */
        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextInt()) {

                int n = scanner.nextInt(), m = scanner.nextInt(), s = scanner.nextInt(), t = scanner.nextInt();
                int[][] graph = initGraph(n);
                for (int i=0; i<m; i++) {
                    int a = scanner.nextInt(), b = scanner.nextInt(), v = scanner.nextInt();
                    graph[a-1][b-1] = v;
                    graph[b-1][a-1] = v;
                }

                int shortestDis = shortestDis(graph, s, t);
                System.out.println(shortestDis);
            }
        }

        /**
         * 两点间最短路径
         * @param g 邻接矩阵
         * @param s 源点
         * @param t 目标点
         * @return 最短距离
         */
        public static int shortestDis(int[][] g, int s, int t) {

            target = t-1;
            min = Integer.MAX_VALUE;
            graph = g;
            visited = new int[graph.length];

            visited[s-1] = 1;
            dfs(0, s-1);

            return min;
        }

        public static void dfs(int dis, int cur) {

            if (min <= dis) return;
            if (cur == target) {
                min = Math.min(min, dis);
                return;
            }

            for (int i=0; i<graph[cur].length; i++) {

                if (visited[i] == 0 && graph[cur][i] != Integer.MAX_VALUE) {
                    visited[i] = 1;
                    dfs(dis+graph[cur][i], i);
                    visited[i] = 0;
                }
            }
        }
    }
}
