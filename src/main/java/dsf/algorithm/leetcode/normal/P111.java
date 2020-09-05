package dsf.algorithm.leetcode.normal;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/22 7:24
 */
public class P111 {

    public int minDepth(TreeNode root) {

        return dfs(root);
    }

    public int dfs(TreeNode root) {

        if (root == null) return 0;
        int l = dfs(root.left), r = dfs(root.right);
        if (l == 0) return r+1;
        if (r == 0) return l+1;
        return Math.min(l, r) + 1;
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
