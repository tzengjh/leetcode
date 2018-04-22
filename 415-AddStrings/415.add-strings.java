/*
 * [415] Add Strings
 *
 * https://leetcode.com/problems/add-strings/description/
 *
 * algorithms
 * Easy (41.72%)
 * Total Accepted:    56K
 * Total Submissions: 134.3K
 * Testcase Example:  '"0"\n"0"'
 *
 * Given two non-negative integers num1 and num2 represented as string, return
 * the sum of num1 and num2.
 *
 * Note:
 *
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to
 * integer directly.
 *
 *
 */
class Solution {
    public String addStrings(String num1, String num2) {
        if(num1 == null || num1.length() == 0) return num2;
        if(num2 == null || num2.length() == 0) return num1;
        int l1 = num1.length(), l2 = num2.length();
        StringBuilder sb = new StringBuilder();
        int t = 0;
        for(int i = 0; i < l1 || i < l2; i++){
            char c1 = i < l1 ? num1.charAt(l1 - 1 - i):'0';
            char c2 = i < l2 ? num2.charAt(l2 - 1 - i):'0';
            t = t + (c1 - '0') + (c2 - '0');
            sb.append(t%10);
            t = t / 10;
        }
        if(t != 0)
            sb.append(t);
        return sb.reverse().toString();
    }
}
