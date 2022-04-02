import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> resultList = new ArrayList<>();
        boolean[] hasDates = new boolean[nums.length];
        Integer[] currentData = new Integer[nums.length];
        dfs(resultList, hasDates, nums, 0, currentData);
        return resultList;


    }

    void dfs(List<List<Integer>> resultList, boolean[] hasDates, int[] nums,  int deep, Integer[] currentData) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if(hasDates[i]) {
                continue;
            }
            if(deep == length - 1) {
                currentData[deep] = nums[i];
                resultList.add(Arrays.asList(Arrays.copyOf(currentData, length)));
                break;
            }
            hasDates[i] = true;
            currentData[deep] = nums[i];
            dfs(resultList, hasDates, nums, deep + 1, currentData);
            hasDates[i] = false;
        }
    }
}
// @lc code=end

