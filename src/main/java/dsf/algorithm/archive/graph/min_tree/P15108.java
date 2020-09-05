package dsf.algorithm.archive.graph.min_tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author : dongshaofei
 * @version V1.0
 * @Project: algorithm
 * @Package dsf.algorithm.archive.graph.min_tree
 * @Description:
 * @date Date : 2020年01月17日 11:02
 *
 * 牛客 https://ac.nowcoder.com/acm/problem/15108 最小生成树
 * AC
 */
public class P15108 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int c = scanner.nextInt(), n = scanner.nextInt(), m = scanner.nextInt();
            List<MinTree.Edge> edges = new LinkedList<>();
            for (int i=0; i<n; i++) {
                int a = scanner.nextInt(), b = scanner.nextInt(), d = scanner.nextInt();
                edges.add(new MinTree.Edge(a, b, d));
            }

            int minTree = MinTree.Kruskal.minTree(edges, m);
            if (minTree == -1 || minTree > c)
                System.out.println("No");
            else
                System.out.println("Yes");
        }
    }
}
