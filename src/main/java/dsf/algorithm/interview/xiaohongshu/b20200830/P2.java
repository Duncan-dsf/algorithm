package dsf.algorithm.interview.xiaohongshu.b20200830;

import java.util.Arrays;
import java.util.Scanner;

/**
 * TODO
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/30 20:01
 */
public class P2 {

    /*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
******************************开始写代码******************************/
    static int maxBoxes(int[][] boxes) {
        if (boxes == null) return 0;
        int n = boxes.length;
        if (n <= 1) return n;
        Node[] arr = new Node[n];
        for (int i=0; i<n; i++) {
            int[] box = boxes[i];
            Node node = new Node(box[0], box[1]);
            arr[i] = node;
        }
        Arrays.sort(arr, (n1, n2) -> {
            if (n1.d == n2.d) {
                return Integer.compare(n1.h, n2.h);
            }
            return Integer.compare(n1.d, n2.d);
        });
        int max = 1;
        int[] dp = new int[n];
        dp[n-1] = 1;
        for (int i=n-2; i>=0; i--) {
            int m = 1;
            for (int j=i+1; j<n; j++) {
                if (arr[i].d < arr[j].d && arr[i].h < arr[j].h) {
                    m = Math.max(m, dp[j]+1);
                }
            }
            dp[i] = m;
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    private static class Node {
        int h;
        int d;

        public Node(int h, int d) {
            this.h = h;
            this.d = d;
        }
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _boxes_rows = 0;
        int _boxes_cols = 0;
        _boxes_rows = Integer.parseInt(in.nextLine().trim());
        _boxes_cols = Integer.parseInt(in.nextLine().trim());

        int[][] _boxes = new int[_boxes_rows][_boxes_cols];
        for(int _boxes_i=0; _boxes_i<_boxes_rows; _boxes_i++) {
            for(int _boxes_j=0; _boxes_j<_boxes_cols; _boxes_j++) {
                _boxes[_boxes_i][_boxes_j] = in.nextInt();

            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        res = maxBoxes(_boxes);
        System.out.println(String.valueOf(res));

    }
}
