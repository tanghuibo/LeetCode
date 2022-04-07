/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 */

// @lc code=start
class Solution {
    public String addBinary(String a, String b) {
       char[] aCharList = a.toCharArray();
       char[] bCharList = b.toCharArray();
       int maxLength = Math.max(aCharList.length, bCharList.length);
       String result = "";
       int newAdd = 0;
       for (int i = 0; i < maxLength; i++) {
           int aIndex = aCharList.length - 1 - i;
           int bIndex = bCharList.length - 1 - i;
           int newItem = newAdd;
           if(aIndex >= 0 && aCharList[aIndex] == '1') {
                newItem++;
           }

           if(bIndex >= 0 && bCharList[bIndex] == '1') {
               newItem++;
          }
          newAdd = newItem / 2;
          result = newItem % 2 + result;
       }
       if(newAdd != 0) {
           result = newAdd + result;
       }

       return result;

    }
}
// @lc code=end

