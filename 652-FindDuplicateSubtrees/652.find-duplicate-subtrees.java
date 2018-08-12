/*
 * [652] Find Duplicate Subtrees
 *
 * https://leetcode.com/problems/find-duplicate-subtrees/description/
 *
 * algorithms
 * Medium (38.43%)
 * Total Accepted:    18.3K
 * Total Submissions: 47.7K
 * Testcase Example:  '[1,2,3,4,null,2,4,null,null,4]'
 *
 * Given a binary tree, return all duplicate subtrees. For each kind of
 * duplicate subtrees, you only need to return the root node of any one of
 * them.
 * 
 * Two trees are duplicate if they have the same structure with same node
 * values.
 * 
 * Example 1: 
 * 
 * 
 * ⁠       1
 * ⁠      / \
 * ⁠     2   3
 * ⁠    /   / \
 * ⁠   4   2   4
 * ⁠      /
 * ⁠     4
 * 
 * 
 * The following are two duplicate subtrees:
 * 
 * 
 * ⁠     2
 * ⁠    /
 * ⁠   4
 * 
 * 
 * and
 * 
 * 
 * ⁠   4
 * 
 * Therefore, you need to return above trees' root in the form of a list.
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
    private Map<String, Integer> map;
    private List<TreeNode> nodes;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
	map = new HashMap<String, Integer>();
	nodes = new ArrayList<TreeNode>();
	deepfs(root);
	return nodes;
    }

    private String deepfs(TreeNode root){
	if(root == null) return "#";
	String des = root.val + "," + deepfs(root.left) + "," + deepfs(root.right);
	map.put(des, map.getOrDefault(des, 0) + 1);
	if(map.get(des) == 2)
		nodes.add(root);
	return des;
    }
}
