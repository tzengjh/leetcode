/*
 * [680] Valid Palindrome II
 *
 * https://leetcode.com/problems/valid-palindrome-ii/description/
 *
 * algorithms
 * Easy (32.23%)
 * Total Accepted:    27.2K
 * Total Submissions: 84.3K
 * Testcase Example:  '"aba"'
 *
 *
 * Given a non-empty string s, you may delete at most one character.  Judge
 * whether you can make it a palindrome.
 *
 *
 * Example 1:
 *
 * Input: "aba"
 * Output: True
 *
 *
 *
 * Example 2:
 *
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 *
 *
 *
 * Note:
 *
 * The string will only contain lowercase characters a-z.
 * The maximum length of the string is 50000.
 *
 *
 */
class Solution {
    public boolean validPalindrome(String s) {
        if(s == null) return false;
        int i = 0, j = s.length() - 1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) break;
            i++;
            j--;
        }
        if(i >= j) return true;
        int k = i + 1, p = j;
        while(k < p){
            if(s.charAt(k) != s.charAt(p)) break;
            k++;
            p--;
        }
        if(k >= p) return true;
        k = i;
        p = j - 1;
        while(k < p){
            if(s.charAt(k) != s.charAt(p)) break;
            k++;
            p--;
        }
        if(k >= p) return true;
        return false;
    }
}
