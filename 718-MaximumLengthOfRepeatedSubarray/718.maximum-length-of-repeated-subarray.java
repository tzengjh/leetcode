/*
 * [718] Maximum Length of Repeated Subarray
 *
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/
 *
 * algorithms
 * Medium (41.89%)
 * Total Accepted:    16.8K
 * Total Submissions: 40.1K
 * Testcase Example:  '[1,2,3,2,1]\n[3,2,1,4,7]'
 *
 * Given two integer arrays A and B, return the maximum length of an subarray
 * that appears in both arrays.
 * 
 * Example 1:
 * 
 * Input:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * Output: 3
 * Explanation: 
 * The repeated subarray with maximum length is [3, 2, 1].
 * 
 * 
 * 
 * Note:
 * 
 * 1 
 * 0 
 * 
 * 
 */
class Solution {
    public int findLength(int[] A, int[] B) {
	if(A == null || B == null) return 0;
	int lenA = A.length;
	int lenB = B.length;
	int[][] lens = new int[lenA + 1][lenB + 1];
	int maxLen = 0;
	for(int i = 1; i <= lenA; i++)
		for(int j = 1; j <= lenB; j++)
			if(A[i - 1] == B[j - 1]){
				lens[i][j] = lens[i-1][j-1] + 1;
				if(lens[i][j] > maxLen)
					maxLen = lens[i][j];
			}
	return maxLen;
    }
}
