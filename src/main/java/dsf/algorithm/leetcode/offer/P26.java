package dsf.algorithm.leetcode.offer;

import dsf.algorithm.leetcode.normal.P105;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/22 12:37
 */
public class P26 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {

        if (B == null) return false;
        return dfs(A, B);
    }

    public boolean dfs(TreeNode r1, TreeNode r2) {

        if (r2 == null) return true;
        if (r1 == null) return false;

        if(r1.val == r2.val && match(r1, r2)) {
            return true;
        }
        return dfs(r1.left, r2) || dfs(r1.right, r2);
    }

    public boolean match(TreeNode r1, TreeNode r2) {

        if (r2 == null) return true;
        if (r1 == null) return false;
        if (r1.val != r2.val) return false;

        return match(r1.right, r2.right) && match(r1.left, r2.left);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
