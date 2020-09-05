package dsf.algorithm.leetcode.weekly.c174;

import java.util.HashMap;
import java.util.Map;

/**
 * 通过
 * @author 董少飞
 * @date 2020/2/2
 */
public class P3 {

    int sum, sub, abs;
    Map<TreeNode, Integer> map = new HashMap<>();

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxProduct(TreeNode root) {

        sum = travel(root);
        abs = sum;

        getSub(root);
        int mod = (int)(1e9+7);
        int ans = (int)(((long) sub * (sum - sub))%mod);
        return ans;
    }

    public int travel(TreeNode root) {

        if (root == null) return 0;

        int sum = root.val;
        sum += travel(root.left);
        sum += travel(root.right);
        map.put(root, sum);
        return sum;
    }

    public void getSub(TreeNode root) {

        if (root == null) return;

        int s = map.get(root), a;

        if ((a = Math.abs(sum - 2*s)) < abs) {
            abs = a;
            sub = s;
        }
        getSub(root.left);
        getSub(root.right);
    }
}
