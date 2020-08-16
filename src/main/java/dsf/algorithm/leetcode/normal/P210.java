package dsf.algorithm.leetcode.normal;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * TODO
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/5/18 10:25
 */
public class P210 {

    private int capcity;

    public int[] findOrder(int n, int[][] prerequisites) {

        TreeNode[] roots = new TreeNode[n];
        capcity = n;
        int[] flags = new int[n];
        for (int i=0; i<n; i++) {
            roots[i] = new TreeNode(i);
        }

        for (int[] edge : prerequisites) {
            int child = edge[1], parent = edge[0];
            flags[child] = 1;
            roots[parent].children.add(roots[child]);
        }

        ArrayList<Integer> res = new ArrayList<>(n);

        for (int i=0; i<n; i++) {
            if (flags[i] == 1) continue;

            try {

                dfs(roots[i], res);
            } catch (Exception e) {
                return new int[0];
            }
        }

        if (res.size() != n) return new int[0];
        int[] arr = new int[n];
        for (int i=0; i<n; i++) arr[i] = res.get(i);
        return arr;
    }

    public void dfs(TreeNode root, ArrayList<Integer> res) throws Exception {

        if (root == null) return;
        if (res.size() == capcity) throw new Exception("无解");

        for (TreeNode child : root.children) {
            dfs(child, res);
        }
        res.add(root.val);
    }

    private static class TreeNode {
        LinkedList<TreeNode> children = new LinkedList<>();
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
