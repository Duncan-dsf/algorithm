package dsf.algorithm.interview.meituan.c20200822;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/22 18:07
 */
public class Test {

    public static void main(String[] args) {

        String i1 = String.valueOf(1000);
        String i2 = String.valueOf(100);
        System.out.println(i1.compareTo(i2));
        System.out.println(compare(1000, 100));
    }

    public static int compare(int a, int b) {

        String s1 = String.valueOf(a), s2 = String.valueOf(b);
        int i1 = 0, i2 = 0;
        for (; i1<s1.length() && i2<s2.length(); i1++, i2++) {

            if (s1.charAt(i1) < s2.charAt(i2)) return -1;
            else if (s1.charAt(i2) > s2.charAt(i2)) return 1;
        }
        return Integer.compare(s1.length(), s2.length());
    }
}
