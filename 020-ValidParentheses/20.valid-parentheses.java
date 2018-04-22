/*
 * [20] Valid Parentheses
 *
 * https://leetcode.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (34.02%)
 * Total Accepted:    327.4K
 * Total Submissions: 962.3K
 * Testcase Example:  '"()"'
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 *
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 *
 * Input: "()"
 * Output: true
 *
 *
 * Example 2:
 *
 *
 * Input: "()[]{}"
 * Output: true
 *
 *
 * Example 3:
 *
 *
 * Input: "(]"
 * Output: false
 *
 *
 * Example 4:
 *
 *
 * Input: "([)]"
 * Output: false
 *
 *
 * Example 5:
 *
 *
 * Input: "{[]}"
 * Output: true
 *
 *
 */
class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) return true;
        LinkedList<Character> stack = new LinkedList<Character>();
        int l = s.length();
        for(int i = 0; i < l; i++){
            char c = s.charAt(i);
            if(c == '{' || c == '[' || c == '(')
                stack.push(c);
            else if(c == '}' && stack.peek() != null && stack.peek() == '{')
                stack.pop();
            else if(c == ']' && stack.peek() != null && stack.peek() == '[')
                stack.pop();
            else if(c == ')' && stack.peek() != null && stack.peek() == '(')
                stack.pop();
            else
                return false;
        }
        if(stack.isEmpty()) return true;
        return false;
    }
}
