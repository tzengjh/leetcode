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
    public static int findNthDigit(int n){
        int digit = 1;//digit level, we start at one digit.
        long counts = 9;//the number counts of current digit level,we start at one digit,there are 9 numbers(1-9)which is at one digit.
        /**
         * number [1-9] (there are 9 numbers)is of one digit,number[10-99](there are 90 numbers) is
         * of two digits,number[100-999](there are 900 numbers) is of three digits,so first we should
         * find what level(i mean which digits(one digit,two digit or so on)  by level) the nth digit locate,
         * once we find the digit level, we achieve half the process,
         */
        /**
         *if n - digit * counts > 0,it means the nth digit is not at the current digit level,we should
         * increase digit level to pass more number
         */

        while (n - digit * counts > 0) {
            //every time we pass the number at current digit level
            n -= digit * counts;

            digit++;
            //counts are grow as follows,9,90,900,9000.....since the counts maybe overflow so i use long type
            counts *= 10;
        }
        //after loop,the n means nth digits from the current baseNumber

        //the base number is 1,10,100,1000,10000 and so on.
        int baseNumber = (int)Math.pow(10, digit - 1);
        //find the number where nth digit locate
        int number  = (n - 1) / digit + baseNumber;
        //find the digit where nth digit locate at the number above
        int mod = (n - 1) % digit;
        return String.valueOf(number).charAt(mod) - '0';
    }
}
