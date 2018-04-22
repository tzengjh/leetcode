/*
 * [110] Balanced Binary Tree
 *
 * https://leetcode.com/problems/balanced-binary-tree/description/
 *
 * algorithms
 * Easy (38.48%)
 * Total Accepted:    224.1K
 * Total Submissions: 582.5K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 *
 * a binary tree in which the depth of the two subtrees of every node never
 * differ by more than 1.
 *
 *
 * Example 1:
 *
 * Given the following tree [3,9,20,null,null,15,7]:
 *
 *
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 *
 * Return true.
 *
 * Example 2:
 *
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 *
 *
 * ⁠      1
 * ⁠     / \
 * ⁠    2   2
 * ⁠   / \
 * ⁠  3   3
 * ⁠ / \
 * ⁠4   4
 *
 *
 * Return false.
 *
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfsDepth(root) != -1;
    }

    private int dfsDepth(TreeNode root){
        if(root == null) return 0;
        int left = dfsDepth(root.left);
        if(left == -1) return -1;
        int right = dfsDepth(root.right);
        if(right == -1) return -1;
        int del = left > right ? left - right:right - left;
        if(del > 1) return -1;
        return left > right ? left + 1:right + 1;
    }
}
