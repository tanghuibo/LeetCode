/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int time = 1;
        int maxStep = nums[0];
        if(nums.length == 1) {
            return 0;
        }
        if(maxStep >= nums.length - 1) {
            return 1;
        }
        int nextMaxStep = maxStep;

        for (int i = 1; i < nums.length; i++) {
            int next = i + nums[i];
            if(next > nextMaxStep) {
                nextMaxStep = next;
            }

            if(nextMaxStep >= nums.length - 1) {
                return time + 1;
            } 
            
            if(i >= maxStep) {
                time++;
                maxStep = nextMaxStep;
            }
            
            
        }
        return time + 1;

    }
}
// @lc code=end

