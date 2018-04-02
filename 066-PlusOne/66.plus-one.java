/*
 * [66] Plus One
 *
 * https://leetcode.com/problems/plus-one/description/
 *
 * algorithms
 * Easy (39.71%)
 * Total Accepted:    232.9K
 * Total Submissions: 586.5K
 * Testcase Example:  '[0]'
 *
 * Given a non-negative integer represented as a non-empty array of digits,
 * plus one to the integer.
 * 
 * You may assume the integer do not contain any leading zero, except the
 * number 0 itself.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list.
 */
class Solution {
    public int[] plusOne(int[] digits) {
        // int sum = 1;
        // for(int i = digits.length - 1; i >= 0; i--){
        // 	sum += digits[i];
        // 	digits[i] = sum % 10;
        // 	sum /= 10;
        // }
        // if(sum == 0)
        // 	return digits;
        // int[] result = new int[digits.length + 1];
        // result[0] = sum;
        // for(int i = 0; i < digits.length; i++){
        // 	result[i + 1] = digits[i];
        // }
        // return result;
        
        
        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        
        int[] newNumber = new int [n+1];
        newNumber[0] = 1;
        
        return newNumber;
    }
}
