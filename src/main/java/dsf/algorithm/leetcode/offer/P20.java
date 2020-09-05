package dsf.algorithm.leetcode.offer;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/22 11:34
 */
public class P20 {

    public boolean isNumber(String s) {

        if (s == null || (s = s.trim()).length() == 0) return false;
        int ei = -1;
        int n = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i< n; i++) {

            char ch = chars[i];
            if (!check(ch)) return false;
            if (ch == 'E' || ch == 'e') {
                if (i == 0 || ei != -1) return false;
                ei = i;
            }
        }

        if (ei == -1) {
            return checkFloat(chars, 0, n);
        }
        return checkFloat(chars, 0, ei) && checkInt(chars, ei+1, n);
    }

    public boolean checkFloat(char[] chars, int l, int r) {

        if (l >= r) return false;
        if (chars[l] == '-' || chars[l] == '+')
            l++;
        boolean flagP = true, flag = false;
        for (int i=l; i<r; i++)
            if (chars[i] == '.' && flagP) {
                flagP = false;
            } else if (chars[i] >= '0' && chars[i] <= '9') flag = true;
            else return false;

        return flag;
    }

    public boolean checkInt(char[] chars, int l, int r) {

        if (l >= r) return false;
        if (chars[l] == '-' || chars[l] == '+')
            l++;
        boolean flag = false;
        for (int i=l; i<r; i++) {
            if (chars[i] < '0' || chars[i] > '9')
                return false;
            else flag = true;
        }
        return flag;
    }

    public boolean check(char ch) {

        return (ch<='9' && ch>='0') || (ch == '-' || ch == '+') || (ch == 'E' || ch == 'e') || ch=='.';
    }
}
