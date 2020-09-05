package dsf.algorithm.interview.meituan.c20200822;

import java.util.*;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/22 15:56
 */
public class P2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] value = new int[n];
            List<Node> list = new ArrayList<>(n);
            for (int i=0; i<n; i++) {
                value[i] = scanner.nextInt();
                value[i] += scanner.nextInt()*2;
                list.add(new Node(i+1, value[i]));
            }
            list.sort((a, b) -> {
                if (b.value == a.value) {

                    return compare(a.index, b.index);
                }
                return Integer.compare(b.value, a.value);
            });
            ArrayList<Integer> res = new ArrayList<>(m);
            for (int i=0; i<m; i++) {
                res.add(list.get(i).index);
            }
            res.sort(Integer::compareTo);
            for (int i=0; i<m; i++) {
                System.out.print(list.get(i).index);
                if (i < m-1) System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static int compare(int a, int b) {

        String s1 = String.valueOf(a), s2 = String.valueOf(b);
        int i1 = 0, i2 = 0;
        for (; i1<s1.length() && i2<s2.length(); i1++, i2++) {

            if (s1.charAt(i1) < s2.charAt(i2)) return -1;
            else if (s1.charAt(i2) > s2.charAt(i2)) return 1;
        }
        if (i1 == i2) return 0;
        if (i1 == 0) return -1;
        else return 1;
    }

    private static class Node {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }


}
