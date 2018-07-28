/*
 * [541] Reverse String II
 *
 * https://leetcode.com/problems/reverse-string-ii/description/
 *
 * algorithms
 * Easy (43.91%)
 * Total Accepted:    37.5K
 * Total Submissions: 85.5K
 * Testcase Example:  '"abcdefg"\n2'
 *
 *
 * Given a string and an integer k, you need to reverse the first k characters
 * for every 2k characters counting from the start of the string. If there are
 * less than k characters left, reverse all of them. If there are less than 2k
 * but greater than or equal to k characters, then reverse the first k
 * characters and left the other as original.
 *
 *
 * Example:
 *
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 *
 *
 *
 * Restrictions:
 *
 * ⁠The string consists of lower English letters only.
 * ⁠Length of the given string and k will in the range [1, 10000]
 *
 */
class Solution {
    public String reverseStr(String s, int k) {
        if(s == null || s.length() <= 1 || k <= 1) return s;
        char[] cs = s.toCharArray();
        int n = s.length();
        int lo = 0, ub = k < n? k:n;
        int hi = 0;
        while(lo < n){
            hi = ub - 1;
            while(lo < hi){
                cs[lo] = (char)(cs[lo] ^ cs[hi]);
                cs[hi] = (char)(cs[lo] ^ cs[hi]);
                cs[lo] = (char)(cs[lo] ^ cs[hi]);
                lo++;
                hi--;
            }
            lo = ub + k;
            ub = ub + 2*k < n? ub + 2*k:n;
        }
        return new String(cs);
    }
}
