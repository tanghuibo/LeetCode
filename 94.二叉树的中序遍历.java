import java.util.List;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        inorderTraversal(root, resultList);
        return resultList;
    }

    private void inorderTraversal(TreeNode node, List<Integer> resultList) {
        if(node == null) {
            return;
        }
        inorderTraversal(node.left, resultList);
        resultList.add(node.val);
        inorderTraversal(node.right, resultList);
    }
}
// @lc code=end

