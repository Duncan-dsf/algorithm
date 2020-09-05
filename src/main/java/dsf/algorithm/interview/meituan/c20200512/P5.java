package dsf.algorithm.interview.meituan.c20200512;

import java.util.Scanner;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/5/12 10:53
 */
public class P5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] arr = new int[n], res = new int[n];
            for (int i=0; i<n; i++) arr[i] = scanner.nextInt();

            for (int i=0; i<n; i++) {
                if (res[i] == 1) {
                    System.out.println(1);
                } else {

                    boolean flag = false;
                    for (int j=0; j<n; j++) {
                        if ((arr[i] & arr[j]) == 0) {
                            System.out.print(1);
                            res[i] = 1;
                            res[j] = 1;
                            flag = true;
                            break;
                        }
                    }
                    if (!flag)
                        System.out.print(-1);
                }
                if (i < n-1)
                    System.out.print(" ");
            }
        }
    }
}
