/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int length = nums.length;
        Integer[] item = new Integer[length];
        List<List<Integer>> resultList = new ArrayList<>();
        search(resultList, nums, item, length - 1);
        return resultList;
    }

    private void search(List<List<Integer>> resultList, int[] nums, Integer[] item, int index) {

        if(index == 0) {
            item[0] = null;
            resultList.add(copy(item));
            item[0] = nums[0];
            resultList.add(copy(item));
            return;
        }

        item[index] = null;
        search(resultList, nums, item, index - 1);
        item[index] = nums[index];
        search(resultList, nums, item, index - 1);
    }

    private List<Integer> copy(Integer[] list) {
        List<Integer> result = new ArrayList<>(list.length);

        for(Integer item : list) {
            if(item == null) {
                continue;
            }
            result.add(item);
        }

        return result;
    }
}
// @lc code=end

