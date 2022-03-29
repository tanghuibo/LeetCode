/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {

        int leftIndex = 0;

        int rightIndex = nums.length - 1;

        if(rightIndex == 0) {
            return nums[0] == target ? 0 : -1;
        }

        int maxDataIndex = 0;

        while(true) {
            int leftData = nums[leftIndex];
            int rightData = nums[rightIndex];
            if(rightData > leftData) {
                maxDataIndex = rightIndex;
                break;
            }
            if(leftIndex == rightIndex - 1) {
                if(rightData > leftData) {
                    maxDataIndex = rightIndex;
                } else {
                    maxDataIndex = leftIndex;
                }
                break;
            }
            maxDataIndex = ( leftIndex  + rightIndex) / 2;
            int maxData = nums[maxDataIndex];
            int maxIndexNextData = nums[maxDataIndex + 1];
            if(maxData >= leftData && maxIndexNextData < maxData) {
                break;
            }

            if(maxData < leftData) {
                rightIndex = maxDataIndex;
            } else {
                leftIndex = maxDataIndex;
            }
        }
        
        int result = search(nums, 0, maxDataIndex, target);
        if(result >= 0) {
            return result;
        }

        if(maxDataIndex == nums.length - 1) {
            return -1;
        }
        return search(nums, maxDataIndex + 1, nums.length - 1, target);
    }

    private int search(int[] nums, int leftIndex, int rightIndex, int target) {
        if(target < nums[leftIndex]) {
            return -1;
        }
        if(target > nums[rightIndex]) {
            return -1;
        }
        if(target == nums[leftIndex]) {
            return leftIndex;
        }
        if(target == nums[rightIndex]) {
            return rightIndex;
        }

        while(true) {
            int midIndex = (leftIndex + rightIndex) / 2;

            if(nums[midIndex] == target) {
                return midIndex;
            }
            if(leftIndex == rightIndex - 1) {
                return -1;
            }
            if(nums[midIndex] < target) {
                leftIndex = midIndex;
            } else {
                rightIndex = midIndex;
            }
        }
    }
}
// @lc code=end

