package dsf.algorithm.leetcode.normal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * TODO
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/12 11:18
 */
public class P133 {

    public static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int val) {
            this.val = val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int val, ArrayList<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }

//    HashMap<Integer, LinkedList<Node>> map = new HashMap<>();
    HashMap<Integer, Node> newNodes = new HashMap<>();
    int[][] flag = new int[100][100];
    int[] visited = new int[100];

    public Node cloneGraph(Node node) {

        if (node == null) return null;
        dfs(node);
        return newNodes.get(1);
    }

    public void dfs(Node node) {

        if (visited[node.val] == 1) return;
        visited[node.val] = 1;
        Node newNode = putAndGetDefault(node.val);
        for (Node neighbor : node.neighbors) {
            if (flag[newNode.val][neighbor.val] == 1) continue;
            newNode.neighbors.add(putAndGetDefault(neighbor.val));
        }

        for (Node neighbor : node.neighbors) {
            dfs(neighbor);
        }
    }

    public Node putAndGetDefault(int val) {
        newNodes.putIfAbsent(val, new Node(val));
        return newNodes.get(val);
    }
}
