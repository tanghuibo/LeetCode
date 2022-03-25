/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现 strStr()
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
        int[] nextList = new int[m];
        for(int i = 1, j = 0; i < m; i++) {
            while(j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = nextList[j - 1];
            }
            if(needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            nextList[i] = j;
        }
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = nextList[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }
}
// @lc code=end

