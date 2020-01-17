package dsf.algrithm.archive.data_staruct.line_tree;

/**
 * @author : dongshaofei
 * @version V1.0
 * @Project: algorithm
 * @Package dsf.algrithm.archive.data_staruct.line_tree
 * @Description: TODO
 * @date Date : 2020年01月17日 14:13
 */
public class P14527 {

    static int[] tree;
    static int n;

    public static void main(String[] args) {


    }

    public static void intiTree(int[] arr) {

        n = arr.length;
        tree = new int[2*n];
        System.arraycopy(arr, 0, tree, n, n);
        for (int i=1; i<n; i++) {
            tree[i] = tree[i*2] + tree[i*2+1];
        }
    }

    public static int getSub(int n) {

        int[] arr = new int[n]
        while (n > 1)
    }
}
