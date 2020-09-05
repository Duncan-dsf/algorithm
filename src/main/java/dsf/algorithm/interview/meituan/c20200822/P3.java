package dsf.algorithm.interview.meituan.c20200822;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/22 15:56
 */
public class P3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {

            int n = scanner.nextInt();
            int[] weight = new int[n+1];
            int[] order = new int[n];
            int sum = 0;
            for (int i=1; i<=n; i++) {
                weight[i] = scanner.nextInt();
                sum += weight[i];
            }
            for (int i=0; i<n; i++) order[i] = scanner.nextInt();

            Node root = new Node(sum, 1, n);

            for (int i=0; i<n; i++) {

                int index = order[i];
                Node cur = root.getBelongNode(index);
                int lSum = 0;
                for (int j = cur.lRange; j<index; j++) {
                    lSum += weight[j];
                }
                cur.split(index, weight[index], lSum);
                System.out.println(Node.list.peek());
            }
        }
    }

    private static class Node {

        public static PriorityQueue<Integer> list = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        int sum;
        int index;
        int val;
        int lRange;
        int rRange;
        Node left;
        Node right;

        public boolean isIn(int i) {
            return  (lRange <= i && rRange >= i);
        }

        public Node getBelongNode(int i) {

            if (!isIn(i)) return null;

            Node lRes = null, rRes = null;

            if (left != null) lRes = left.getBelongNode(i);
            if (right != null) rRes = right.getBelongNode(i);

            if (lRes != null) return lRes;
            if (rRes != null) return rRes;
            return this;
        }

        public void split(int i, int val, int lSum) {

            index = i;
            this.val = val;
            int rSum = sum - val - lSum;
            list.remove(sum);
            if (lRange == rRange) return;
            left = new Node(lSum, lRange, i-1);
            right = new Node(rSum, i+1, rRange);
        }

        public Node(int sum, int lRange, int rRange) {
            this.sum = sum;
            this.lRange = lRange;
            this.rRange = rRange;
            list.add(sum);
        }
    }
}
