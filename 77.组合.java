/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> resultList = new ArrayList<>();
        int[] item = new int[k];
        search(resultList, item, n, k, 1);
        return resultList;
    }

    private void search(List<List<Integer>> resultList, int[]  item, int n, int k, int start) {
        int end = n - k + 1;
        for (int i = start; i <= end; i++) {
            item[k - 1] = i;
            if(k == 1) {
                resultList.add(copy(item));
                continue;
            }
            search(resultList, item, n, k - 1, i + 1);
        }
    }

    private List<Integer> copy(int[] list) {
        List<Integer> result = new ArrayList<>();

        for(Integer item : list) {
            result.add(item);
        }

        return result;
    }
}
// @lc code=end

