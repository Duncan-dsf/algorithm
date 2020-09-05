package dsf.algorithm.interview.meituan;

/**
 * TODO
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/9/4 15:12
 */
public class T {

    public String LCS (String str1, String str2) {

        if (str1 == null || str2 == null) return "";
        int n = str1.length(), m = str2.length();
        if (n == 0 || m == 0) return "";
        int res = 0;
        String s = null;
        for (int i=0; i<n; i++) {
            int t = i;
            int c = 0;
            for (int j=0; j<m; j++) {
                if (str1.charAt(t) != str2.charAt(j)) break;
                c++;
                t++;
            }
            if (res < c) {
                res = c;
                s = str1.substring(i, t);
            }
        }
        return s;
    }

    public static void main(String[] args) {

        String lcs = new T().LCS("1AB2345CD", "12345EF");
        System.out.println(lcs);
    }
}
