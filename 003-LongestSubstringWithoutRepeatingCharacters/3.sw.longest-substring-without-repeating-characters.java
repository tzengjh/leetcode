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
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < N; j++) {
            if (map.containsKey(s.charAt(j))) {
                if(map.get(s.charAt(j)) > i)
                    i = map.get(s.charAt(j));
            }
            if(j - i + 1 > maxLen)
                maxLen = j - i + 1;
            map.put(s.charAt(j), j + 1);
        }
        return maxLen;
    }
}
