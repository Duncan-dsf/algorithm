package dsf.algorithm.leetcode.offer;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/22 9:23
 */
public class P13 {

    int m;
    int n;
    int k;
    int[][] sum;
    int res;

    public int movingCount(int m, int n, int k) {

        this.m = m;
        this.n = n;
        this.k = k;
        sum = new int[m][n];
        dfs(0, 0);
        return res;
    }

    public void dfs(int i, int j) {

        if (i < 0 || i >= m || j < 0 || j >= n || sum[i][j] != 0) return;

        sum[i][j] = getSum(i, j);
        if (sum[i][j] <= k) {
            res++;
            dfs(i, j+1);
            dfs(i+1, j);
        }
    }

    public int getSum(int a, int b) {

        int sum = 0;
        if (a == 100) sum += 1;
        else {
            sum += a%10;
            sum += a/10;
        }
        if (b == 100) sum += 1;
        else {
            sum += b%10;
            sum += b/10;
        }
        return sum;
    }

//    int m;
//    int n;
//    int k;
//    boolean[][] flag;
//    int res;
//
//    public int movingCount(int m, int n, int k) {
//
//        this.m = m;
//        this.n = n;
//        this.k = k;
//        flag = new boolean[m][n];
//        dfs(0, 0);
//        return res;
//    }
//
//    public void dfs(int i, int j) {
//
//        if (i < 0 || i >= m || j < 0 || j >= n || flag[i][j]) return;
//
//        flag[i][j] = true;
//        if (getSum(i, j) <= k) {
//            res++;
//            dfs(i, j+1);
//            dfs(i+1, j);
//        }
//    }
//
//    public int getSum(int a, int b) {
//
//        int sum = 0;
//        if (a == 100) sum += 1;
//        else {
//            sum += a%10;
//            sum += a/10;
//        }
//        if (b == 100) sum += 1;
//        else {
//            sum += b%10;
//            sum += b/10;
//        }
//        return sum;
//    }
}
