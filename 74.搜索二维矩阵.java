/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int yLength = matrix.length;
        int xLength = matrix[0].length;
        int leftIndex = 0;
        int rightIndex = yLength * xLength - 1;

        if(matrix[0][0] == target) {
            return true;
        }

        if(matrix[yLength - 1][xLength - 1] == target) {
            return true;
        }

        while(leftIndex < rightIndex - 1) {
            int midIndex = (leftIndex + rightIndex) / 2;

            int midY = midIndex / xLength;
            int midX= midIndex % xLength;
            int midResult = matrix[midY][midX];
            if(midResult == target) {
                return true;
            }
            if(midResult < target) {
                leftIndex = midIndex;
            } else {
                rightIndex = midIndex;
            }
        }
        return false;
    }
}
// @lc code=end

