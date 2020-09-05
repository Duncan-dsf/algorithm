package dsf.algorithm.leetcode.normal;

import java.util.Arrays;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/13 0:57
 */
public class P43 {

    public String multiply(String num1, String num2) {

        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0)
            return "";
        if ("0".equals(num1) || "0".equals(num2))
            return "0";
        int n = num1.length(), m = num2.length();

        int[] res = new int[n+m];
        int pos = 0;
        int c = 0;
        for (int i = m - 1; i >= 0; i--) {
            pos = res.length - m + i;
            int a = num2.charAt(i) - '0';

            for (int j = n - 1; j >= 0; j--) {

                int b = num1.charAt(j) - '0';
                int sum = a * b + c + res[pos];
                c = sum / 10;
                res[pos--] = sum%10;
            }

            if (c != 0) {
                res[pos--] = c;
                c = 0;
            }
        }

        StringBuilder sb = new StringBuilder(res.length - pos - 1);
        for (int i=pos+1; i<res.length; i++) {
            sb.append(res[i]);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String res = new P43().multiply("999", "999");

        System.out.println(res);
        System.out.println(new StringBuilder().append(1).append(2).toString());
    }
}
