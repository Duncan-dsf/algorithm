package dsf.algorithm.interview.meituan.c20200512;

import java.util.HashSet;
import java.util.Scanner;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/5/12 10:02
 */
public class P1 {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt(), m = scanner.nextInt();
            int[][] arr = new int[n][m];
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }

            HashSet<Integer> res = new HashSet<>(), mn = new HashSet<>();
            for (int j=0; j<m; j++) {
                int max = 0;
                mn.clear();
                for (int i=0; i<n; i++) {
                    if (max < arr[i][j]) {
                        max = arr[i][j];
                        mn.clear();
                        mn.add(i);
                    } else if (max == arr[i][j]) {
                        mn.add(i);
                    }
                }
                res.addAll(mn);
            }

            System.out.println(res.size());
        }
    }
}
