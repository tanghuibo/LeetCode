import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=57 lang=java
 *
 * [57] 插入区间
 */

// @lc code=start
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0) {
            return new int[][] {newInterval};
        }
        int startIndex = -1;
        int endIndex = -1;
        boolean inOver = false;

        for (int i = 0; i < intervals.length; i++) {
            if(!inOver) {
                if(newInterval[0] > intervals[i][1]) {
                    continue;
                }
                startIndex = i;
                inOver = true;
            }
            if(inOver) {
                if(newInterval[1] >= intervals[i][0]) {
                    endIndex = i;
                    continue;
                }
                break;
            }
        }
        if(endIndex == -1) {
            int[][] resultList = new int[intervals.length + 1][2];
            boolean after = false;
            for (int i = 0; i < intervals.length; i++) {
                if(after) {     
                    resultList[i + 1] = intervals[i];
                    continue;
                }
                if(newInterval[1] > intervals[i][0]) {
                    resultList[i] = intervals[i];
                    continue;
                }
                resultList[i] = newInterval;
                resultList[i + 1] = intervals[i];
                after = true;
            }
            if(!after) {
                resultList[resultList.length - 1] = newInterval;
            }
            return resultList;
        }

        int[][] resultList = new int[intervals.length + (startIndex - endIndex)][2];
        for (int i = 0; i < intervals.length; i++) {
            if(i < startIndex) {
                resultList[i] = intervals[i];
                continue;
            } 

            if(i == startIndex) {
                resultList[i] = new int[] {Math.min(newInterval[0], intervals[startIndex][0]),
                    Math.max(newInterval[1], intervals[endIndex][1])};
                    i = endIndex;
                    continue;
            }
            if(i > endIndex) {
                resultList[i - endIndex + startIndex] = intervals[i];
            }
        }
        return resultList;
    }
}
// @lc code=end

