/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }

        if(n == 0) {
            return;
        }

        int index = m + n - 1;
        while(index >= 0) {
            int num1 = nums1[m - 1];
            int num2 = nums2[n - 1];
            if(num1 > num2) {
                nums1[index] = num1;
                m--;
                if(m == 0) {
                    for (int i = 0; i < n; i++) {
                        nums1[i] = nums2[i];
                    }
                    break;
                }
            } else {
                nums1[index] = num2;
                n--;
                if(n == 0) {
                    break;
                }
            }
            index--;
        }
    }
}
// @lc code=end

