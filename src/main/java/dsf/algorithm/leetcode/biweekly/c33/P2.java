package dsf.algorithm.leetcode.biweekly.c33;

import java.util.LinkedList;
import java.util.List;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/22 22:59
 */
public class P2 {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {

        int[] nodes = new int[n];
        for (List<Integer> edge : edges) {

            nodes[edge.get(1)] = 1;
        }
        List<Integer> res = new LinkedList<>();
        for (int i=0; i<n; i++) {
            if (nodes[i] == 0)
                res.add(i);
        }
        return res;
    }

    public void union(int[] father, int a, int b) {

        int fa = find(father, a);
        int fb = find(father, b);
        if (fa != fb) {
            father[father[a]] = Math.min(fa, fb);
            father[father[b]] = Math.min(fa, fb);
        }
    }

    public int find(int[] father, int a) {

        if (father[a] != a) {

            father[a] = find(father, father[a]);
        }
        return father[a];
    }
}
