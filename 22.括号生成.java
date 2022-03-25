/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> resultList = new ArrayList<>();
        generateParenthesis(n, 0, 0, "", resultList);
        return resultList;
    }

    private void generateParenthesis(int allCount, int leftCount, int rightCount, String data, List<String> resultList) {
        if(rightCount == allCount && leftCount == allCount) {
            resultList.add(data);
            return;
        }
        if(leftCount < allCount) {
            generateParenthesis(allCount, leftCount + 1, rightCount, data + "(", resultList);
        }

        if(rightCount < leftCount) {
            generateParenthesis(allCount, leftCount, rightCount + 1, data + ")", resultList);
        }

        

    }
}
// @lc code=end

