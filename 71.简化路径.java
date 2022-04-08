import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=71 lang=java
 *
 * [71] 简化路径
 */

// @lc code=start
class Solution {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");

        LinkedList<String> resultList = new LinkedList<>();

        for (String pt : paths) {
            if(pt == "" || ".".equals(pt)) {
                continue;
            }
            if("..".equals(pt)) {
                if(resultList.size() > 0) {
                    resultList.removeLast();
                }
                continue;
            }
            resultList.add(pt);
        }
        if(resultList.size() == 0) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (String result : resultList) {
            sb.append("/");
            sb.append(result);
        }
        return sb.toString();
    }
}
// @lc code=end

