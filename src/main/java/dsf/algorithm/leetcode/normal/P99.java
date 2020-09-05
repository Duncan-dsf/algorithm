package dsf.algorithm.leetcode.normal;

import dsf.algorithm.leetcode.weekly.c174.P3;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/8 10:07
 */
public class P99 {
    TreeNode last, l, r;

    public void recoverTree(TreeNode root) {

        if (root == null) return;
        recursion(root);
        int temp = l.val;
        l.val = r.val;
        r.val = temp;
    }

    public void recursion(TreeNode root) {

        if (root.left != null) {
            recursion(root.left);
        }
        if (last != null) {
            if (l == null) {
                if (last.val > root.val) {
                    l = last;
                    r = root;
                }
            } else {
                if (last.val > root.val) {
                    r = root;
                }
            }
        }
        last = root;

        if (root.right != null) {
            recursion(root.right);
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

        new P99().recoverTree(new TreeNode(3, new TreeNode(1), new TreeNode(4, new TreeNode(2), null)));
    }
}
