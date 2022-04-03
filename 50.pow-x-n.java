/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        if(n == 0) {
            return 1;
        }
        boolean revert = false;
        if(n < 0) {
            revert = true;
        } else {
            n = -n;
        }
        double result = 1;

        while(n != -1) {
            int i = n % 2;
            if(i == -1) {
                result = result * x;
            }
            x = x * x;
            n = n / 2;
            // System.out.println(result + "," + x + "," + n);
        }

        result = result * x;

        return revert ? (1 / result) : result;

    }
}
// @lc code=end

