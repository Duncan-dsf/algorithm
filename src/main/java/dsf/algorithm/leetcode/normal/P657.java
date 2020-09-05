package dsf.algorithm.leetcode.normal;

/**
 * TODO
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/28 8:59
 */
public class P657 {

    public boolean judgeCircle(String moves) {

        int up = 0, down = 0, left = 0, right = 0;
        char[] arr = moves.toCharArray();
        for (char c : arr) {
            if (c == 'U') up++;
            else if (c == 'D') down++;
            else if (c == 'L') left++;
            else right++;
        }
        return up==down && left==right;
    }
}
