package dsf.algorithm.leetcode.offer;

import java.util.HashSet;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/22 16:02
 */
public class P48 {

    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        HashSet<Character> set = new HashSet<>((int)(26/3.0*4+1));
        for (int l=0, r=0; r<s.length(); r++) {
//            if (set.contains(s.charAt(r)))
        }
        return 0;
    }
}
