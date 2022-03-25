/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {

        int index = 0;
        for(int num : nums) {
            if(num == val) {
                continue;
            }
            nums[index] = num;
            index++;
        }
        return index;

    }
}
// @lc code=end

