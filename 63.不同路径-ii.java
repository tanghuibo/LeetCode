/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int ySize = obstacleGrid.length;
        if(ySize == 0) {
            return 0;
        }
        int xSize = obstacleGrid[0].length;
        if(xSize == 0) {
            return 0;
        }

        if(obstacleGrid[0][0] == 1) {
            return 0;
        }
        


        for (int y = 0; y < ySize; y++) {
            for (int x = 0; x < xSize; x++) {
                if(x == 0 && y == 0) {
                    obstacleGrid[y][x]  = 1;
                    continue;
                }
                if(obstacleGrid[y][x]  == 1) {
                    obstacleGrid[y][x]  = 0;
                    continue;
                }
                int top = 0;
                if(y > 0) {
                    top = obstacleGrid[y -1][x];
                }
                int left = 0;
                if(x > 0) {
                    left = obstacleGrid[y][x - 1];
                }
                obstacleGrid[y][x] = top + left;
            }
        }
        return obstacleGrid[ySize - 1][xSize - 1];

    }
}
// @lc code=end

