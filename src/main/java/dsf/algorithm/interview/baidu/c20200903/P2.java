package dsf.algorithm.interview.baidu.c20200903;

import java.util.Scanner;

/**
 * TODO
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/9/3 19:54
 */
public class P2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int T = scanner.nextInt();
            for (int t=0; t<T; t++) {
                int n = scanner.nextInt(), m =scanner.nextInt();
                Node root = new Node(1, n);
                for (int i=0; i<m; i++) {
                    int K = scanner.nextInt();
                    for (int k=0; k<K; k++) {

                    }
                }
            }
        }
    }
    private static class Node {
        int lr;
        int rr;
        int value = -1;
        Node left;
        Node right;
        boolean hasChild;
        boolean ok = true;

        public Node(int lr, int rr) {
            this.lr = lr;
            this.rr = rr;
        }

        public void mark(int i, int j) {

            if (i<lr || j>rr) return;
            if (!hasChild) {

            }
        }

        public void split(int i, int j) {
            int mid = (lr+rr)/2;
            if (Math.abs(mid-i) <= Math.abs(mid-j)) {

            }
        }
    }

}
