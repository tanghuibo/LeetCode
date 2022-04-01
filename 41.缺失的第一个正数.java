/*
 * @lc app=leetcode.cn id=41 lang=java
 *
 * [41] 缺失的第一个正数
 */

// @lc code=start
class Solution {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;

        for (int i = 0; i < nums.length; i++) {
            int data = nums[i];
            if(data <= 0) {
                nums[i] = length + 1;
            }
        }

        for (int num : nums) {
            num = Math.abs(num);
            if(num <= length &&  nums[num - 1] > 0) {
                nums[num - 1]   = -nums[num - 1];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                return i + 1;
            }
        }
        return length + 1;
    }
}
// @lc code=end

