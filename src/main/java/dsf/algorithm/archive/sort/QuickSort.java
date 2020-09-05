package dsf.algorithm.archive.sort;

import java.util.Arrays;

/**
 * @author : dongshaofei
 * @version V1.0
 * @Project: algorithm
 * @Package dsf.algorithm.archive.sort
 * @Description:
 * @date Date : 2020年01月12日 14:32
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] arr = new int[]{6, 8, 9, 3, 5, 6, 7, 2, 6, 4};
        int[] arr2 = new int[arr.length];
        System.arraycopy(arr, 0, arr2, 0, arr.length);
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort (int[] arr, int left, int right) {

        if (left >= right) return;
        int base = arr[left];
        int l = left+1, r = right;

        for (; l<r; ) {
            while (arr[l] <= base && l < r) {
                l++;
            }
            while (arr[r] > base && l < r) {
                r--;
            }

            if (l < r) {
                swap(arr, l, r);
            }
        }
        swap(arr, left, l-1);

        quickSort(arr, left, l-2);
        quickSort(arr, l, right);
    }

    /**
     * 双轴快排参见 {@link Arrays#sort}
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int[] dualPivotQuickSort (int[] arr, int left, int right) {


        return null;
    }

    public static void swap (int[] arr, int l, int r) {

        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
