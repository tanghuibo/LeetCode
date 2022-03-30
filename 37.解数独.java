/*
 * @lc app=leetcode.cn id=37 lang=java
 *
 * [37] 解数独
 */

// @lc code=start
class Solution {
    public void solveSudoku(char[][] board) {
        dfsWrite(board, 0, 0);

    }

    boolean dfsWrite(char[][] board, int x, int y) {
        if(x == 9) {
            return true;
        }
        int nextY = y + 1;
        int nextX = x;
        if(nextY == 9) {
            nextX++;
            nextY = 0;
        }
        if(board[x][y] != '.') {
            return dfsWrite(board, nextX, nextY);
        }

        for (int i = 0; i < 9; i++) {
            board[x][y] = (char)('1' + i);
            if(!checkX(board, x)) {
                continue;
            }
            if(!checkY(board, y)) {
                continue;
            }
            if(!checkBlock(board, x / 3, y / 3)) {
                continue;
            }
            if(dfsWrite(board, nextX, nextY)) {
                return true;
            }
        }
        board[x][y] = '.';
        return false;
    }

    private char[] getZeroChar(int count) {
        char[] data = new char[count];
        for (int i = 0; i < count; i++) {
            data[i] = '0';
        }
        return data;
    }

    private boolean checkBlock(char[][] board, int x, int y) {
        char[] data = getZeroChar(9);
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

    private boolean checkX(char[][] board, int y) {
        char[] data = getZeroChar(9);
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

    private boolean checkY(char[][] board, int x) {
        char[] data = getZeroChar(9);
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
}
// @lc code=end

