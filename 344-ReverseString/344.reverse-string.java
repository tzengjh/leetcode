/*
 * [344] Reverse String
 *
 * https://leetcode.com/problems/reverse-string/description/
 *
 * algorithms
 * Easy (60.38%)
 * Total Accepted:    241K
 * Total Submissions: 399.1K
 * Testcase Example:  '"hello"'
 *
 * Write a function that takes a string as input and returns the string
 * reversed.
 *
 *
 * Example:
 * Given s = "hello", return "olleh".
 *
 */
class Solution {
    public String reverseString(String s) {
        if(s == null) return s;
        return new StringBuilder(s).reverse().toString();
    }
}
