/*
 * [606] Construct String from Binary Tree
 *
 * https://leetcode.com/problems/construct-string-from-binary-tree/description/
 *
 * algorithms
 * Easy (49.69%)
 * Total Accepted:    31.3K
 * Total Submissions: 63K
 * Testcase Example:  '[1,2,3,4]'
 *
 * You need to construct a string consists of parenthesis and integers from a
 * binary tree with the preorder traversing way.
 * 
 * The null node needs to be represented by empty parenthesis pair "()". And
 * you need to omit all the empty parenthesis pairs that don't affect the
 * one-to-one mapping relationship between the string and the original binary
 * tree.
 * 
 * Example 1:
 * 
 * Input: Binary tree: [1,2,3,4]
 * ⁠      1
 * ⁠    /   \
 * ⁠   2     3
 * ⁠  /    
 * ⁠ 4     
 * 
 * Output: "1(2(4))(3)"
 * Explanation: Originallay it needs to be "1(2(4)())(3()())", but you need to
 * omit all the unnecessary empty parenthesis pairs. And it will be
 * "1(2(4))(3)".
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: Binary tree: [1,2,3,null,4]
 * ⁠      1
 * ⁠    /   \
 * ⁠   2     3
 * ⁠    \  
 * ⁠     4 
 * 
 * Output: "1(2()(4))(3)"
 * Explanation: Almost the same as the first example, except we can't omit the
 * first parenthesis pair to break the one-to-one mapping relationship between
 * the input and the output.
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
    public String tree2str(TreeNode t) {
        if(t == null) return "";
        Stack<TreeNode> st = new Stack<TreeNode>();
        Set<TreeNode> visited = new HashSet<TreeNode>();
        StringBuilder sb = new StringBuilder();
        TreeNode node = t;
        st.push(node);
        while(!st.isEmpty()){
            node = st.peek();
            if(visited.contains(node)){
                sb.append(")");
                st.pop();
            }else{
                visited.add(node);
                sb.append("(" + node.val);
                if(node.left == null && node.right == null)  // omit
                    continue;
                if(node.left == null && node.right != null){
                    sb.append("()");
                    st.push(node.right);
                }
                if(node.left != null && node.right == null){ // can join together
                    st.push(node.left);
                }
                if(node.left != null && node.right != null){
                    st.push(node.right);
                    st.push(node.left);
                }
            }
        }
        return sb.toString().substring(1, sb.length() - 1);
    }
}

// public class Solution {
//     public String tree2str(TreeNode t) {
//         if (t == null)
//             return "";
//         Stack < TreeNode > stack = new Stack < > ();
//         stack.push(t);
//         Set < TreeNode > visited = new HashSet < > ();
//         StringBuilder s = new StringBuilder();
//         while (!stack.isEmpty()) {
//             t = stack.peek();
//             if (visited.contains(t)) {
//                 stack.pop();
//                 s.append(")");
//             } else {
//                 visited.add(t);
//                 s.append("(" + t.val);
//                 if (t.left == null && t.right != null)
//                     s.append("()");
//                 if (t.right != null)
//                     stack.push(t.right);
//                 if (t.left != null)
//                     stack.push(t.left);
//             }
//         }
//         return s.substring(1, s.length() - 1);
//     }
// }
