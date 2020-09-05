package dsf.algorithm.interview.pdd.c20200901;

import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;

import java.util.*;

/**
 * AC
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/9/1 19:49
 */
public class P3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt(), m = scanner.nextInt();
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = scanner.nextInt();
                arr[i][1] = scanner.nextInt();
            }
            HashMap<Integer, Integer> dp = new HashMap<>(), cur = new HashMap<>();
            dp.put(m, 0);
            dp.put(m - arr[0][0], arr[0][1]);
            for (int i = 1; i < n; i++) {
                cur.putAll(dp);
                for (Map.Entry<Integer, Integer> entry : dp.entrySet()) {
                    int c = entry.getKey(), v = entry.getValue();
                    if (cur.containsKey(c - arr[i][0])) {
                        cur.put(c - arr[i][0], Math.max(cur.get(c - arr[i][0]), v + arr[i][1]));
                    } else
                        cur.put(c - arr[i][0], v + arr[i][1]);
                }
                HashMap<Integer, Integer> temp = dp;
                dp = cur;
                cur = temp;
                cur.clear();
            }

            int max = 0;
            for (Map.Entry<Integer, Integer> entry : dp.entrySet()) {
                if (entry.getKey() >= 0)
                    max = Math.max(max, entry.getValue());
            }
            System.out.println(max);
        }
    }
}

