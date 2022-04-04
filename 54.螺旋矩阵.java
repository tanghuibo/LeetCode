import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int yLength = matrix.length;
        int xLength = matrix[0].length;
        int allCount = xLength * yLength;
        List<Integer> resultList = new ArrayList<>();
        if(xLength == 1) {
            for (int i = 0; i < yLength; i++) {
                resultList.add(matrix[i][0]);
            }
            return resultList;
        }
        if(yLength == 1) {
           for (int i = 0; i < xLength; i++) {
                resultList.add(matrix[0][i]);
            }
            return resultList;
        }
        int x = 0;
        int y = 0;
        int time = 0;
        while(true) {
            resultList.add(matrix[y][x]);
            if(resultList.size() == allCount) {
                break;
            }
            int count = time / 4;
            switch(time % 4) {
                case 0:
                    x++;
                    if(x == xLength - count - 1) {
                        time++;
                    }
                break;
                case 1:
                    y++;
                    if(y == yLength - count - 1) {
                        time++;
                    }
                break;
                case 2:
                    x--;
                    if(x == count) {
                        time++;
                    }
                break;
                case 3:
                    y--;
                    if(y == count + 1) {
                        time++;
                    }
                break;

            }
            
        }


        return resultList;

    }
}
// @lc code=end

