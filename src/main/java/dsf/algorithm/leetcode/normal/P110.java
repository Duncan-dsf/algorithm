package dsf.algorithm.leetcode.normal;

import java.util.HashMap;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/17 8:52
 */
public class P110 {

//    HashMap<TreeNode, Integer> map = new HashMap<>();
//    public boolean isBalanced(TreeNode root) {
//
//        map.put(null, 0);
//        deep(root);
//
//        return recursion(root);
//    }

//    public boolean recursion(TreeNode root) {
//
//        if (root == null)
//            return true;
//
//        if (Math.abs(map.get(root.left) - map.get(root.right)) > 1)
//            return false;
//
//        return recursion(root.left) && recursion(root.right);
//    }
//
//    public int deep(TreeNode root) {
//
//        if (root == null) return 0;
//
//        if (!map.containsKey(root)) {
//
//            map.put(root, Math.max(deep(root.left), deep(root.right)) + 1);
//        }
//        return map.get(root);
//    }


    public boolean isBalanced(TreeNode root) {

        Node node = recursion1(root);
        return node.isB;
    }

    public Node recursion1(TreeNode root) {

        if (root == null) {
            return new Node(0, true);
        }
        Node node = new Node();
        Node left = recursion1(root.left), right = recursion1(root.right);

        node.deep = Math.max(left.deep, right.deep)+1;
        node.isB = Math.abs(left.deep - right.deep) <= 1 && left.isB && right.isB;
        return node;
    }

    private static class Node {

        int deep;
        boolean isB;

        public Node() {
        }

        public Node(int deep, boolean isB) {
            this.deep = deep;
            this.isB = isB;
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
