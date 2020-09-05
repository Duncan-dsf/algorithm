package dsf.algorithm.interview.xiaohongshu.b20200830;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * TODO
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/30 20:43
 */
public class P3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt(), m = scanner.nextInt(), r = scanner.nextInt(), c = scanner.nextInt();
            int[][] arr = new int[n][m];
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++)
                    arr[i][j] = scanner.nextInt();
            }
            HashSet<Integer> columns = new HashSet<>((int)(c/3.0*4+1)), rows = new HashSet<>((int)(r/3.0*4+1));

        }
    }



}
