package dsf.algorithm.leetcode.normal;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/9/4 7:33
 */
public class P257 {

    ArrayList<String> res = new ArrayList<>(10);
    public List<String> binaryTreePaths(TreeNode root) {

        dfs(root, new StringBuilder());
        return res;
    }

    public void dfs(TreeNode root, StringBuilder sb) {

        if (root == null) {
            return;
        }
        if (sb.length() == 0)
            sb.append(root.val);
        else sb.append("->").append(root.val);
        if (root.left == null && root.right == null) {
            res.add(sb.toString());
        } else {
            if (root.left != null)
                dfs(root.left, new StringBuilder(sb));
            if (root.right != null)
                dfs(root.right, new StringBuilder(sb));
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(37, new TreeNode(-34, null, new TreeNode(-100)),
                new TreeNode(-48, new TreeNode(-100), new TreeNode(48, new TreeNode(-54, new TreeNode(-71), new TreeNode(-22, null, new TreeNode(8))), null)));
        new P257().binaryTreePaths(root);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
