/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {

        int ySize = grid.length;
        if(ySize == 0) {
            return 0;
        }
        int xSize = grid[0].length;
        if(xSize == 0) {
            return 0;
        }

        for (int y = 0; y < ySize; y++) {
            for (int x = 0; x < xSize; x++) {
                if(y == 0) {
                    if(x == 0) {
                        continue;
                    }
                    grid[y][x] = grid[y][x] + grid[y][x - 1];
                    continue;
                }
                if(x == 0) {
                    grid[y][x] = grid[y][x] + grid[y - 1][x];
                    continue;
                }

                grid[y][x] = grid[y][x] + Math.min(grid[y - 1][x],  grid[y ][x - 1]);

            }
        }

        return grid[ySize- 1][xSize - 1];
        

    }
}
// @lc code=end

