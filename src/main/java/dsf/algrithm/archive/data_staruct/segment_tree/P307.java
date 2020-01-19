package dsf.algrithm.archive.data_staruct.segment_tree;

/**
 * leetcode https://leetcode-cn.com/problems/range-sum-query-mutable/submissions/ 单点更新 区域求和
 * 已经ac过了 非递归方式
 * 重新做一遍 以递归方式
 * 递归方式的线段树不是完全二叉树，所以需要开4*n的空间
 *
 * @author : dongshaofei
 * @version V1.0
 * @Project: algorithm
 * @Package dsf.algrithm.archive.data_staruct.segment_tree
 * @Description: TODO
 * @date Date : 2020年01月19日 12:21
 */
public class P307 {

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1, 3, 5, 7, 9});
        System.out.println(numArray.sumRange(4, 4));
        numArray.update(1, 2);
        System.out.println(numArray.sumRange(1, 1));
    }
}

class NumArray {

    int[] arr;
    int n;
    int[] tree;
    int[] l, r;

    public NumArray(int[] nums) {

        if (nums.length == 0)
            return;
        arr = nums;
        n = nums.length;
        tree = new int[4 * n];
        l = new int[4 * n];
        r = new int[4 * n];

        build(1, 0, n - 1);
    }

    public void build(int i, int li, int ri) {

        l[i] = li;
        r[i] = ri;
        if (li == ri) {
            tree[i] = arr[li];
            return;
        }

        int mid = (li + ri) >> 1;
        if (li <= mid && ri > mid) {
            build(i * 2, li, mid);
            build(i * 2 + 1, mid + 1, ri);
        } else if (li > mid) {
            build(i * 2 + 1, mid + 1, ri);
        } else
            build(i * 2, li, mid);

        pushUp(i);
    }

    public void pushUp(int i) {

        tree[i] = tree[i * 2] + tree[i * 2 + 1];
    }

    public void update(int i, int val) {

        update(1, i, val);
    }

    /**
     * @param c   当前递归到的点
     * @param i   想要修改的点
     * @param val 修改成的值
     */
    public void update(int c, int i, int val) {

        if (l[c] == r[c]) {
            tree[c] = val;
            return;
        }

        int mid = (l[c] + r[c]) >> 1;
        if (i <= mid) {
            update(c*2, i, val);
        } else
            update(c*2+1, i, val);

        pushUp(c);
    }

    public int sumRange(int i, int j) {

        return sum(1, i, j);
    }

    public int sum(int i, int li, int ri) {

        if (l[i] == li && r[i] == ri) {
            return tree[i];
        }

        int mid = (l[i] + r[i]) >> 1;
        if (li <= mid && ri > mid) {
            return sum(i * 2, li, mid) + sum(i * 2 + 1, mid+1, ri);
        } else if (li > mid)
            return sum(i * 2 + 1, li, ri);
        else
            return sum(i * 2, li, ri);
    }
}
