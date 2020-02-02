package dsf.algorithm.leetcode;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 董少飞
 * @date 2020/1/26
 */
public class Application {

    public static void main(String[] args) {
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>(2);
        map.put(1, 1);
        map.put(2, 1);
        map.put(3,1);

        map.put(4,1);
    }
}
