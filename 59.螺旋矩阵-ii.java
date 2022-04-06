/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {

        int time = 0;
        int x = 0;
        int y = 0;
        int[][] resultList = new int[n][n];
        int writeIndex = 1;

        while(writeIndex <=  n * n) {
            resultList[y][x] = writeIndex;
            writeIndex++;
            switch(time % 4) {
                case 0:
                x++;
                if(x >= n - time / 4 - 1) {
                    time++;
                }
                break;
                case 1:
                y++;
                if(y >= n - time / 4 - 1) {
                    time++;
                }
                break;
                case 2:
                x--;
                if(x <= time / 4) {
                    time++;
                }
                break;
                case 3:
                y--;
                if(y <= time / 4 + 1) {
                    time++;
                }
                break;
            }
        }
        return resultList;

    }
}
// @lc code=end

