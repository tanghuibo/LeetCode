/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除有序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 2) {
            return nums.length;
        }

        int result = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1]) {
                if(i == nums.length - 1) {
                    nums[result] = nums[i ];
                    result++;
                }
                continue;
            } 
            nums[result] = nums[i - 1];
            result++;
            if(i == nums.length - 1) {
                nums[result] = nums[i];
                result++;
            }
        }
        return result;
    }
}
// @lc code=end

