package dsf.algorithm.interview.jd.b20200827;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * AC 中下
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/27 19:23
 */
public class P1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] dp = new int[1100];
        dp[1] = 2;
        dp[2] = 3;
        dp[3] = 5;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(2);
        queue.add(3);
        queue.add(5);
        for (int i=4; i<=1000; ) {

            LinkedList<Integer> newQueue = new LinkedList<>();
            while (queue.size() > 0) {
                if (i > 1000)
                    break;
                Integer j = queue.removeFirst();
                dp[i++] = j*10+2;
                dp[i++] = j*10+3;
                dp[i++] = j*10+5;
                newQueue.add(j*10+2);
                newQueue.add(j*10+3);
                newQueue.add(j*10+5);
            }
            queue = newQueue;
        }
        while (scanner.hasNextInt()) {

            int n = scanner.nextInt();
            System.out.println(dp[n]);
        }
    }
}
