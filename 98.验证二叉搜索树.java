/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }
    private boolean isValidBST(TreeNode root, Integer minVal, Integer maxVal) {
        int rootVal = root.val;
        if(minVal != null && rootVal <= minVal) {
            return false;
        }
        if(maxVal != null && rootVal >= maxVal) {
            return false;
        }
        TreeNode left = root.left;
        if(left != null) {
            if(!isValidBST(left, minVal, rootVal)) {
                return false;
            }            
        }

        TreeNode right = root.right;
        if(right != null) {
            if(!isValidBST(right, rootVal, maxVal)) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

