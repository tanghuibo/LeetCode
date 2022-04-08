/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根 
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        if(x == 0) {
            return 0;
        }
        if(x < 4) {
            return 1;
        } else if(x < 9) {
            return 2;
        }
        int right = x / 2;
        int left = 1;

        while(left < right - 1) {

            int mid = (left + right) / 2;
 
            int midResult = mid * mid;
            if(midResult / mid != mid) {
                right = mid;
                continue;
            }

            if(midResult == x) {
                return mid;
            }
            if(midResult > x) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }
}
// @lc code=end

