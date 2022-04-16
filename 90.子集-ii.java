import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();
        dfs(false, nums, 0, resultList, new Integer[nums.length], 0);
        return resultList;
    }

    private List<Integer> copy(Integer[] list) {
        List<Integer> result = new ArrayList<>(list.length);
        for (Integer integer : list) {
            if(integer == null) {
                return result;
            }
            result.add(integer);
        }
        return result;
    }

    private void dfs(boolean chooseBefore, int[] nums, int index, List<List<Integer>> result, Integer[] currentData, int currentIndex) {
        boolean allowChoose = true;
        if(!chooseBefore && index > 0 && nums[index] == nums[index - 1]) {
            allowChoose = false;
        }
        if(index == nums.length - 1) {
            result.add(copy(currentData));
            if(allowChoose) {
                currentData[currentIndex] = nums[index];
                result.add(copy(currentData));         
                currentData[currentIndex] = null;
            }
      
            return;   
        }

        dfs(false, nums, index + 1, result, currentData, currentIndex);

      if(allowChoose) {
        currentData[currentIndex] = nums[index];
        dfs(true, nums, index + 1, result, currentData, currentIndex + 1);
        currentData[currentIndex] = null;
      }
    }
}
// @lc code=end

