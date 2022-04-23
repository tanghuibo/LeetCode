/*
 * @lc app=leetcode.cn id=97 lang=java
 *
 * [97] 交错字符串
 */

// @lc code=start
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int s1Length = s1.length();
        int s2Length = s2.length();
        int s3Length = s3.length();
        if(s3Length != s1Length + s2Length) {
            return false;
        }
        boolean[][] resultList = new boolean[s1Length + 1][s2Length + 1];

        resultList[0][0] = true;


        for (int i = 0; i <= s1Length; i++) {
            for (int j = 0; j <= s2Length; j++) {
                if(i + j == 0) {
                    continue;
                }
                char s3Char = s3.charAt(i + j - 1);
                boolean result = false;
                if(i > 0) {
                    result = result || (resultList[i - 1][j] && s3Char == s1.charAt(i - 1));
                }
                if(j > 0) {
                    result = result ||  (resultList[i][j - 1]  && s3Char == s2.charAt(j - 1));
                }
                resultList[i][j] = result;
            }
        }
        return resultList[s1Length][s2Length];

    } 
}
// @lc code=end

