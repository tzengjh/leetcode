/*
 * [646] Maximum Length of Pair Chain
 *
 * https://leetcode.com/problems/maximum-length-of-pair-chain/description/
 *
 * algorithms
 * Medium (47.53%)
 * Total Accepted:    24K
 * Total Submissions: 50.6K
 * Testcase Example:  '[[1,2], [2,3], [3,4]]'
 *
 * 
 * You are given n pairs of numbers. In every pair, the first number is always
 * smaller than the second number.
 * 
 * 
 * 
 * Now, we define a pair (c, d) can follow another pair (a, b) if and only if b
 * < c. Chain of pairs can be formed in this fashion. 
 * 
 * 
 * 
 * Given a set of pairs, find the length longest chain which can be formed. You
 * needn't use up all the given pairs. You can select pairs in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [[1,2], [2,3], [3,4]]
 * Output: 2
 * Explanation: The longest chain is [1,2] -> [3,4]
 * 
 * 
 * 
 * Note:
 * 
 * The number of given pairs will be in the range [1, 1000].
 * 
 * 
 */
class Solution {
    public int findLongestChain(int[][] pairs) {
	if(pairs == null || pairs.length == 0 || pairs[0] == null || pairs[0].length == 0) return 0;
	Arrays.sort(pairs, new Comparator<int[]>() {
		public int compare(int[] a, int[] b){
			return a[1] - b[1];
		}
       	});
	int curr = Integer.MIN_VALUE;
	int maxLen = 0;
	for(int[] pair: pairs){
		if(curr < pair[0]){
			curr = pair[1];
			maxLen ++;
		}
	}
	return maxLen;
    }
}
