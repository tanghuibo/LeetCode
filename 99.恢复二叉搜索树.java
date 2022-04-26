import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=99 lang=java
 *
 * [99] 恢复二叉搜索树
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
    public void recoverTree(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        foreach(root, list);
        Integer left = null;
        Integer right = null;

        for (int i = 1; i < list.size(); i++) {
            int a = list.get(i - 1);
            int b = list.get(i);
            if(b < a) {
                if(left == null) {
                    left = a;
                    right = b;
                } else {
                    right = b;
                }
            }
        }
        foreach(root, left, right);
    }

    private void foreach(TreeNode node, int a, int b) {
        if(node == null) {
            return;
        }
        if(node.val == a) {
            node.val = b;
        } else if(node.val == b) {
            node.val = a;
        }
        foreach(node.left, a, b);
        foreach(node.right, a, b);
    }

    private void foreach(TreeNode node, List<Integer> list) {
        if(node == null) {
            return;
        }
        foreach(node.left, list);
        list.add(node.val);
        foreach(node.right, list);
    }
}
// @lc code=end

