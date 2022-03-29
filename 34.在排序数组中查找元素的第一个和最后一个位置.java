/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int index = search(nums, target);
        if(index == -1) {
            return new int[]{-1, -1};
        }
        return new int[] {
            getLeft(nums, index),
             getRight(nums, index)};



    }

    private int getLeft(int[] nums, int index) {
        int l = 0;
        int r = index;
        if(l == r) {
            return index;
        }
        int target = nums[index];
        while(true) {
            if(l == r - 1) {
                if(nums[l] == target) {
                    return l;
                } else {
                    return r;
                }
            }
            int m = (l + r) / 2;
            if(nums[m] == target) {
                r = m;
            } else {
                l = m;
            }
        }
    }

    private int getRight(int[] nums, int index) {
       
        int l = index;
        int r = nums.length - 1;
        if(l == r) {
            return index;
        }
        int target = nums[index];
        
        while(true) {
            if(l == r - 1) {
                if(nums[r] == target) {
                    return r;
                } else {
                    return l;
                }
            }
            int m = (l + r) / 2;
            if(nums[m] == target) {
                l = m;
            } else {
                r = m;
            }
        }
    }

    private int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        if(r < 0) {
            return -1;
        }
        if(nums[0] > target) {
            return -1;
        }
        if(nums[r] < target) {
            return -1;
        }
        while(true) {
            int m = (l + r) / 2;
            if(nums[m] == target) {
                return m;
            }
            if(l >= r - 1) {
                if(nums[r] == target) {
                    return r;
                }
                return -1;
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

