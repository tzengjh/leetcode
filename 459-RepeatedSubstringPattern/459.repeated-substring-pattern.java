/*
 * [459] Repeated Substring Pattern
 *
 * https://leetcode.com/problems/repeated-substring-pattern/description/
 *
 * algorithms
 * Easy (38.15%)
 * Total Accepted:    49.3K
 * Total Submissions: 129.3K
 * Testcase Example:  '"abab"'
 *
 * Given a non-empty string check if it can be constructed by taking a
 * substring of it and appending multiple copies of the substring together.
 * You may assume the given string consists of lowercase English letters only
 * and its length  will not exceed 10000. 
 * 
 * Example 1:
 * 
 * Input: "abab"
 * 
 * Output: True
 * 
 * Explanation: It's the substring "ab" twice.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: "aba"
 * 
 * Output: False
 * 
 * 
 * 
 * Example 3:
 * 
 * Input: "abcabcabcabc"
 * 
 * Output: True
 * 
 * Explanation: It's the substring "abc" four times. (And the substring
 * "abcabc" twice.)
 * 
 * 
 */
import java.lang.Integer;
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if(s == null || s.length() == 0)
        	return false;
        int[] divs = divisors(s.length());
        if(divs == null)
        	return false;
        for(int i = 0; i < divs.length; i ++){
        	String temp = s.substring(0, divs[i]);
        	int times = s.length() / divs[i];
        	String sub = "";
        	for(int j = 0; j < times; j ++)
        		sub += temp;
        	if(sub.equals(s))
        		return true;
        }
        return false;
    }

    private int[] divisors(int n){
    	if(n <= 1)
    		return null;
    	List<Integer> li = new ArrayList<Integer>();
    	for(int i = 1; i * i <= n; i ++){
    		if(n % i == 0){
    			li.add(i);
    			if(i * i != n && i != 1)
    				li.add(n / i);
    		}
    	}
    	int[] arr = new int[li.size()];
    	for(int i = 0; i < arr.length; i++)
    		arr[i] = li.get(i);
    	return arr;
    }
}
