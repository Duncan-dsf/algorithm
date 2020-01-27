package dsf.algorithm.archive.data_staruct.monotonous_stack;

import java.util.Scanner;

/**
 * 单调栈 https://ac.nowcoder.com/acm/problem/25084
 * 求每个点开始 连续比自己小的数的个数
 * TODO 通过30%
 * @author 董少飞
 * @date 2020/1/21
 */
public class P25084 {

    static int[] stack, arr, res;
    static int top = -1, n, sum;


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {

            n = scanner.nextInt();
            stack = new int[n];
            arr = new int[n];
            res = new int[n];
            sum = 0;
            top = -1;
            for (int i=0; i<n; i++) {
                arr[i] = scanner.nextInt();
            }

            fun();
            System.out.println(sum);
        }
    }

    public static void fun() {

        for (int i=0; i<n; i++) {
            while (top >= 0 && arr[stack[top]] < arr[i]) {
                res[stack[top]] = i - stack[top] - 1;
                sum += res[stack[top]];
                top--;
            }
            stack[++top] = i;
        }

        while (top >= 0) {
            res[stack[top]] = n - 1 - stack[top];
            sum += res[stack[top--]];
        }
    }
}
