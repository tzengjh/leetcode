/*
 * [557] Reverse Words in a String III
 *
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
 *
 * algorithms
 * Easy (60.15%)
 * Total Accepted:    68.9K
 * Total Submissions: 114.5K
 * Testcase Example:  '"Let\'s take LeetCode contest"'
 *
 * Given a string, you need to reverse the order of characters in each word
 * within a sentence while still preserving whitespace and initial word order.
 *
 * Example 1:
 *
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 *
 *
 *
 * Note:
 * In the string, each word is separated by single space and there will not be
 * any extra space in the string.
 *
 */
class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return s;
        int n = s.length();
        char[] cs = s.toCharArray();
        int lo = 0, hi = 0;
        for(int i = 0; i <= n; i++){
            if(i == n || cs[i] == ' '){
                hi = i - 1;
                while(lo < hi){
                    cs[lo] = (char)(cs[lo]^cs[hi]);
                    cs[hi] = (char)(cs[lo]^cs[hi]);
                    cs[lo] = (char)(cs[lo]^cs[hi]);
                    lo++;
                    hi--;
                }
                lo = i+1;
            }
        }
        return new String(cs);
    }
}
