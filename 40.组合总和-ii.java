import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> resutList = new ArrayList<>();
        scan(candidates, new LinkedList<Integer>(), target, resutList, 0);
        return resutList;
    }

    private void scan(int[] candidates, LinkedList<Integer> dataList, int target, List<List<Integer>> resultList, int startIndex) {

        for (int i  = startIndex; i  < candidates.length; i++) {
            int item = candidates[i];
            if(i > startIndex) {
                if(candidates[i - 1] == item) {
                    continue;
                }
            }
            if(item > target) {
                break;
            }
            dataList.push(item);
            if(item < target) {
                scan(candidates, dataList, target - item, resultList, i + 1);
            } else  if(item == target) {
                resultList.add(copyArray(dataList));
            }
            dataList.pop();
        }
    }

    private List<Integer> copyArray(List<Integer> origin) {
        List<Integer> target = new ArrayList<>(origin.size());

        for (Integer item : origin) {
            target.add(item);
        }
        return target;
    }
}
// @lc code=end

