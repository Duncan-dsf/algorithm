package dsf.algorithm.leetcode.offer;

import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/28 18:59
 */
public class P32_1 {

    public int[] levelOrder(TreeNode root) {

        if (root == null)
            return new int[]{};
        LinkedList<TreeNode> list = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            TreeNode node = list.removeFirst();
            res.add(node.val);
            if (node.left != null) list.add(node.left);
            if (node.right != null) list.add(node.right);
        }
        int[] arr = new int[res.size()];
        for (int i=0; i<arr.length; i++) arr[i] = res.removeFirst();
        return arr;
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

    public static void main(String[] args) {

        int[] ints = new P32_1().levelOrder(new TreeNode(3, new TreeNode(9, new TreeNode(15), new TreeNode(17)), new TreeNode(20)));
        System.out.println(Arrays.toString(ints));
    }

}
