/*
 * [686] Repeated String Match
 *
 * https://leetcode.com/problems/repeated-string-match/description/
 *
 * algorithms
 * Easy (32.58%)
 * Total Accepted:    23.4K
 * Total Submissions: 71.6K
 * Testcase Example:  '"abcd"\n"cdabcdab"'
 *
 * Given two strings A and B, find the minimum number of times A has to be
 * repeated such that B is a substring of it. If no such solution, return -1.
 * 
 * 
 * For example, with A = "abcd" and B = "cdabcdab". 
 * 
 * 
 * Return 3, because by repeating A three times (“abcdabcdabcd”), B is a
 * substring of it; and B is not a substring of A repeated two times
 * ("abcdabcd").
 * 
 * 
 * Note:
 * The length of A and B will be between 1 and 10000.
 * 
 */
class Solution {
    public int repeatedStringMatch(String A, String B) {
        if(A == null || B == null)
        	throw new IllegalArgumentException();
        int max_repeat = 1;
        if(A.length() >= B.length())
        	max_repeat = 2;
        else
        	max_repeat = B.length() / A.length() + 2;
        
        String ta = "";
        for(int i = 1; i <= max_repeat; i ++){
        	ta += A;
        	if(ta.contains(B))
        		return i;
        }
        return -1;
    }
}
