package dsf.algorithm.interview.meituan.c20200512;

import java.util.Scanner;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/5/12 10:15
 */
public class P2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = scanner.nextInt();
        }

        int res = 0;
        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                res = Math.max(res, get(arr[i], arr[j]));
            }
        }
        System.out.println(res);
    }

    public static int get(int a, int b) {
        int c = a ^ b, res = 0;
        while (c > 0) {
            if ((c & 1) == 1) {
                res++;
            }
            c >>= 1;
        }
        return res;
    }
}
