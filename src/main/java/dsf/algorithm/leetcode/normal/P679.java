package dsf.algorithm.leetcode.normal;

import java.util.*;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/22 7:25
 */
public class P679 {

    public boolean judgePoint24(int[] nums) {

        List<Double> list = new ArrayList<>(4);
        for (int num : nums) {
            list.add((double)(num));
        }
        return resolve(list);
    }

    public boolean resolve(List<Double> list) {

        int n = list.size();
        if (n == 1) return Math.abs(list.get(0)-24) <= 0.0001;
        for (int i = 0; i< n; i++) {
            for (int j=0; j<n; j++) {
                double a = list.get(i), b = list.get(j);

                List<Double> newList = new ArrayList<>(n -1);
                for (int k=0; k<n; k++) {
                    if (k != i && k!=j) newList.add(list.get(k));
                }
                for (int k=0; k<4; k++) {

                    if (i == j || (i > j && (k == 0 || k == 2))) continue;
                    double c;
                    if (k == 0) c = a+b;
                    else if (k == 1) c = a-b;
                    else if (k == 2) c = a*b;
                    else c = a/b;

                    newList.add(c);
                    if (resolve(newList)) return true;
                    newList.remove(n-2);
                }
            }
        }
        return false;
    }


    /**
     * double 与 int 的hashCode一样吗
     * @param args
     */
    public static void main(String[] args) {

        Integer I = new Integer(1);
        Double D = new Double(1);
        int i = 1;
        double d = 1f;
        System.out.println(I.hashCode() == D.hashCode()); //false
        System.out.println(I.equals(D));//false
        System.out.println(i == d);
    }
}
