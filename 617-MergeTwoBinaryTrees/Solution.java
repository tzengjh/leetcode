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
	private class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}
	}
	
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if(t1 == null && t2 == null)
			return null;
		TreeNode tn;
		if(t1 == null){
			tn = new TreeNode(t2.val);
            tn.left = mergeTrees(null, t2.left);
            tn.right = mergeTrees(null, t2.right);
        }else if(t2 == null){
            tn = new TreeNode(t1.val);
            tn.left = mergeTrees(t1.left, null);
            tn.right = mergeTrees(t1.right, null);
        }else{
            tn = new TreeNode(t1.val + t2.val);
            tn.left = mergeTrees(t1.left, t2.left);
            tn.right = mergeTrees(t1.right, t2.right);
        }
        return tn;
    }
	/*
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2){
		if(t2 == null)
			return t1;
		if(t1 == null)
			return t2;
		t1.val += t2.val;
		t1.left = mergeTrees(t1.left, t2.left);
		t1.right = mergeTrees(t1.right, t2.right);
		return t1;
	}*/
}
