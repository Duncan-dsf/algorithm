package dsf.algorithm.archive.data_staruct.segment_tree;

/**
 * 牛客 https://ac.nowcoder.com/acm/problem/14527
 * 线段树 求元素和及其约束个数
 *
 * TODO 不知道怎么初始化线段树！！！
 * @author : dongshaofei
 * @version V1.0
 * @Project: algorithm
 * @Package dsf.algorithm.archive.data_staruct.line_tree
 * @Description:
 * @date Date : 2020年01月17日 14:13
 */
public class P14527 {

    static Node[] tree;
    static int n;
    static int[] arr;

    public static void main(String[] args) {

//        int i = 1e9 + 1
    }

//    public static int[] get(int i)

    public static void intiTree(int i, int l, int r) {

        Node node = new Node();
        tree[i] = node;
        if (l == r) {
            initNode(arr[l], node);
            return;
        }

        int mid = (l+r) >> 1;
        intiTree(i*2, l, mid);
        intiTree(i*2+1, mid+1, r);

        pushUp(i);
    }

    public static void pushUp(int i) {

        Node parent = tree[i], l = tree[i*2], r = tree[i*2+1];
        updateNode(parent, l, r);
    }

    public static void updateNode(Node parent, Node l, Node r) {

        parent.sum = l.sum * r.sum;
        parent.n2 = l.n2 + r.n2;
        parent.n3 = l.n3 + r.n3;
        parent.n5 = l.n5 + r.n5;
        parent.n7 = l.n7 + r.n7;
        parent.n11 = l.n11 + r.n11;
        parent.n13 = l.n13 + r.n13;
    }

    public static void initNode(int val, Node node) {
        node.sum = val;
        node.n2 = getSubNum(val, 2);
        node.n3 = getSubNum(val, 3);
        node.n5 = getSubNum(val, 5);
        node.n7 = getSubNum(val, 7);
        node.n11 = getSubNum(val, 11);
        node.n13 = getSubNum(val, 13);
    }

    public static int getSubNum(int val, int sub) {
        int n = 0;
        while (val % sub == 0) {
            val /= sub;
            n++;
        }
        return n;
    }

    public static int getSub(int n) {

//        int[] arr = new int[n]
//        while (n > 1)
        return 0;
    }

    static class Node {
        int n2, n3, n5, n7, n11, n13;
        int sum;

        public Node() {
        }

        public Node(int sum) {
            this.sum = sum;
        }
    }
}
