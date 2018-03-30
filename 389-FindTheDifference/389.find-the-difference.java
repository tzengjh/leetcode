/*
 * [389] Find the Difference
 *
 * https://leetcode.com/problems/find-the-difference/description/
 *
 * algorithms
 * Easy (51.28%)
 * Total Accepted:    100.6K
 * Total Submissions: 196.2K
 * Testcase Example:  '"abcd"\n"abcde"'
 *
 * 
 * Given two strings s and t which consist of only lowercase letters.
 * 
 * String t is generated by random shuffling string s and then add one more
 * letter at a random position.
 * 
 * Find the letter that was added in t.
 * 
 * Example:
 * 
 * Input:
 * s = "abcd"
 * t = "abcde"
 * 
 * Output:
 * e
 * 
 * Explanation:
 * 'e' is the letter that was added.
 * 
 */
import java.util.HashMap;

class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> smap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> tmap = new HashMap<Character, Integer>();
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        for(int i = 0; i < sc.length; i++)
        	if(smap.containsKey(sc[i]))
        		smap.put(sc[i], smap.get(sc[i]) + 1);
        	else
        		smap.put(sc[i], 1);

        for(int i = 0; i < tc.length; i++)
        	if(tmap.containsKey(tc[i]))
        		tmap.put(tc[i], tmap.get(tc[i]) + 1);
        	else
        		tmap.put(tc[i], 1);

        for(Character key: tmap.keySet())
        	if(smap.get(key) == null || smap.get(key) != tmap.get(key))
        		return key;
        return '\0';
    }
}
