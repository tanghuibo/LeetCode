/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int result = 0;
        int leftMaxHeight = height[leftIndex];
        int righMaxtHeight = height[rightIndex];

        while(leftIndex < rightIndex) {
            int leftHeight = height[leftIndex];
            int rightHeight = height[rightIndex];
            int nextIndex;
            if(leftHeight < rightHeight) {           
                leftIndex++;
                nextIndex = leftIndex;
                leftMaxHeight = Math.max(height[nextIndex], leftMaxHeight);
            } else {
                rightIndex--;
                nextIndex = rightIndex;
                righMaxtHeight = Math.max(height[nextIndex], righMaxtHeight);
            }

            int currentHeight = height[nextIndex];
            result = result + Math.max(Math.min(leftMaxHeight, righMaxtHeight) - currentHeight, 0);
        }

        return result;
    }
}
// @lc code=end

