package dsf.algorithm.leetcode.normal;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/8/25 10:14
 */
public class P491 {

    int[] nums;
    int n;


    public List<List<Integer>> findSubsequences(int[] nums) {

        this.nums = nums;
        this.n = nums.length;

        recursion(0);
        return res;
    }

    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> temp = new LinkedList<>();

    public void recursion(int cur) {

        if (cur == n) {
            if(temp.size() > 1) res.add((List<Integer>) temp.clone());
            return;
        }

        // 去重
        if (temp.size()==0 || (nums[cur] != temp.getLast()))
            recursion(cur+1);

        if (temp.size()>0 && nums[cur] < temp.getLast()) {

            return;
        }
        temp.add(nums[cur]);
        recursion(cur+1);
        temp.removeLast();
    }

    public static void main(String[] args) {
        new P491().findSubsequences(new int[]{4, 6, 7, 7});
    }
}
