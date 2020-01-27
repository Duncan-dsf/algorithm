package dsf.algorithm.leetcode.weekly.c173;

import java.util.PriorityQueue;

/**
 * 多源最短路径
 * floyd 通过
 * @author 董少飞
 * @date 2020/1/27
 */
public class P3 {

    public static void main(String[] args) {
        int n = new P3().findTheCity(4, new int[][]{
                {0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}
        }, 4);
        System.out.println(n);
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int[][] graph = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {

                if (i == j)
                    graph[i][j] = 0;
                else
                    graph[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int[] edge : edges) {
            int i = edge[0], j = edge[1], v = edge[2];
            graph[i][j] = v;
            graph[j][i] = v;
        }

        floyd(graph);

        PriorityQueue<Node> queue = new PriorityQueue<>((n1, n2) -> {
            if (n1.num < n2.num)
                return -1;
            if (n1.num > n2.num)
                return 1;
            if (n1.id > n2.id)
                return -1;
            return 1;
        });

        for (int i=0; i<n; i++) {
            int num = 0;
            for (int j=0; j<n; j++) {

                if (graph[i][j] <= distanceThreshold)
                    num++;
            }
            queue.add(new Node(i, num));
        }

        return queue.poll().id;
    }

    public void floyd(int[][] graph) {
        int n = graph.length;
        for (int k=0; k<n; k++) {
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++)
                    if (graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE &&
                            graph[i][k] + graph[k][j] < graph[i][j])
                        graph[i][j] = graph[i][k] + graph[k][j];
            }
        }
    }

    static class Node {
        int id, num;

        public Node(int id, int num) {
            this.id = id;
            this.num = num;
        }
    }
}
