/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        char[] data = new char[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!checkX(board, i, data)) {
                    return false;
                }
                if (!checkY(board, j, data)) {
                    return false;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!checkBlock(board, i, j, data)) {
                    return false;
                } 
            }
        }
        return true;
    }

    private boolean checkBlock(char[][] board, int x, int y, char[] data) {
        clean(data);
        x = 3 * x;
        y = 3 * y;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char cr = board[y + i][x + j];
                if (cr == '.') {
                    continue;
                }
                int index = cr - '1';
                if (data[index] != '0') {
                    return false;
                }
                data[index] = cr;
            }
        }
        return true;
    }

    private boolean checkX(char[][] board, int y, char[] data) {
        clean(data);
        for (int i = 0; i < 9; i++) {
            char cr = board[y][i];
            if (cr == '.') {
                continue;
            }
            int index = cr - '1';
            if (data[index] != '0') {
                return false;
            }
            data[index] = cr;
        }
        return true;
    }

    private boolean checkY(char[][] board, int x, char[] data) {
        clean(data);
        for (int i = 0; i < 9; i++) {
            char cr = board[i][x];
            if (cr == '.') {
                continue;
            }
            int index = cr - '1';
            if (data[index] != '0') {
                return false;
            }
            data[index] = cr;
        }
        return true;
    }

    private void clean(char[] data) {
        for (int i = 0; i < data.length; i++) {
            data[i] = '0';
        }
    }
}
// @lc code=end
