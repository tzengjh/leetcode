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
	Map<String, Boolean> map = new HashMap<String, Boolean>();
	int len = s.length();
	int count = 0;
	for(int i = 0; i < len; i++)
		for(int j = i; j < len; j++)
			if(isPalindromicString(s, i, j, map))
				count ++;
        return count;
    }

    private boolean isPalindromicString(String s, int start, int end, Map<String, Boolean> map){
	String key = start + "_" + end;
	if(map.containsKey(key)) return map.get(key);
	if(start > end) return true;
	if(s.charAt(start) == s.charAt(end) && isPalindromicString(s, start + 1, end - 1, map)){
		map.put(key, true);
		return true;
	}
	return false;
    }
}
