package dsf.algorithm.leetcode.normal;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/5/16 17:26
 */
public class P25 {

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode cur = head, start = cur, startLast = null;
        for (int i=0; cur != null; i++) {
            if (i == k-1) {
                reverse(start, cur, k);
                if (startLast != null) startLast.next = cur;

                if (start == head) head = cur;

                startLast = start;
                start = start.next;
                i = -1;
                cur = start;
            } else
                cur = cur.next;
        }
        return head;
    }

    public void reverse(ListNode start, ListNode end, int n) {

        while(start != end) {
            ListNode next = start.next;
            start.next = end.next;
            end.next = start;

            start = next;
        }
    }

    public static void main(String[] args) {

        ListNode listNode = new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null)))));
        ListNode listNode1 = new P25().reverseKGroup(listNode, 2);
        System.out.println(listNode1);
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
