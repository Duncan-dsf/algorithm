package dsf.algorithm.leetcode.offer;

import java.util.*;

/**
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/28 19:33
 */
public class P32_3 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null)
            return new ArrayList<>();
        LinkedList<TreeNode> list = new LinkedList<>(), temp = new LinkedList<>();
        LinkedList<List<Integer>> res = new LinkedList<>();
        list.add(root);
        boolean flag = true;
        while (!list.isEmpty()) {
            LinkedList<Integer> curRes = new LinkedList<>();
            while (!list.isEmpty()) {
                TreeNode node = list.removeFirst();
                if (flag)
                    curRes.add(node.val);
                else curRes.addFirst(node.val);
                if (node.left != null) {
                    temp.add(node.left);
                }
                if (node.right != null) {
                    temp.add(node.right);
                }
            }
            flag = !flag;
            LinkedList<TreeNode> t = list;
            list = temp;
            temp = t;
            res.add(curRes);
        }
        return res;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
