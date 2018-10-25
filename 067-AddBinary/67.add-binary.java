/*
 * [67] Add Binary
 *
 * https://leetcode.com/problems/add-binary/description/
 *
 * algorithms
 * Easy (36.14%)
 * Total Accepted:    241.2K
 * Total Submissions: 667.4K
 * Testcase Example:  '"11"\n"1"'
 *
 * Given two binary strings, return their sum (also a binary string).
 * 
 * The input strings are both non-empty and contains only characters 1 or 0.
 * 
 * Example 1:
 * 
 * 
 * Input: a = "11", b = "1"
 * Output: "100"
 * 
 * Example 2:
 * 
 * 
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * 
 */
class Solution {

	public String addBinary(String a, String b) {
		if(a == null && b == null)
			throw new IllegalArgumentException("Both of the Strings are null !");
		if(a == null)
			return b;
		if(b == null)
			return a;

		String c = "";
		char t = '0';
		int la = a.length();
		int lb = b.length();
		for(int i = 1; i <= la || i <= lb; i ++){
			char ta = i <= la ? a.charAt(la - i) : '0';
			char tb = i <= lb ? b.charAt(lb - i) : '0';
			if(ta == '0' && tb == '0'){
				c = t + c;
				t = '0';
			}else if(ta == '1' && tb == '1'){
				c = t + c;
				t = '1';
			}else{
				c = t =='1'?'0' + c : '1' + c;               
			}
		}
		if(t == '1')
			c = t + c;
		return c;
	}
}
