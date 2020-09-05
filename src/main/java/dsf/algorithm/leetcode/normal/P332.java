package dsf.algorithm.leetcode.normal;

import java.util.*;

/**
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/27 10:29
 */
public class P332 {

    // 暴力 时间：7% 空间6%
    HashMap<String, TreeNode> map = new HashMap<>();
    ArrayList<String> res;
    ArrayList<String> temp;
    int n;
    public List<String> findItinerary(List<List<String>> tickets) {

        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            TreeNode node = getAndInit(from);
            node.out.add(getAndInit(to));
            node.map.put(to, node.map.getOrDefault(to, 0)+1);
        }
        for (TreeNode node : map.values()) {
            node.out.sort(Comparator.comparing(a -> a.val));
        }
        n = tickets.size()+1;
        temp = new ArrayList<>(n);
        TreeNode root = map.get("JFK");

        dfs(root, 0);
        return res;
    }

    public void dfs(TreeNode root, int cur) {

        if (res != null) return;

        temp.add(root.val);

        if (cur == n-1) {
            res = new ArrayList<>(temp);
            return;
        }

        HashSet<String> set = new HashSet<>();
        for (TreeNode treeNode : root.out) {
            if (set.contains(treeNode.val)) continue;
            set.add(treeNode.val);
            if (root.map.get(treeNode.val) == 0)
                continue;
            root.map.put(treeNode.val, root.map.get(treeNode.val)-1);
            dfs(treeNode, cur+1);
            root.map.put(treeNode.val, root.map.get(treeNode.val)+1);
        }

        temp.remove(cur);
    }

    public TreeNode getAndInit(String s) {

        if (!map.containsKey(s))
            map.put(s, new TreeNode(s));
        return map.get(s);
    }

    private static class TreeNode {

        String val;
        LinkedList<TreeNode> out = new LinkedList<>();
        //        HashSet<String> visited = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();

        public TreeNode(String val) {
            this.val = val;
        }
    }

    // 优化算法
//    HashMap<String, TreeNode> map = new HashMap<>();
//    LinkedList<String> res;
//    int n;
//    public List<String> findItinerary(List<List<String>> tickets) {
//
//        for (List<String> ticket : tickets) {
//            String from = ticket.get(0);
//            String to = ticket.get(1);
//            TreeNode node = getAndInit(from);
//            node.out.add(getAndInit(to));
//        }
//        n = tickets.size()+1;
//        res = new LinkedList<>();
//        TreeNode root = map.get("JFK");
//
//        dfs(root);
//        return res;
//    }
//
//    public void dfs(TreeNode root) {
//
//        while (root.out.size() > 0) {
//            TreeNode node = root.out.poll();
//            dfs(node);
//        }
//        res.addFirst(root.val);
//    }
//
//    public TreeNode getAndInit(String s) {
//
//        if (!map.containsKey(s))
//            map.put(s, new TreeNode(s));
//        return map.get(s);
//    }
//
//    private static class TreeNode {
//
//        String val;
//        PriorityQueue<TreeNode> out = new PriorityQueue<>(Comparator.comparing(a -> a.val));
//        public TreeNode(String val) {
//            this.val = val;
//        }
//    }
}
