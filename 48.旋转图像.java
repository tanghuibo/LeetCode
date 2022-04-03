/*
 * @lc app=leetcode.cn id=48 lang=java
 * (y, x) -> (x, size-y-1) ->  (size-y-1, size-x-1) -> (size-x-1, y)
 * [48] 旋转图像
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        int size = matrix.length;

        for (int y = 0; y <= size / 2; y++) {
            for (int x = y; x < size - y - 1;  x++) {
                int temp = matrix[y][x];

                int nextTemp = matrix[x][size - y - 1];
                matrix[x][size - y - 1] = temp;
                temp = nextTemp;

                nextTemp = matrix[size - y - 1][size - x - 1];
                matrix[size - y - 1][size - x - 1] = temp;
                temp = nextTemp;

                nextTemp = matrix[size - x - 1][y];
                matrix[size - x - 1][y] = temp;
                temp = nextTemp;

                matrix[y][x] = temp;
            }
        }

    }
}
// @lc code=end

