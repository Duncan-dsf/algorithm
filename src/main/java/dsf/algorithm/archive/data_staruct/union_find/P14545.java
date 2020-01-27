package dsf.algorithm.archive.data_staruct.union_find;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 牛客 https://ac.nowcoder.com/acm/problem/14545
 * @author 董少飞
 * @date 2020/1/21
 */
public class P14545 {

    // edges 边的数组 长度m edges[i][0], edges[i][1]表示边的两点
    // nodes 点的数组 长度n nodes[i][0]表示i点所需的精力 nodes[i][1]表示i点的价值
    static int[][] edges, nodes;

    static Map<Integer, Gather> gatherMap = new HashMap<>();
    static int[] father;
    static int n, m, c;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        scanner.nextInt();
        while (scanner.hasNextInt()) {

            n = scanner.nextInt();
            m = scanner.nextInt();
            c = scanner.nextInt();

            nodes = new int[n][2];
            father = new int[n];
            edges = new int[m][2];
            for (int i=1; i<n; i++) {
                nodes[i][0] = scanner.nextInt();
                nodes[i][1] = scanner.nextInt();
            }

            for (int i=0; i<m; i++) {
                edges[i][0] = scanner.nextInt();
                edges[i][1] = scanner.nextInt();
            }

            gatherMap.clear();

            fun();
        }
    }

    public static void fun() {

        unionFind();


        for (int i=0; i<n; i++) {

            if (!gatherMap.containsKey(find(i))) {
                Gather gather = new Gather();
                gather.root = father[i];
                gather.minCost = nodes[i][0];
                gather.value += nodes[i][1];
                gatherMap.put(gather.root, gather);
            } else {

                Gather gather = gatherMap.get(father[i]);
                gather.value += nodes[i][1];
                gather.minCost = Math.min(nodes[i][0], gather.minCost);
            }
        }

        int k=0;
        int size = gatherMap.size();
        int[] cost = new int[size], values = new int[size];
        for (Map.Entry<Integer, Gather> entry : gatherMap.entrySet()) {

            Gather gather = entry.getValue();
            cost[k] = gather.minCost;
            values[k++] = gather.value;
        }

        int[][] dp = new int[size][c+1];
        for (int i = 0; i< size; i++) {

            for (int j=1; j<=c; j++) {

                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-cost[i]]+values[i]);
            }
        }

        System.out.println(dp[size-1][c]);
    }

    public static void unionFind() {

        for (int[] edge : edges) {

            union(edge[0]-1, edge[1]-1);
        }
    }

    public static void union(int i, int j) {

        if (find(i) != find(j)) {

            father[find(j)] = find(i);
        }
    }

    public static int find(int i) {

        if (father[i] == 0)
            return i;

        father[i] = find(father[i]);
        return father[i];
    }

    static class Gather {

        int root, minCost, value;
    }
}
