package dsf.algorithm.archive.graph.min_tree;

import java.util.Comparator;
import java.util.List;

/**
 * @author : dongshaofei
 * @version V1.0
 * @Project: algorithm
 * @Package dsf.algorithm.archive.graph.min_tree
 * @Description: TODO
 * @date Date : 2020年01月17日 10:35
 */
public class MinTree {

    /**
     *
     */
    public static class Kruskal {

        private static int[] father;

        /**
         * 给边排序 从小到大依次加入集合
         * @param edgeList 边
         * @param n 点的数量
         * @return 最小生成树的边的权值之和 -1表示不可联通
         */
        public static int minTree(List<Edge> edgeList, int n) {

            father = new int[n+1];
            int min = 0, num = 0;
            edgeList.sort(Comparator.comparingInt(e -> e.d));

            for (Edge edge : edgeList) {

                if (find(edge.a) == find(edge.b))
                    continue;
                if (father[edge.b] == 0)
                    father[edge.b] = edge.a;
                else
                    father[father[edge.b]] = edge.a;
                min += edge.d;
                if (++num == n-1)
                    break;
            }

            return num == n-1 ? min : -1;
        }

        static int find(int n) {

            if (father[n] == 0)
                return n;
            father[n] = find(father[n]);
            return father[n];
        }
    }

    static class Edge {

        int a, b, d;

        public Edge(int a, int b, int d) {
            this.a = Math.min(a, b);
            this.b = Math.max(a, b);
            this.d = d;
        }
    }
}
