package dsf.algorithm.leetcode.weekly.c201;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/9 10:50
 */
public class P1545 {

    public char findKthBit(int n, int k) {

//        StringBuilder sb = new StringBuilder("0");
//        for (int i=1; i<n; i++) {
//            sb.append("1");
//        }
//        return 'a';

        int len = getLen(n);
        return recursion(n, len, k);
    }

    public int getLen(int n) {

        int len = 1;
        for (int i=1; i<n; i++) {
            len = len*2 + 1;
        }
        return len;
    }

    public char recursion(int n, int len, int k) {

        if (len == 1) return '0';
        if (k == len/2+1)
            return '1';
        else if (k < len/2+1) {
            return recursion(n-1, len/2, k);
        } else {
            if (recursion(n-1, len/2, len+1-k) == '0')
                return '1';
            else return '0';
        }
    }

    public static void main(String[] args) {

        new P1545().findKthBit(3, 7);
    }
}
