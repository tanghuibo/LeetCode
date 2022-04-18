import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原 IP 地址
 */

// @lc code=start
class Solution {
    public List<String> restoreIpAddresses(String s) {
        if(s.length() < 4) {
            return Arrays.asList();
        }
        List<String> resultList = new ArrayList<>();
        dfs(4, new int[4], s.toCharArray(), 0, resultList);
        return resultList;
    }

    private void dfs(int time, int[] ipAddress, char[] chars, int charIndex, List<String> resultList) {
        if(chars.length - charIndex > time * 4) {
            return;
        }
        if(time == 1) {
            if(chars[charIndex] == '0') {
                if(chars.length == charIndex + 1) {
                    ipAddress[3] = 0;
                    resultList.add(toIpString(ipAddress));
                }
                return;
            }
            int i = toInt(chars, charIndex, chars.length - charIndex);
            if(i <= 255) {
                ipAddress[3] = i;
                resultList.add(toIpString(ipAddress));
            }
            return;
        }

        if(chars[charIndex] == '0') {
            ipAddress[4 - time] = 0;
            dfs(time - 1, ipAddress, chars, charIndex + 1, resultList);
            return;
        }

        for (int i = 1; i < 4 && charIndex + i <= chars.length - time + 1; i++) {
            int j = toInt(chars, charIndex, i);
            if(j <= 255) {
                ipAddress[4 - time] = j;
                 dfs(time - 1, ipAddress, chars, charIndex + i, resultList);
            } 
        }
    }

    private String toIpString(int[] ipAddress) {
        return ipAddress[0] + "." + ipAddress[1] + "."
        + ipAddress[2] + "."  + ipAddress[3];
    }

    private int toInt(char[] chars, int start, int length) {
        int result = 0;
        for(; length > 0; length--) {
            result = result * 10 + (chars[start] - '0');
            start++;
        }
        return result;
    }
}
// @lc code=end

