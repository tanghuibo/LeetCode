/*
 * @lc app=leetcode.cn id=80 lang=java
 *
 * [80] 删除有序数组中的重复项 II
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int lIndex = 0;
        int rIndex = 1;
        int length = nums.length;
        if(length <= 2) {
            return 2;
        }

        int gap = 0;

        while(rIndex < nums.length) {
            nums[rIndex - gap] = nums[rIndex];
            if(nums[rIndex] != nums[lIndex]) {
                lIndex = rIndex - gap;
                rIndex++;
                continue;
            } 

            if(lIndex + gap == rIndex - 1) {
                rIndex++;
                continue;
            }

            gap++;
            rIndex++;
        }
        return length - gap;
    }
}
// @lc code=end

