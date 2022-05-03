import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
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
    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root == null) {
            return new ArrayList<>(0);
        }
        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> currentList = new ArrayList<>();
        currentList.add(root);
        while(currentList.size() != 0) {
            List<TreeNode> newNodeList = new ArrayList<>();
            List<Integer> newResultList = new ArrayList<>();
            for (TreeNode node : currentList) {
                newResultList.add(node.val);
                if(node.left != null) {
                    newNodeList.add(node.left);
                }
                if(node.right != null) {
                    newNodeList.add(node.right);
                }
            }
            result.add(newResultList);
            currentList = newNodeList;
        }
        return result;

    }
}
// @lc code=end

