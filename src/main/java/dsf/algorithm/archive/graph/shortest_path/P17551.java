package dsf.algorithm.archive.graph.shortest_path;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author : dongshaofei
 * @version V1.0
 * @Project: algorithm
 * @Package dsf.algorithm.archive.graph.shortest_path
 * @Description: TODO
 * @date Date : 2020年01月16日 14:37
 * <p>
 * DFS超时 {@link ShortestPath.DFS#main}
 * https://ac.nowcoder.com/acm/problem/17511
 * 求两点间最短距离
 *
 * TODO 通过 70%
 */
public class P17551 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {

            int n = scanner.nextInt(), m = scanner.nextInt(), s = scanner.nextInt(), t = scanner.nextInt();
            int[][] graph = initGraph(n);
            for (int i = 0; i < m; i++) {
                int a = scanner.nextInt(), b = scanner.nextInt(), v = scanner.nextInt();
                graph[a - 1][b - 1] = v;
                graph[b - 1][a - 1] = v;
            }

            int[] shortestDis = dijkstra(graph, s - 1);
            System.out.println(shortestDis[t - 1]==Integer.MAX_VALUE?-1:shortestDis[t-1]);
        }
    }

    public static int[][] initGraph(int n) {

        int[][] graph = new int[n][n];
        for (int i = 0, j; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (i == j) graph[i][j] = 0;
                else graph[i][j] = Integer.MAX_VALUE;
            }
        }
        return graph;
    }

    public static int[] dijkstra(int[][] graph, int s) {

        int n = graph.length;
        int[] dis = new int[n];
        System.arraycopy(graph[s], 0, dis, 0, n);

        PriorityQueue<Node> queue = new PriorityQueue<Node>(n, Comparator.comparingInt(no -> no.dis));
        for (int i=0; i<n; i++) {
            if (i == s) continue;
            queue.add(new Node(i, dis[i]));
        }


        int[] visited = new int[n];
        visited[s] = 1;
        for (int i = 1; i < n; i++) {

            Node node = queue.poll();

            if (visited[node.p] == 1)
                continue;

            visited[node.p] = 1;
            if (node.dis == Integer.MAX_VALUE)
                continue;

            for (int j = 0; j < n; j++) {

                if (visited[j]==1 && graph[node.p][j] == Integer.MAX_VALUE)
                    continue;
                if (node.dis+graph[node.p][j] < dis[j]) {

                    dis[j] = node.dis+graph[node.p][j];
                    queue.add(new Node(j, dis[j]));
                }
            }
        }
        return dis;
    }

    static class Node {
        int p;
        int dis;

        public Node(int p, int dis) {
            this.p = p;
            this.dis = dis;
        }
    }
}
