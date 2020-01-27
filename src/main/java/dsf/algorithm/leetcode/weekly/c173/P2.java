package dsf.algorithm.leetcode.weekly.c173;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 不涉及算法、数据结构
 * @author 董少飞
 * @date 2020/1/26
 */
public class P2 {

    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        PriorityQueue<Node> queue = new PriorityQueue<>((n1, n2) -> {
            if (n1.rating > n2.rating)
                return -1;
            if (n1.rating < n2.rating)
                return 1;
            return Integer.compare(n2.id, n1.id);
        });

        for (int[] restaurant : restaurants) {
            if ((veganFriendly == 0 || restaurant[2] == veganFriendly) && restaurant[3] <= maxPrice && restaurant[4] <= maxDistance)
                queue.add(new Node(restaurant[1], restaurant[0]));
        }

        List<Integer> ans = new ArrayList<>(queue.size());
        while (queue.size() > 0) {
            ans.add(queue.poll().id);
        }

        return ans;
    }

    static class Node {
        int rating, id;

        public Node(int rating, int id) {
            this.rating = rating;
            this.id = id;
        }
    }
}
