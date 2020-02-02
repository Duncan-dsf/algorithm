package dsf.algorithm.leetcode.weekly.c174;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 赛后通过 看错题了 以为要求删除的数字和最小 当成背包了。。
 * @author 董少飞
 * @date 2020/2/2
 */
public class P2 {

    public int minSetSize(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        int n = map.size();
        PriorityQueue<Node> queue = new PriorityQueue<>((n1, n2) -> Integer.compare(n2.n, n1.n));

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(new Node(entry.getKey(), entry.getValue()));
        }

        int ans = 0, len = 0;
        while (queue.size() > 0 && len < arr.length/2) {
            Node node = queue.poll();
            len += node.n;
            ans++;
        }
        return ans;
    }

    static class Node {
        int val, n;

        public Node(int val, int n) {
            this.val = val;
            this.n = n;
        }
    }
}
