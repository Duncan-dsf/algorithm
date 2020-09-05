package dsf.algorithm.interview.xiaomi.m20200825;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 两个有序数组和的top K
 * https://www.nowcoder.com/practice/7201cacf73e7495aa5f88b223bbbf6d1
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/25 18:53
 */
public class P2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {

            int n = scanner.nextInt(), k = scanner.nextInt();
            int[] arr1 = new int[n], arr2 = new int[n];
            for (int i=0; i<n; i++) {
                arr1[i] = scanner.nextInt();
            }
            for (int i=0; i<n; i++) arr2[i] = scanner.nextInt();
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            int[] res = topK(arr1, arr2, k);
            for (int i=0; i<k; i++) {
                System.out.print(res[i]);
                if (i != k-1) System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static int[] topK(int[] arr1, int[] arr2, int k) {

        int n = arr1.length;
        PriorityQueue<Node> queue = new PriorityQueue<>(k, (n1, n2) -> Integer.compare(n2.sum, n1.sum));
        queue.add(new Node(n-1, n-1, arr1[n-1]+arr2[n-1]));
        int[] res = new int[k];
        int resC = 0;
        HashSet<String> set = new HashSet<>((int)(n/0.75));
        set.add("0_0");
        for (; resC < k; resC++) {

            Node node = queue.poll();
            res[resC] = node.sum;
            if (node.i > 0 && !set.contains((node.i-1)+"_"+ node.j)) {
                queue.add(new Node(node.i-1, node.j, arr1[node.i-1]+arr2[node.j]));
                set.add((node.i-1)+"_"+ node.j);
            }
            if (node.j > 0 && !set.contains(node.i+"_"+(node.j-1))) {
                queue.add(new Node(node.i, node.j-1, arr1[node.i]+arr2[node.j-1]));
                set.add(node.i+"_"+(node.j-1));
            }
        }
        return res;
    }

    private static class Node {
        int i;
        int j;
        int sum;

        public Node(int i, int j, int sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }
    }
}
