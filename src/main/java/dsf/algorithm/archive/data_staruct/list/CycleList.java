package dsf.algorithm.archive.data_staruct.list;

import java.util.Stack;

/**
 * TODO
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/5/12 9:34
 */
public class CycleList {

    public ListNode detectCycle(ListNode head) {
        ListNode l1 = head, l2 = head;
        for (; l2 != null; ) {
            l1 = l1.next;
            l2 = l2.next != null ? l2.next.next : null;

            if (l1 == l2) break;
        }

        if (l2 == null) return null;

        l1 = head;
        while (l1 != l2) {
            l1 = l1.next;
            l2 = l2.next;
        }
        return l2;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1, null), l2 = new ListNode(2, null), l3 = new ListNode(3, null);
        l1.next = l2;
        l2.next = l3;
        l3.next = l2;

        ListNode listNode = new CycleList().detectCycle(l1);
        System.out.println(listNode.val);
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}


