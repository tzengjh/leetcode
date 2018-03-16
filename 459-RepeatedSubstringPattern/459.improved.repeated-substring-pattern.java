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
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if(s == null || s.length() <= 1)
        	return false;
        
        for(int i = s.length() / 2; i > 0 ; i --){ // start from s.length() / 2 is faster
            if(s.length() % i == 0){
                String sub = s.substring(0, i);
                int times = s.length() / i;
                StringBuilder sb = new StringBuilder();  // StringBuilder is faster than temp += sub
                for(int j = 0; j < times; j ++)
                    sb.append(sub);
                if(sb.toString().equals(s))
                    return true;
            }
        }
        return false;
    }
}
