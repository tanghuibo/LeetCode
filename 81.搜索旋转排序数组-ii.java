/*
 * @lc app=leetcode.cn id=81 lang=java
 *
 * [81] 搜索旋转排序数组 II
 */

// @lc code=start
class Solution {
    public boolean search(int[] nums, int target) {
        int length = nums.length;

        if(target < nums[0] && target > nums[length - 1]) {
            return false;
        }

        int rIndex = length - 1;

        int lIndex = 0;

        if(target == nums[lIndex]) {
            return true;
        }

        if(target == nums[rIndex]) {
            return true;
        }
        

        while(lIndex < rIndex) {
            int lData = nums[lIndex];
            if(lData == target) {
                return true;
            }
            int rData = nums[rIndex];
            if(rData == target) {
                return true;
            }
            if(lIndex == rIndex - 1) {
                return false;
            }

            int mIndex = lIndex + (rIndex - lIndex) / 2;
        
            int mData = nums[mIndex];

            if(mData == target) {
                return true;
            }
         
            if(lData == mData && mData == rData) {
                lIndex++;
                rIndex--;
                continue;
            }
            if(lData <= mData) {
                if(lData <= target && target < mData) {
                    rIndex = mIndex;
                } else {
                    lIndex = mIndex;
                }
            } else {
                if(mData < target && target <= rData) {
                    lIndex = mIndex;
                } else {
                    rIndex = mIndex;
                }
            }
        }


        return false;


    }
}
// @lc code=end
