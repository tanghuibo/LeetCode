/*
 * @lc app=leetcode.cn id=62 lang=java
 *
 * [62] 不同路径
 */

// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0 || j == 0) {
                    result[i][j] = 1;
                    continue;
                }
                result[i][j] = result[i - 1][j] + result[i][j - 1];
            }
        }
        return result[m - 1][n - 1];

    }
}
// @lc code=end

