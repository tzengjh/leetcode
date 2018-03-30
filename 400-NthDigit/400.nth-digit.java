/*
 * [400] Nth Digit
 *
 * https://leetcode.com/problems/nth-digit/description/
 *
 * algorithms
 * Easy (30.15%)
 * Total Accepted:    33.5K
 * Total Submissions: 111K
 * Testcase Example:  '3'
 *
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8,
 * 9, 10, 11, ... 
 * 
 * Note:
 * n is positive and will fit within the range of a 32-bit signed integer (n <
 * 231).
 * 
 * 
 * Example 1:
 * 
 * Input:
 * 3
 * 
 * Output:
 * 3
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * 11
 * 
 * Output:
 * 0
 * 
 * Explanation:
 * The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a
 * 0, which is part of the number 10.
 * 
 * 
 */
class Solution {
    public int findNthDigit(int n) {
    	if(n <= 0) return -1;
    	int k = 0;
    	int sum = 0;
    	do{
    		k++;
    		sum += k*9*tens(k-1); // overflow when k==9
    	}while(sum < n);
    	sum -= k*9*tens(k-1); 
    	int num = tens(k - 1) + (n - sum - 1) / k;
    	int x = (n - sum - 1) % k;
    	char c = Integer.toString(num).charAt(x);
    	return c - '0';
    }

    public int tens(int k){
    	if(k < 0) throw new IllegalArgumentException();
    	if(k == 0) return 1;
    	return tens(k - 1) * 10;
    }
}
