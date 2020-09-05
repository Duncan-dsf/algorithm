package dsf.algorithm.leetcode.normal;

import java.util.ArrayList;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/18 9:26
 */
public class P109 {

    public TreeNode sortedListToBST(ListNode head) {

        return null;
    }

//    ArrayList<ListNode> array;
//    public TreeNode sortedListToBST(ListNode head) {
//
//        array = new ArrayList<>();
//        for (ListNode h = head; h != null;) {
//            array.add(h);
//            h = h.next;
//        }
//
//        return build(0, array.size()-1);
//    }
//
//    public TreeNode build(int l, int r) {
//
//        if (l > r || l < 0 || r >= array.size()) return null;
//        if (l == r) return new TreeNode(array.get(l).val);
//
//        int mid = (l + r) / 2;
//        TreeNode treeNode = new TreeNode(array.get(mid).val);
//        treeNode.left = build(l, mid-1);
//        treeNode.right = build(mid+1, r);
//
//        return treeNode;
//    }

    public static void main(String[] args) {

        ListNode listNode5 = new ListNode(9);
        ListNode listNode4 = new ListNode(5, listNode5);
        ListNode listNode3 = new ListNode(0, listNode4);
        ListNode listNode2 = new ListNode(-3, listNode3);
        ListNode listNode1 = new ListNode(-10, listNode2);

        TreeNode treeNode = new P109().sortedListToBST(listNode1);
    }

    //    Definition for a binary tree node.
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {

            this.val = val;

            this.left = left;

            this.right = right;

        }
    }

    // Definition for singly-linked list.
    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}


