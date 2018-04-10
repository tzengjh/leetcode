/*
 * [139] Word Break
 *
 * https://leetcode.com/problems/word-break/description/
 *
 * algorithms
 * Medium (31.49%)
 * Total Accepted:    206.3K
 * Total Submissions: 655.3K
 * Testcase Example:  '"leetcode"\n["leet","code"]'
 *
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, determine if s can be segmented into a space-separated
 * sequence of one or more dictionary words. You may assume the dictionary does
 * not contain duplicate words.
 *
 *
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 *
 *
 *
 * Return true because "leetcode" can be segmented as "leet code".
 *
 *
 *
 * UPDATE (2017/1/4):
 * The wordDict parameter had been changed to a list of strings (instead of a
 * set of strings). Please reload the code definition to get the latest
 * changes.
 *
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) return false;
        boolean[] sub = new boolean[s.length() + 1];
        sub[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(sub[j] && wordDict.contains(s.substring(j,i))){
                    sub[i] = true;
                    break;
                }
            }
        }
        return sub[s.length()];
    }
}
