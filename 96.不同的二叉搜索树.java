/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start
class Solution {
    public int numTrees(int n) {
        int[] nums = new int[n];
        return numTrees(n, nums);
    }

    int numTrees(int length, int[] nums) {
        if(length <= 1) {
            return 1;
        }
        if(nums[length - 1] != 0) {
            return nums[length - 1];
        }
        int result = 0;
        for (int i = 0; i < length; i++) {
            int left = numTrees(i, nums);
            int right = numTrees(length - i - 1, nums);
            result = result + left * right;
        }
        nums[length - 1] = result;
        return result;
    }
}
// @lc code=end

