package dsf.algorithm.leetcode.normal;

import java.util.HashMap;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/5/22 9:08
 */
public class P105 {

    int[] pre, in;
    HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        pre = preorder;
        in = inorder;
        map = new HashMap<>((int)(pre.length/3.0*4) + 1);
        for (int i=0; i<pre.length; i++) map.put(in[i], i);

        return build(0, pre.length, 0, in.length);
    }

    public TreeNode build(int pl, int pr, int il, int ir) {

        if (pl == pr || il == ir) return null;
        TreeNode treeNode = new TreeNode(pre[pl]);
        if (pl == pr-1 || il == ir-1) return treeNode;
        int iindex = map.get(pre[pl]), llen = iindex-il;
        treeNode.left = build(pl+1, pl+1+llen, il, iindex);
        treeNode.right = build(pl+1+llen, pr, iindex+1, ir);
        return treeNode;
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
