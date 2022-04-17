/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        char[] chars =  s.toCharArray();
        if(chars.length == 0 || chars[0] == '0') {
            return 0;
        }
        int count  = 1;
        int beforeCount = 1;
        for (int i = 1; i < chars.length; i++) {
            int current = 0;
           if(chars[i] != '0') {
                current += count;
           }
           if(chars[i - 1] !='0' 
           && (chars[i - 1] - '0') * 10 + (chars[i] - '0') <= 26) {
               current += beforeCount;
           }

           beforeCount = count;
           count = current;
        }
        return count;
    }
}
// @lc code=end

