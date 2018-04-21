/*
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (24.71%)
 * Total Accepted:    475.7K
 * Total Submissions: 1.9M
 * Testcase Example:  '"abcabcbb"'
 *
 * Given a string, find the length of the longest substring without repeating
 * characters.
 *
 * Examples:
 *
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 *
 * Given "bbbbb", the answer is "b", with the length of 1.
 *
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the
 * answer must be a substring, "pwke" is a subsequence and not a substring.
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        int N = s.length();
        int[] d = new int[N];
        d[0] = 1;
        for(int i = 1; i < N; i++){
            if(s.substring(i - d[i-1], i).contains(s.substring(i, i+1)))
                d[i] = i - s.substring(0, i).lastIndexOf(s.substring(i, i+1));
            else
                d[i] = d[i-1] + 1;
        }
        int max = 1;
        for(int i = 1; i < N; i++)
            if(d[i] > max)
                max = d[i];
        return max;
    }
}
