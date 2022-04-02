import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();
        boolean[] hasDates = new boolean[nums.length];
        Integer[] currentData = new Integer[nums.length];
        dfs(resultList, hasDates, nums, 0, currentData);
        return resultList;

    }

    void dfs(List<List<Integer>> resultList, boolean[] hasDates, int[] nums,  int deep, Integer[] currentData) {
        int length = nums.length;
        Integer preData = null;
        for (int i = 0; i < length; i++) {
            
            if(hasDates[i]) {
                continue;
            }
            if(preData != null && nums[i] == preData) {
                continue;
            }
            preData = nums[i];
            if(deep == length - 1) {
                currentData[deep] = nums[i];
                resultList.add(Arrays.asList(Arrays.copyOf(currentData, length)));
                continue;
            }
            hasDates[i] = true;
            currentData[deep] = nums[i];
            dfs(resultList, hasDates, nums, deep + 1, currentData);
            hasDates[i] = false;
        }
    }
}
// @lc code=end

