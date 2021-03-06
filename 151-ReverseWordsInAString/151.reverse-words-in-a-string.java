/*
 * [151] Reverse Words in a String
 *
 * https://leetcode.com/problems/reverse-words-in-a-string/description/
 *
 * algorithms
 * Medium (15.63%)
 * Total Accepted:    196K
 * Total Submissions: 1.3M
 * Testcase Example:  '""'
 *
 *
 * Given an input string, reverse the string word by word.
 *
 *
 *
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 *
 *
 *
 * Update (2015-02-12):
 * For C programmers: Try to solve it in-place in O(1) space.
 *
 *
 * click to show clarification.
 *
 * Clarification:
 *
 *
 *
 * What constitutes a word?
 * A sequence of non-space characters constitutes a word.
 * Could the input string contain leading or trailing spaces?
 * Yes. However, your reversed string should not contain leading or trailing
 * spaces.
 * How about multiple spaces between two words?
 * Reduce them to a single space in the reversed string.
 *
 *
 *
 */
public class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return s;
        StringBuilder sb = new StringBuilder();
        String[] subs = s.trim().split("\\s+");
        int n = subs.length;
        for(int i = n - 1; i >= 0; i--){
            if(subs[i].length() > 0){
                sb.append(subs[i]);
                if(i != 0)
                    sb.append(" ");
            }
        }
        return sb.toString();
    }
}
