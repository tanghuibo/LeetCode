import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        int x = 0;
        int y = 1;
        for (int i = 0; i < n; i++) {
            int result = x + y;
            x = y;
            y = result;
        }
        return y;

    }
}
// @lc code=end

