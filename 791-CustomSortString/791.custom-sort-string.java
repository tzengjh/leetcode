/*
 * [807] Custom Sort String
 *
 * https://leetcode.com/problems/custom-sort-string/description/
 *
 * algorithms
 * Medium (59.21%)
 * Total Accepted:    12.7K
 * Total Submissions: 21.5K
 * Testcase Example:  '"cba"\n"abcd"'
 *
 * S and T are strings composed of lowercase letters. In S, no letter occurs
 * more than once.
 * 
 * S was sorted in some custom order previously. We want to permute the
 * characters of T so that they match the order that S was sorted. More
 * specifically, if x occurs before y in S, then x should occur before y in the
 * returned string.
 * 
 * Return any permutation of T (as a string) that satisfies this property.
 * 
 * 
 * Example :
 * Input: 
 * S = "cba"
 * T = "abcd"
 * Output: "cbad"
 * Explanation: 
 * "a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b",
 * and "a". 
 * Since "d" does not appear in S, it can be at any position in T. "dcba",
 * "cdba", "cbda" are also valid outputs.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * S has length at most 26, and no character is repeated in S.
 * T has length at most 200.
 * S and T consist of lowercase letters only.
 * 
 * 
 */
class Solution {
    public String customSortString(String S, String T) {
	if(S == null || S.length() == 0 || T == null) return new String(T);
	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	for(int i = 0; i < T.length(); i++){
		char c = T.charAt(i);
		if(map.containsKey(c))
			map.put(c, map.get(c) + 1);
		else
			map.put(c, 1);
	}
	StringBuilder sb = new StringBuilder();
	for(int i = 0; i < S.length(); i++){
		char c = S.charAt(i);
		if(map.containsKey(c)){
			int num = map.get(c);
			map.remove(c);
			for(int j = 0; j < num; j++)
				sb.append(c);
		}
	}
	
	for(Map.Entry<Character, Integer> entry: map.entrySet()){
		int num = entry.getValue();
		for(int i = 0; i < num; i++)
			sb.append(entry.getKey());
	}
	return sb.toString();

    }
}
