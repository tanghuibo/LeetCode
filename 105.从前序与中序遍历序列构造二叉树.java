/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    int[] preorder;
    int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        this.preorder = preorder;
        this.inorder = inorder;
        TreeNode node = new TreeNode(preorder[0]);
        setNext(node, 0);
        return node;

    }

    private void setNext(TreeNode node, int i) {
        if (i + 1 >= preorder.length) {
            return;
        }
        int thisValue = node.val;
        int nextValue = this.preorder[i + 1];
        if (i + 2 >= preorder.length) {
            int thisIndex = getInorderIndex(thisValue);
            int nextIndex = getInorderIndex(nextValue);
            if (thisIndex == nextIndex + 1) {
                node.left = new TreeNode(nextValue);
            } else if (thisIndex + 1 == nextIndex) {
                node.right = new TreeNode(nextValue);
            }
            return;
        }

        int nextNextValue = this.preorder[i + 2];
        int thisIndex = getInorderIndex(thisValue);
        int nextIndex = getInorderIndex(nextValue);
        int nextNextIndex = getInorderIndex(nextNextValue);

        if (nextIndex < thisIndex && thisIndex < nextNextIndex) {
            node.left = new TreeNode(nextValue);
            node.right = new TreeNode(nextNextValue);
            setNext(node.left, i + 1);
            setNext(node.right, i + 2);
            return;
        }

        if (nextIndex > thisIndex && nextNextIndex > thisIndex) {
            if (i < getPreorderIndex(this.inorder[thisIndex + 1]))  {
                if(neer(nextIndex, nextNextIndex) || thisIndex + 1 == nextNextIndex) {
                    node.right = new TreeNode(nextValue);
                    setNext(node.right, i + 1);
                } else {
                    node.right = new TreeNode(nextNextValue);
                    setNext(node.right, i + 1);
                }
            }
            return;
        }
        if (nextIndex < thisIndex && nextNextIndex < thisIndex) {
            if (i < getPreorderIndex(this.inorder[thisIndex - 1])) {
                if(neer(nextIndex, nextNextIndex)) {
                    node.left = new TreeNode(nextValue);
                    setNext(node.left, i + 1);
                } else {
                    node.left = new TreeNode(nextNextValue);
                    setNext(node.left, i + 1);
                }
                
                return;
            }
        }
    }

    private boolean neer(int i, int j) {
        return i > j ? i - j == 1 :j - i == 1;
    }

    private int getInorderIndex(int value) {
        for (int i = 0; i < this.inorder.length; i++) {
            if (this.inorder[i] == value) {
                return i;
            }
        }
        return -1;
    }
    private int getPreorderIndex(int value) {
        for (int i = 0; i < this.preorder.length; i++) {
            if (this.preorder[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end
