package dsf.algorithm.leetcode.offer;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/20 17:23
 */
public class P6 {

    int size = 0;
    int i = 0;
    int[] arr;
    public int[] reversePrint(ListNode head) {

        if (head == null) return new int[]{};
        ListNode t = head;
        while (t != null) {
            size++;
            t = t.next;
        }
        arr = new int[size];
        recursion(head);
        return arr;
    }

    public void recursion(ListNode head) {

        if (head.next == null) arr[i++] = head.val;
        else {
            recursion(head.next);
            arr[i++] = head.val;
        }
    }

    public int[] reversePrint2(ListNode head) {

        if (head == null) return new int[]{};
        int[] arr = new int[10000];
        int i=0;
        for (; head != null; i++) {
            arr[i] = head.val;
            head = head.next;
        }

        int[] res = new int[i];
        for (int j=0; j<i; j++) res[j] = arr[i-j-1];
        return res;
    }


//    int i = 0;
//    int[] arr = new int[10000];
//    public int[] reversePrint1(ListNode head) {
//
//        if (head == null) return new int[]{};
//        recursion(head);
//        int[] res = new int[i];
//        System.arraycopy(arr, 0, res, 0, i);
//        return res;
//    }
//
//    public void recursion(ListNode head) {
//
//        if (head.next == null) arr[i++] = head.val;
//        else {
//            recursion(head.next);
//            arr[i++] = head.val;
//        }
//    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
