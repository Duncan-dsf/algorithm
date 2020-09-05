package dsf.algorithm.leetcode.weekly.c203;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * TODO 没过
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/24 16:19
 */
public class P3 {

    public int findLatestStep(int[] arr, int m) {

        if (arr == null || arr.length < m) return -1;
        int n = arr.length;
        if (m == n) return n;
        Node.init();
        Node root = new Node(1, n);
        for (int i=n-1; i>=1; i--) {
            Node node = root.find(arr[i]);
            node.split(arr[i]);
            if (Node.map.get(m) != null && Node.map.get(m) >= 1)
                return i;
        }
        return -1;
    }

    private static class Node {

        static HashMap<Integer, Integer> map = new HashMap<>();
        int splitI = -1;
        int li;
        int ri;
        int len;
        Node left;
        Node right;

        public Node(int li, int ri) {
            this.li = li;
            this.ri = ri;
            len = ri-li+1;
            map.put(len, map.getOrDefault(len, 0)+1);
        }

        public void split(int split) {
            this.splitI = split;
            if (li == ri) return;
            map.put(len, map.get(len)-1);
            if (splitI-1 >= li)
                left = new Node(li, splitI-1);
            if (splitI+1 <= ri)
                right = new Node(splitI+1, ri);
        }

        public Node find(int i) {

            if (i < li || i > ri) return null;
            if (splitI == -1 || splitI == i)
                return this;
            if (i < splitI) return left.find(i);

            return right.find(i);
        }

        public static void init() {
            map.clear();
        }
    }

    public static void main(String[] args) {
        int latestStep = new P3().findLatestStep(new int[]{3, 1, 5, 4, 2}, 2);
        System.out.println(latestStep);
    }
}
