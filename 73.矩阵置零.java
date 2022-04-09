/*
 * @lc app=leetcode.cn id=73 lang=java
 *
 * [73] 矩阵置零
 */

// @lc code=start
class Solution {
    public void setZeroes(int[][] matrix) {
        int yLength = matrix.length;
        int xLength = matrix[0].length;
        boolean topHasZero = false;
        for (int x = 0; x < xLength; x++) {
                if(matrix[0][x] == 0) {
                    topHasZero = true;
                    break;
                }
        }

        boolean leftHasZero = false;
        for (int y = 0; y < yLength; y++) {
            if(matrix[y][0] == 0) {
                leftHasZero = true;
                break;
            }
        }
        
        for (int y = 1; y < yLength; y++) {
            for (int x = 1; x < xLength; x++) {
                if(matrix[y][x] == 0) {
                    matrix[0][x] = 0;
                    matrix[y][0] = 0;
                }        
            }  
        }

        for (int y = 1; y < yLength; y++) {
            if(matrix[y][0] == 0) {
                for (int x = 1; x < xLength; x++) {
                    matrix[y][x] = 0;  
                }  
            }
        }

        for (int x = 1; x < xLength; x++) {
            if(matrix[0][x] == 0) {
                for (int y = 1; y < yLength; y++) {
                    matrix[y][x] = 0;  
                }  
            }
        }


        if(leftHasZero) {
            for (int y = 0; y < yLength; y++) {
                matrix[y][0] = 0;
            }
        }

        if(topHasZero) {
            for (int x = 0; x < xLength; x++) {
                matrix[0][x] = 0;
            }
        }
        


    }
}
// @lc code=end

