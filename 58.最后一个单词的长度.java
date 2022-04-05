/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        char[] crList = s.toCharArray();

        int maxLength = 0;
        boolean init = false;
        for (int i = crList.length - 1; i >= 0; i--) {
            char cr = crList[i];
            if(!init) {
                if(cr != ' ') {
                    init = true;
                    maxLength = 1;
                }
                continue;
            }
            if(cr != ' ') {
                maxLength++;
            } else {
                return maxLength;
            }
        }
        return maxLength;

    }
}
// @lc code=end

