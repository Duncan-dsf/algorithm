package dsf.algorithm.archive.data_staruct.segment_tree;

import java.util.Scanner;

/**
 * @author : dongshaofei
 * @version V1.0
 * @Project: algorithm
 * @Package dsf.algorithm.archive.data_staruct.line_tree
 * @Description: TODO
 * @date Date : 2020年01月17日 16:28
 *
 * 牛客 https://ac.nowcoder.com/acm/problem/19246
 * TODO 通过0% 全部返回非0
 */
public class P19246 {

    static int n;
    static Node[] tree;
    static int[] arr;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            n = scanner.nextInt();
            int m = scanner.nextInt();
            tree = new Node[4*n];
            arr = new int[n];
            for (int i=0; i<n; i++) {
                arr[i] = scanner.nextInt();
            }

            initTree(1, 1, n);

            for (int i=0; i<m; i++) {
                int op = scanner.nextInt();
                switch (op) {
                    case 1: {
                        int l = scanner.nextInt(), r = scanner.nextInt();
                        System.out.println(getAdd(1, l, r));
                        break;
                    }
                    case 2: {
                        int l = scanner.nextInt(), r = scanner.nextInt();
                        System.out.println(getMulti(1, l, r));
                        break;
                    }
                    case 3: {
                        int l = scanner.nextInt(), r = scanner.nextInt(), x = scanner.nextInt();
                        multi(1, l, r, x);
                        break;
                    }
                    case 4: {
                        int l = scanner.nextInt(), r = scanner.nextInt(), x = scanner.nextInt();
                        add(1, l, r, x);
                        break;
                    }
                }
            }
        }
    }

    public static void add(int i, int l, int r, int val) {

        Node node = tree[i];

        if (node.l == l && node.r == r) {

            int len = node.r - node.l + 1;
            node.af += val;
            node.multi += 2*val*node.add + val*val * len;
            node.add += len * val;
            return;
        }

        pushDown(i);
        int mid = (node.l + node.r)>>1;
        if (l <= mid && r > mid) {
            add(i*2, l, mid, val);
            add(i*2+1, mid+1, r, val);
        } else if (l > mid) {
            add(i*2+1, mid, r, val);
        } else {
            add(i*2, l, mid, val);
        }

    }

    public static void multi(int i, int l, int r, int val) {

        Node node = tree[i];

        if (node.l == l && node.r == r) {

            node.mf *= val;
            node.multi *= val*val;
            node.add *= val;
            return;
        }

        pushDown(i);
        int mid = (node.l + node.r)>>1;
        if (l <= mid && r > mid) {
            multi(i*2, l, mid, val);
            multi(i*2+1, mid+1, r, val);
        } else if (l > mid) {
            multi(i*2+1, mid, r, val);
        } else {
            multi(i*2, l, mid, val);
        }
    }

    public static void pushDown(int i) {
        if (i>=n)
            return;

        Node parent = tree[i], l = tree[i*2], r = tree[i*2+1];

        if (parent.af == 0 && parent.mf == 1)
            return;

        l.af += parent.af;
        l.mf *= parent.mf;
        r.af += parent.af;
        r.mf *= parent.mf;


        int lLen = l.r-l.l + 1, rLen = r.r-r.l+1;
        l.multi = parent.mf*parent.mf * l.multi + 2*parent.af*parent.mf*l.add + lLen*parent.af*parent.af;
        r.multi = parent.mf*parent.mf * r.multi + 2*parent.af*parent.mf*r.add + rLen*parent.af*parent.af;
        l.add = (l.add + lLen*parent.af) * parent.mf;
        r.add = (r.add + rLen*parent.af) * parent.mf;

        parent.af = 0;
        parent.mf = 1;
    }

    public static int getAdd(int i, int l, int r) {

        if (i > 2*n-1)
            return 0;
        Node node = tree[i];

        if (node.l == l && node.r == r) {

            return node.add;
        }

        pushDown(i);
        int mid = (node.l + node.r)>>1;
        if (l <= mid && r > mid) {

            return getAdd(i*2, l, mid) + getAdd(i*2+1, mid+1, r);
        } else if (l > mid) {
            return getAdd(i*2+1, mid+1, r);
        } else {
            return getAdd(i*2, l, mid);
        }
    }

    public static int getMulti(int i, int l, int r) {
        Node node = tree[i];

        if (node.l == l && node.r == r) {

            return node.multi;
        }

        pushDown(i);
        int mid = (node.l + node.r)>>1;
        if (l <= mid && r > mid) {
            return getMulti(i*2, l, mid) + getMulti(i*2+1, mid+1, r);
        } else if (l > mid) {
            return getMulti(i*2+1, l, r);
        } else {
            return getMulti(i*2, l, r);
        }
    }

    public static void intiTree() {

        n = arr.length;
        tree = new Node[2*n];
        for (int i=n; i<2*n; i++) {
            tree[i] = new Node(arr[i-n]);
        }
        for (int i=1; i<n; i++) {
            tree[i] = new Node(arr[i*2-n] + arr[i*2+1-n]);
        }
    }

    /**
     * 递归版建树
     * @param i
     * @param l
     * @param r
     */
    public static void initTree(int i, int l, int r) {

        Node node = new Node(l, r);
        tree[i] = node;
        if (l == r) {
            node.val = arr[l-1];
            node.add = arr[l-1];
            node.multi = arr[l-1] * arr[l-1];
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
        int mf = 1, af;

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
