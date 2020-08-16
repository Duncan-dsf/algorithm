package dsf.algorithm.test;

import java.util.HashMap;

/**
 * TODO
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/6 11:15
 */
public class Test {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        map.put("hhhh", 1);

        Integer integer = map.get("hhhhh".substring(0, 4));
        System.out.println(integer);

        System.out.println('A' - 'a');
    }
}
