package dsf.algorithm.leetcode.offer;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/20 17:11
 */
public class P5 {

    public String replaceSpace(String s) {

        int n = s.length();
        char[] arr = new char[3*n];
        int size = 0;
        for (int i=0; i<n; i++) {
            if (s.charAt(i) == ' ') {
                arr[size++] = '%';
                arr[size++] = '2';
                arr[size++] = '0';
            } else {
                arr[size++] = s.charAt(i);
            }
        }
        return new String(arr, 0, size);
    }

    public String replaceSpace1(String s) {

        if (s == null || s.length() == 0) return s;

        StringBuilder sb = new StringBuilder(s);
        for (int i=0; i<sb.length(); i++) {
            if (sb.charAt(i) == ' ') {
                sb.deleteCharAt(i);
                sb.insert(i, "%20");
                i += 2;
            }
        }
        return sb.toString();
    }
}
