/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int maxStep = nums[0];

        for (int i = 0; i < nums.length && maxStep < nums.length - 1; i++) {
            if(i > maxStep) {
                return false;
            }
            int nextStep = i + nums[i];
            if(nextStep > maxStep) {
                maxStep = nextStep;
            }

        }

        return true;

    }
}
// @lc code=end

