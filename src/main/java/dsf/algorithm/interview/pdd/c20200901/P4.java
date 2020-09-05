package dsf.algorithm.interview.pdd.c20200901;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 45%
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/9/1 19:18
 */
public class P4 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {

            int n = scanner.nextInt(), m = scanner.nextInt();
            int[] arr = new int[m];
            for (int i=0; i<m; i++) arr[i] = scanner.nextInt();
            int res = 0;
            Arrays.sort(arr);
            ArrayList<Integer> list = new ArrayList<>(m);
            boolean flag2 = false, flag3 = false, flag5 = false;
            for (int i=0; i<m; i++) {
                if (arr[i] == 2) {

                    flag2 = true;
                    list.add(arr[i]);
                }
                else if (arr[i] == 3) {

                    list.add(arr[i]);
                    flag3 = true;
                }
                else if (arr[i] == 5) {

                    list.add(arr[i]);
                    flag5 = true;
                }
                else {
                    if ((arr[i]%2 == 0 && flag2) || (flag3 && arr[i]%3 == 0) || (flag5 && arr[i] == 10))
                        continue;
                    list.add(arr[i]);
                }
            }

            for (int i=2; i<=n; i++) {
                for (Integer j : list) {
                    if (i%j == 0) {

                        res++;
                        break;
                    }
                }
            }
            System.out.println(res);
        }
    }
}
