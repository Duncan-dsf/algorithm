package dsf.algorithm.leetcode.normal;

import java.util.HashSet;
import java.util.List;

/**
 * TODO 有向图连通性不能用并查集！！！ 除非所有节点的father只能是唯一的 比如树
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/31 14:10
 */
public class P841 {

    List<List<Integer>> rooms;
    HashSet<Integer> set;
    int n;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        if (rooms.size() == 1) return true;
        this.rooms = rooms;
        n = rooms.size();
        set = new HashSet<>((int)(n/3.0*4+1));
        dfs(0);
        return set.size() == n;
    }

    public void dfs(int i) {

        if (set.contains(i)) return;
        set.add(i);
        for (Integer room : rooms.get(i)) {
            dfs(room);
        }
    }
}
