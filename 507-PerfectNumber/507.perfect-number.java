/*
 * [507] Perfect Number
 *
 * https://leetcode.com/problems/perfect-number/description/
 *
 * algorithms
 * Easy (32.59%)
 * Total Accepted:    21.4K
 * Total Submissions: 65.8K
 * Testcase Example:  '28'
 *
 * We define the Perfect Number is a positive integer that is equal to the sum
 * of all its positive divisors except itself. 
 * 
 * Now, given an integer n, write a function that returns true when it is a
 * perfect number and false when it is not.
 * 
 * 
 * Example:
 * 
 * Input: 28
 * Output: True
 * Explanation: 28 = 1 + 2 + 4 + 7 + 14
 * 
 * 
 * 
 * Note:
 * The input number n will not exceed 100,000,000. (1e8)
 * 
 */
class Solution {
    public boolean checkPerfectNumber(int num) {
    	if(num <= 0)
    		return false;
        int beg = 1, end = num;
        int sum = 0;
        while(beg < end){
        	if(num % beg == 0){
        		end = num / beg;
        		if(beg != num)
        			sum += beg;
        		if(end != num && beg != end)
        			sum += end;
        	}
        	beg ++;
        }
        if(sum == num)
        	return true;
        return false;
    }
}
