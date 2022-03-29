/*
 * @lc app=leetcode.cn id=29 lang=java
 *
 * [29] 两数相除
 */

// @lc code=start
class Solution {
    public int divide(int dividend, int divisor) {
         // 考虑被除数为最小值的情况
         if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        // 考虑除数为最小值的情况
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        // 考虑被除数为 0 的情况
        if (dividend == 0) {
            return 0;
        }
        
        // 一般情况，使用类二分查找
        // 将所有的正数取相反数，这样就只需要考虑一种情况
        boolean rev = false;
        if (dividend > 0) {
            dividend = -dividend;
            rev = !rev;
        }
        if (divisor > 0) {
            divisor = -divisor;
            rev = !rev;
        }
        
        int i = 0;
        int data = divisor;

        while(data >= dividend - data) {
           i ++;
           data = data << 1;
        }


        if(data == dividend) {
            int result = 1 << i;
            return rev ? -result : result;
        }

        int result = 0;

        while(i >= 0) {
            if(dividend <= data) {
                dividend = dividend - data;
                result = result + (1 << i);
            }
            i--;
            data = data >> 1;
        }
        return rev ? -result : result;
    }
}
// @lc code=end

