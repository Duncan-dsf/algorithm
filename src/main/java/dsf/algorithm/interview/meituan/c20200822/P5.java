package dsf.algorithm.interview.meituan.c20200822;

import java.util.Scanner;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/22 17:53
 */
public class P5 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int[] arr = new int[x+y];
            for (int i=0; i<x+y; i++) arr[i] = scanner.nextInt();
            for (int i=0; i<x; i++) System.out.print('A');
            for (int i=0; i<y; i++) System.out.println('B');
            System.out.println();
        }
    }
}
