/*
 * [738] Monotone Increasing Digits
 *
 * https://leetcode.com/problems/monotone-increasing-digits/description/
 *
 * algorithms
 * Medium (41.28%)
 * Total Accepted:    9.1K
 * Total Submissions: 22.1K
 * Testcase Example:  '10'
 *
 * 
 * Given a non-negative integer N, find the largest number that is less than or
 * equal to N with monotone increasing digits.
 * 
 * (Recall that an integer has monotone increasing digits if and only if each
 * pair of adjacent digits x and y satisfy x .)
 * 
 * 
 * Example 1:
 * 
 * Input: N = 10
 * Output: 9
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: N = 1234
 * Output: 1234
 * 
 * 
 * 
 * Example 3:
 * 
 * Input: N = 332
 * Output: 299
 * 
 * 
 * 
 * Note:
 * N is an integer in the range [0, 10^9].
 * 
 */
class Solution {
    public int monotoneIncreasingDigits(int N) {
	char[] arr = String.valueOf(N).toCharArray();
	int index = arr.length;
	for(int i = arr.length - 1; i > 0; i--){
		if(arr[i] < arr[i - 1]){
			arr[i - 1] -= 1;
			index = i;
		}
	}

	for(int j = index; j < arr.length; j++){
		arr[j] = '9';
	}
	return Integer.parseInt(new String(arr));
    }
}
