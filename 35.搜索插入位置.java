/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        if(r < 0 || target < nums[l]) {
            return 0;
        }

        if(target > nums[r]) {
            return r + 1;
        }


        while(true) {
            int m = (l + r) / 2;
            if(nums[m] == target) {
                return m;
            }
            if(l >= r - 1) {
                return r;
            }
            if(nums[m] > target) {
                r = m;
            } else {
                l = m;
            }
        }

    }
}
// @lc code=end

