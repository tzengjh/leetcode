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
    private int tag;
    private Map<String, Integer> map;
    private Map<Integer, Integer> count;
    private List<TreeNode> nodes;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
	tag = 1;
	map = new HashMap<String, Integer>();
	count = new HashMap<Integer, Integer>();
	nodes = new ArrayList<TreeNode>();
	deepfs(root);
	return nodes;
    }

    private int deepfs(TreeNode root){
	if(root == null) return 0;
	// reduce the complexity of creating string
	String des = root.val + "," + deepfs(root.left) + "," + deepfs(root.right);
	int uid = map.computeIfAbsent(des, x->tag++);
	count.put(uid, count.getOrDefault(uid, 0) + 1);
	if(count.get(uid) == 2)
		nodes.add(root);
	return uid;
    }
}
