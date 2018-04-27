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
        char[] cs = s.toCharArray();
        reverse(cs, 0, cs.length - 1);
        reverseWords(cs);
        return trimStr(cs);
    }

    private void reverse(char[] cs, int lo, int hi){
        if(cs == null || cs.length <= 1 || lo >= hi) return;
        while(lo < hi){
            cs[lo] = (char)(cs[lo]^cs[hi]);
            cs[hi] = (char)(cs[lo]^cs[hi]);
            cs[lo] = (char)(cs[lo]^cs[hi]);
            lo++;
            hi--;
        }
    }

    private void reverseWords(char[] cs){
        if(cs == null) return;
        int i = 0, j = 0;
        int n = cs.length;
        while(i < n){
            while(i < j || (i < n && cs[i] == ' ')) i++;
            while(j < i || (j < n && cs[j] != ' ')) j++;
            reverse(cs, i, j-1);
        }
    }

    private String trimStr(char[] cs){
        if(cs == null) return null;
        int i = 0, j = 0;
        int n = cs.length;
        while(j < n){
            while(j < n && cs[j] == ' ') j++;
            while(j < n && cs[j] != ' ') cs[i++] = cs[j++];
            while(j < n && cs[j] == ' ') j++;                      // Skip spaces
            if(j < n) cs[i++] = ' ';                               // Keep only one space
        }
        return new String(cs).substring(0, i);
    }
}
