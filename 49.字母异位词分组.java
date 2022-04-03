import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> resultMap = new HashMap<>();
        for (String str : strs) {
            String key = buildKey(str);
            List<String> dataList = resultMap.get(key);
            if(dataList == null) {
                dataList = new ArrayList<>();
                resultMap.put(key, dataList);
            }
            dataList.add(str);
        }
        return new ArrayList<>(resultMap.values());

    }

    private String buildKey(String item) {
        int[] indexList = new int[26];
        char[] crList = item.toCharArray();

        for (char c : crList) {
            indexList[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            int data = indexList[i];
            if(data > 0) {
                sb.append((char)(i + 'a'));
                sb.append(data);
            }
        }
        return sb.toString();
    }
}
// @lc code=end

