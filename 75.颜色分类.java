/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        int red = 0;
        int white = 0;

        for (int num : nums) {
            switch(num) {
                case 0:
                    red++;
                    break;
                case 1:
                    white++;
                    break;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if(red > 0) {
                nums[i] = 0;
                red--;
                continue;
            }
            if(white > 0) {
                nums[i] = 1;
                white--;
                continue;
            }
            nums[i] = 2;
            
        }

    }
}
// @lc code=end

