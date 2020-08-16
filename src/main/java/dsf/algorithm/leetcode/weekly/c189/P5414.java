package dsf.algorithm.leetcode.weekly.c189;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO
 *
 * @author 董少飞
 * @version 1.0
 * @since 1.0, 2020/5/17 11:04
 */
public class P5414 {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {

        int n = favoriteCompanies.size();
        ArrayList<HashSet<String>> setList = new ArrayList<>(n);
        for (List<String> companyList : favoriteCompanies) {
            HashSet<String> set = new HashSet<>();
            setList.add(set);
            set.addAll(companyList);
        }

        List<Integer> res = new LinkedList<>();
        for (int i=0; i<n; i++) {
            HashSet<String> set = setList.get(i);
            boolean flag = true;
            for (int j=0; j<n; j++) {
                if (j == i) continue;
                if (setList.get(j).containsAll(set)) {
                    flag = false;
                    break;
                }
            }
            if (flag) res.add(i);
        }
        return res;
    }
}
