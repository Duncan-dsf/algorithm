package dsf.algorithm.leetcode.weekly.c189;

import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/5/17 10:50
 */
public class P5413 {

    public String arrangeWords(String text) {

        HashMap<Integer, LinkedList<String>> map = new HashMap<>();
        int max = 0;
        text = text.toLowerCase();
        for (String s : text.split(" ")) {
            int length = s.length();
            max = Math.max(max, length);
            map.putIfAbsent(length, new LinkedList<>());
            LinkedList<String> list = map.get(length);
            list.add(s);
        }

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=max; i++) {
            if (!map.containsKey(i)) continue;

            for (String s : map.get(i)) {
                sb.append(' ');
                sb.append(s);
            }
        }
        sb.setCharAt(1, Character.toUpperCase(sb.charAt(1)));
        return sb.substring(1);
    }
}
