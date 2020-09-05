package dsf.algorithm.leetcode.offer;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/20 16:48
 */
public class P4 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int n = matrix.length, m = matrix[0].length;
        for (int i=0, j=m-1; i<n && j>-1; ) {
            int v = matrix[i][j];
            if (target == v) return true;
            if (v > target) {
                j--;
            } else i++;
        }
        return false;
    }
}
