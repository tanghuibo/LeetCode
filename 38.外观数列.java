import javax.crypto.spec.GCMParameterSpec;

/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 外观数列
 */

// @lc code=start
class Solution {
    public String countAndSay(int n) {
        String str = "1";
        for (int i = 1; i < n; i++) {
            str = getNext(str);
        }
        return str;
    }

    private String getNext(String item) {
        char[] crList = item.toCharArray();
        char currentCr = crList[0];
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < crList.length; i++) {
            char thisCr = crList[i];
            if(thisCr == currentCr) {
                count ++;
                continue;
            } 
            sb.append(count);
            sb.append(currentCr);
            count = 1;
            currentCr = thisCr;
        }
        sb.append(count);
         sb.append(currentCr);
         return sb.toString(); 
    }


}
// @lc code=end

