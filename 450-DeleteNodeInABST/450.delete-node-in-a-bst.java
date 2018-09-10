/*
 * [450] Delete Node in a BST
 *
 * https://leetcode.com/problems/delete-node-in-a-bst/description/
 *
 * algorithms
 * Medium (37.80%)
 * Total Accepted:    41.1K
 * Total Submissions: 108.7K
 * Testcase Example:  '[5,3,6,2,4,null,7]\n3'
 *
 * Given a root node reference of a BST and a key, delete the node with the
 * given key in the BST. Return the root node reference (possibly updated) of
 * the BST.
 * 
 * Basically, the deletion can be divided into two stages:
 * 
 * Search for a node to remove.
 * If the node is found, delete the node.
 * 
 * 
 * 
 * Note: Time complexity should be O(height of tree).
 * 
 * Example:
 * 
 * root = [5,3,6,2,4,null,7]
 * key = 3
 * 
 * ⁠   5
 * ⁠  / \
 * ⁠ 3   6
 * ⁠/ \   \
 * 2   4   7
 * 
 * Given key to delete is 3. So we find the node with value 3 and delete it.
 * 
 * One valid answer is [5,4,6,2,null,null,7], shown in the following BST.
 * 
 * ⁠   5
 * ⁠  / \
 * ⁠ 4   6
 * ⁠/     \
 * 2       7
 * 
 * Another valid answer is [5,2,6,null,4,null,7].
 * 
 * ⁠   5
 * ⁠  / \
 * ⁠ 2   6
 * ⁠  \   \
 * ⁠   4   7
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
    public TreeNode deleteNode(TreeNode root, int key) {
	if(root == null) return root;
	if(key < root.val)
		root.left = deleteNode(root.left, key);
	else if(key > root.val)
		root.right = deleteNode(root.right, key);
	else{
		if(root.right == null){
			return root.left;
		}
		if(root.left == null){
			return root.right;
		}
		TreeNode temp = new TreeNode(min(root.right).val);
		temp.left = root.left;
		temp.right = deleteMin(root.right);
		return temp;
	}
	return root;
    }

    private TreeNode deleteMin(TreeNode root){
	if(root == null) return root;
	if(root.left == null) return root.right;
	root.left = deleteMin(root.left);
	return root;
    }
    
    private TreeNode min(TreeNode root){
	if(root == null) return root;
	if(root.left == null) return root;
	return min(root.left);
    }
}
