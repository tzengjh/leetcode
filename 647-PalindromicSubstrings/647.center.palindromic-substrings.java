/*
 * [647] Palindromic Substrings
 *
 * https://leetcode.com/problems/palindromic-substrings/description/
 *
 * algorithms
 * Medium (54.43%)
 * Total Accepted:    52K
 * Total Submissions: 95.6K
 * Testcase Example:  '"abc"'
 *
 * 
 * Given a string, your task is to count how many palindromic substrings in
 * this string.
 * 
 * 
 * 
 * The substrings with different start indexes or end indexes are counted as
 * different substrings even they consist of same characters. 
 * 
 * 
 * Example 1:
 * 
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * 
 * 
 * 
 * Note:
 * 
 * The input string length won't exceed 1000.
 * 
 * 
 */
class Solution {
    public int countSubstrings(String s) {
	if(s == null || s.length() == 0) return 0;
	int N = s.length();
	int count = 0;
	for(int center = 0; center < 2*N - 1; center ++){
		int left = center / 2;
		int right = left  + center % 2;
		while(left >= 0 && right <= N - 1 && s.charAt(left) == s.charAt(right)){
			count ++;
			left --;
			right ++;
		}
	}
	return count;
    }	
}
