package dsf.algorithm.leetcode.weekly.c174;

import java.util.PriorityQueue;

/**
 * 通过
 * @author 董少飞
 * @date 2020/2/2
 */
public class P1 {

    public int[] kWeakestRows(int[][] mat, int k) {

        PriorityQueue<Node> queue = new PriorityQueue<>((n1, n2) -> {
            if (n1.n < n2.n)
                return -1;
            if (n1.n > n2.n)
                return 1;
            return Integer.compare(n1.i, n2.i);
        });

        for (int i=0; i<mat.length; i++) {
            int n = 0;
            int[] arr = mat[i];
            for (; n<arr.length && arr[n] == 1; n++) {}
            queue.add(new Node(i, n));
        }

        int[] ans = new int[k];
        for (int i=0; i<k; i++) {
            ans[i] = queue.poll().i;
        }
        return ans;
    }

    static class Node {
        int i, n;

        public Node(int i, int n) {
            this.i = i;
            this.n = n;
        }
    }
}
