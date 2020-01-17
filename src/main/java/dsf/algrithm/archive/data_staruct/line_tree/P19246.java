package dsf.algrithm.archive.data_staruct.line_tree;

/**
 * @author : dongshaofei
 * @version V1.0
 * @Project: algorithm
 * @Package dsf.algrithm.archive.data_staruct.line_tree
 * @Description: TODO
 * @date Date : 2020年01月17日 16:28
 */
public class P19246 {

    static int n;
    static Node[] tree;
    static int[] arr;

    public static void main(String[] args) {

        arr = ;
    }

    public static void add(int i, int l, int r, int val) {

        Node node = tree[i];
        int mid = (node.l + node.r)>>1;
        if (l == node.l && r == node.r) {
            node.add += val;
        } else if (l == node.l) {
            if (node.r > mid) {

                tree[i*2].add += val;
                add(i*2+1, mid+1, r, val);
            } else {
                add(i*2, l, r)
            }
        } else if (r == node.r) {

        }

        if (r < mid)
    }

    public static void intiTree() {

        n = arr.length;
        tree = new Node[2*n];
        for (int i=n; i<2*n; i++) {
            tree[i] = new Node(arr[i-n]);
        }
        for (int i=1; i<n; i++) {
            tree[i] = new Node(arr[i*2] + arr[i*2+1]);
        }
    }

    public static void initTree(int i, int l, int r) {

        Node node = new Node(l, r);
        tree[i] = node;
        if (l == r) {
            node.val = arr[i];
            node.add = arr[i];
            node.multi = arr[i] * arr[i];
            tree[i] = node;
            return;
        }

        int mid = (l+r) >> 1;
        initTree(i*2, l, mid);
        initTree(i*2+1, mid+1, r);

        node.add = tree[i*2].add + tree[i*2+1].add;
        node.multi = tree[i*2].multi + tree[i*2+1].multi;
    }

    static class Node {
        int val, l, r;

        // 线段的平方和 和
        int multi, add;

        // 乘数标记 加法标记
        int mf, af;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, int l, int r) {
            this.val = val;
            this.l = l;
            this.r = r;
        }

        public Node(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
}
