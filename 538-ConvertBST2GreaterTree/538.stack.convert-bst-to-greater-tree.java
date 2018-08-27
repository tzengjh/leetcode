import java.util.Stack;

/*
 * [538] Convert BST to Greater Tree
 *
 * https://leetcode.com/problems/convert-bst-to-greater-tree/description/
 *
 * algorithms
 * Easy (48.85%)
 * Total Accepted:    52.5K
 * Total Submissions: 107.4K
 * Testcase Example:  '[5,2,13]'
 *
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that
 * every key of the original BST is changed to the original key plus sum of all
 * keys greater than the original key in BST.
 * 
 * 
 * Example:
 * 
 * Input: The root of a Binary Search Tree like this:
 * ⁠             5
 * ⁠           /   \
 * ⁠          2     13
 * 
 * Output: The root of a Greater Tree like this:
 * ⁠            18
 * ⁠           /   \
 * ⁠         20     13
 * 
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
    public TreeNode convertBST(TreeNode root) {
	int sum = 0;
	TreeNode node = root;
	Stack<TreeNode> stack = new Stack<TreeNode>();

	while (!stack.isEmpty() || node != null) {
		/* push all nodes up to (and including) this subtree's maximum on
		 *              * the stack. */
		while (node != null) {
			stack.add(node);
			node = node.right;

		}

		node = stack.pop();
		sum += node.val;
		node.val = sum;

		/* all nodes with values between the current and its parent lie in
		 *              * the left subtree. */
		node = node.left;
	}
	return root;
    }
}
