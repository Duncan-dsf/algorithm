package dsf.algorithm.meituan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * TODO
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/5/12 10:30
 */
public class P3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {

            int n = scanner.nextInt(), m = scanner.nextInt();

            ArrayList<Integer> destory = new ArrayList<>(m);
            for (int i=0; i<m; i++) {
                int op = scanner.nextInt(), pos = scanner.nextInt();
                if (op == 1) {
                    destory.add(pos);
                } else {
                    Collections.sort(destory);
                    int down = pos;
                    for (int j=0; j<destory.size(); j++) {
                        if (destory.get(j) == down) {
                            down++;
                        } else if (destory.get(j) > down)
                            break;
                    }
                    if (down <= n)
                        System.out.println(down);
                    else
                        System.out.println(-1);
                }
            }

//            int[] arr = new int[n+1];
//            for (int i=1; i<=n; i++) arr[i] = i;
//
//            for (int i=0; i<m; i++) {
//                int op = scanner.nextInt(), pos = scanner.nextInt();
//                if (op == 1) {
//                    if (pos == n)
//                        arr[pos] = -1;
//                    else {
//                        arr[pos] = arr[pos+1];
//                    }
//                    for (int j=1; j<pos; j++) {
//                        if (arr[j] == pos) {
//                            arr[j] = arr[pos];
//                        }
//                    }
//                } else {
//                    System.out.println(arr[pos]);
//                }
//            }
        }
    }
}
