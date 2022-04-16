import java.util.List;

/*
 * @lc app=leetcode.cn id=89 lang=java
 *
 * [89] 格雷编码
 */

// @lc code=start
class Solution {
    public List<Integer> grayCode(int n) {
        int length = 1 << n;
        List<Integer> resultList = new ArrayList<>(length);
        int index = 1;
        int beforeData = 0;
        resultList.add(0);
        while(index < length) {
            int data = revertWithBit(beforeData, getRevertIndex(index));
            resultList.add(data);
            beforeData = data;
            index++;
        }
        return resultList;
    }

    int revertWithBit(int data, int index) {
        int temp = 1 << (index - 1);
        if((data & temp) == 0) {
            return data + temp;
        }
        return data - temp;
    }

    int getRevertIndex(int index) {
        int count = 1;
        while(index % 2 != 1) {
            count++;
            index = index >> 1;
        }
        return count;
    }
}
// @lc code=end

