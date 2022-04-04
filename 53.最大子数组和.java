/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int result = 0;
        int maxResult = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            result = result + num;
            if(result < 0) {
                result = 0;
            } else {
                if(result > maxResult) {
                    maxResult = result;
                }
            }
            if(num > maxResult) {
                maxResult = num;
            }

            
        }

        return maxResult;

    }
}
// @lc code=end

