import java.util.List;

/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {

        int yLength = board.length;
        int xLength = board[0].length;
        Character[][] charListList = new Character[yLength][xLength];
        List<Integer> xIndex = new ArrayList<>();
        List<Integer> yIndex = new ArrayList<>();
        for (int y = 0; y < yLength; y++) {
            for (int x = 0; x< xLength; x++) {
                char cr = board[y][x];
                int index = word.indexOf(cr);
               if(index >= 0) {
                   charListList[y][x] = cr;
                }
                if(index == 0) {
                    if(word.length() == 1) {
                        return true;
                    }
                    xIndex.add(x);
                    yIndex.add(y);
                }
            }
        }

       char startChar = word.charAt(0);


       word = word.substring(1);


        for (int i = 0; i < xIndex.size(); i++) {
            int y = yIndex.get(i);
            int x = xIndex.get(i);
            charListList[y][x] = null;
            if(search(charListList, word, y, x)) {
                return true;
            }
            charListList[y][x] = startChar;
        }
        return false;
    }

    private boolean search(Character[][] charListList, String word, int y, int x) {
        if(word.length() == 0) {
            return true;
        }
        char searchChar = word.charAt(0);
        String nextWord = word.substring(1);
        if(match(getChar(charListList, y + 1, x), searchChar)) {
           charListList[y + 1][x] = null;
           if(search(charListList, nextWord, y + 1, x)) {
               return true;
           }
           charListList[y + 1][x] = searchChar;
        }

        if(match(getChar(charListList, y - 1, x), searchChar)) {
            charListList[y - 1][x] = null;
            if(search(charListList, nextWord, y - 1, x)) {
                return true;
            }
            charListList[y - 1][x] = searchChar;
        }

        if(match(getChar(charListList, y, x + 1), searchChar)) {
            charListList[y][x + 1] = null;
            if(search(charListList, nextWord, y, x + 1)) {
                return true;
            }
            charListList[y][x + 1] = searchChar;
        }

        if(match(getChar(charListList, y, x - 1), searchChar)) {
            charListList[y][x - 1] = null;
            if(search(charListList, nextWord, y, x - 1)) {
                return true;
            }
            charListList[y][x - 1] = searchChar;
        }
        
        return false;
    }

    private boolean match(Character a, char b) {
        if(a == null) {
            return false;
        }
        return a == b;
    }

    private Character getChar(Character[][] charListList, int y, int x) {
        if(y < 0) {
            return null;
        }
        if(x < 0) {
            return null;
        }

        if(y >= charListList.length) {
            return null;
        }
        Character[] charList = charListList[y];

        if(x >= charList.length) {
            return null;
        }
        return charList[x];
    }
}
// @lc code=end

