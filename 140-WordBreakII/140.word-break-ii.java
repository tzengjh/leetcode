/*
 * [140] Word Break II
 *
 * https://leetcode.com/problems/word-break-ii/description/
 *
 * algorithms
 * Hard (24.51%)
 * Total Accepted:    112.1K
 * Total Submissions: 457.5K
 * Testcase Example:  '"catsanddog"\n["cat","cats","and","sand","dog"]'
 *
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, add spaces in s to construct a sentence where each word is
 * a valid dictionary word. You may assume the dictionary does not contain
 * duplicate words.
 *
 *
 *
 * Return all such possible sentences.
 *
 *
 *
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 *
 *
 *
 * A solution is ["cats and dog", "cat sand dog"].
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
    private final HashMap<String, List<String>> map = new HashMap<String, List<String>>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> list = new ArrayList<String>();
        if(s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) return list;
        if(map.containsKey(s)) return map.get(s);
        if(wordDict.contains(s)) list.add(s);
        for(int i = s.length(); i > 0; i--){
            if(wordDict.contains(s.substring(0,i))){
                List<String> rights = wordBreak(s.substring(i), wordDict);
                for(String right: rights){
                    list.add(s.substring(0,i) + " " + right);
                }
            }
        }
        map.put(s, list);
        return list;
    }

}
