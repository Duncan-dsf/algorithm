package dsf.algorithm.leetcode.normal;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/24 11:31
 */
public class P459 {

    public boolean repeatedSubstringPattern(String s) {

        if (s == null || s.length() < 2) return false;
        int[] arr = new int[26];
        char[] chs = s.toCharArray();
        for (int i=0; i<s.length(); i++) {
            arr[chs[i]-'a']++;
        }

        int minRpC = Integer.MAX_VALUE;
        for (int i=0; i<26; i++) {
            if (arr[i] == 1) return false;
            if (arr[i] == 0) continue;
            minRpC = Math.min(minRpC, arr[i]);
        }


        for (int rpC=2; rpC<=minRpC; rpC++) {
            if (chs.length % rpC != 0) continue;
            int subLen = chs.length/rpC;
            boolean flag = true;
            for (int i=0; i<subLen; i++) {
                char c = chs[i];
                for (int j=i+subLen; j<chs.length; j+=subLen) {
                    if (chs[j] != c) {
                        flag = false;
                        break;
                    }
                }
                if (!flag) break;
            }
            if (flag) return true;
        }
        return false;
    }
}
