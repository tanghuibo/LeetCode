import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    static class  Interval {
        int start;
        int end;

        Interval() {

        }

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "[" + start + "," + end  + "]";
        }
    }
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (l1, l2) -> l1[0] - l2[0]);

        List<Interval> resultList = new ArrayList<>();

        for (int[] is : intervals) {
            Interval interval = new Interval(is[0], is[1]);
            insert(resultList, interval);
        }

        int[][] result = new int[resultList.size()][2];

        for (int i = 0; i < resultList.size(); i++) {
            result[i] = new int[] {resultList.get(i).start, resultList.get(i).end};
        }

        return result;
    
    }

    boolean hasOver(Interval intervalA, Interval intervalB) {
        if(intervalA.start >= intervalB.start && intervalA.start <= intervalB.end) {
            return true;
        }

        if(intervalA.end >= intervalB.start && intervalA.end <= intervalB.end) {
            return true;
        }

        if(intervalB.start >= intervalA.start && intervalB.start <= intervalA.end) {
            return true;
        }

        return false;
    }

    void insert(List<Interval> list, Interval item) {
        if(list.size() == 0) {
            list.add(item);
            return;
        }
        Interval last = list.get(list.size() - 1);

        if(!hasOver(last, item)) {
            list.add(item);
            return;
        }
        list.set(list.size() - 1, merge(last, item));
    }

    Interval  merge(Interval intervalA, Interval intervalB) {
        return new Interval(Math.min(intervalA.start, intervalB.start),
         Math.max(intervalA.end, intervalB.end));
    }
}
// @lc code=end

