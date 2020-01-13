/*
 * @lc app=leetcode.cn id=4 lang=javascript
 *
 * [4] 寻找两个有序数组的中位数
 */
/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function(nums1, nums2) {
    let n1 = nums1.length;
    let n2 = nums2.length;
    if (n1 > n2) {
        return findMedianSortedArrays(nums2, nums1);
    }
    let k = Math.floor((n1 + n2 + 1) / 2);
    let left = 0;
    let right = n1;
    while (left < right) {
      let m1 = left + Math.floor((right - left) / 2);
      let m2 = k - m1;
      if (nums1[m1] < nums2[m2 - 1]) {
        left = m1 + 1;
      } else {
        right = m1;
      } 
    }
    let m1 = left;
    let m2 = k - left;
    let c1 = max(
      m1 <= 0 ? null : nums1[m1 - 1],
      m2 <= 0 ? null : nums2[m2 - 1]
    );
    if ((n1 + n2) % 2 == 1) {
        return c1;
    }
    let c2 = min(m1 >= n1 ? null : nums1[m1], m2 >= n2 ? null : nums2[m2]);
    return (c1 + c2) * 0.5;
  };
  
  function max(a, b) {
    if (a == null) {
      return b;
    }
    if (b == null) {
      return a;
    }
    let result = Math.max(a, b);
    return result;
  }
  
  function min(a, b) {
    if (a == null) {
      return b;
    }
    if (b == null) {
      return a;
    }
    let result = Math.min(a, b);
    return result;
  }
  