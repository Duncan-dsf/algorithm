package dsf.algrithm.archive.tree;

import java.util.Arrays;

/**
 * @author : dongshaofei
 * @version V1.0
 * @Project: algorithm
 * @Package dsf.algrithm.archive.tree
 * @Description: TODO
 * @date Date : 2020年01月13日 14:27
 *
 * 恢复树 {leetcode 105 mid} {poj 2255}
 */
public class Traversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

        TreeNode treeNode = buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(treeNode);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return recoveryByPreAndIn(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }


    public static TreeNode recoveryByPreAndIn(int[] pre, int pl, int pr, int[] in, int il, int ir) {

        if (pl > pr) return null;
        if (pl == pr) {
            return new TreeNode(pre[pl]);
        }
        TreeNode root = new TreeNode(pre[pl]);
        int rootIIndex = -1;
        for (int i=il; i<=ir; i++) {
            if (in[i] == root.val) {
                rootIIndex = i;
            }
        }
        int leftLength = rootIIndex-il;
        int rightLength = pr - pl - leftLength;
        root.left = recoveryByPreAndIn(pre, pl+1, pl+leftLength, in, il, rootIIndex-1);
        root.right = recoveryByPreAndIn(pre, pl+1+leftLength, pr, in, rootIIndex+1, ir);

        return root;
    }
}
