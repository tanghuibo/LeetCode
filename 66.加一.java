/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {

        boolean needNewContainer = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            int item = digits[i];
            item++;
            boolean over = item > 9;
            if(!over) {
                digits[i] = item;
                break;
            }
            item = item % 10;
            digits[i] = item;
            if(i == 0) {
                needNewContainer = true;
            }
        }
        if(!needNewContainer) {
            return digits;
        }

        int[] newDigits = new int[digits.length + 1];
        newDigits [0]= 1;
        for (int i = 0; i < digits.length; i++) {
            newDigits[i + 1] = digits[i];
        }
        return newDigits;

    }
}
// @lc code=end

