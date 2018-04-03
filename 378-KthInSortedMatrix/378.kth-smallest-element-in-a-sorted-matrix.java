/*
 * [378] Kth Smallest Element in a Sorted Matrix
 *
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
 *
 * algorithms
 * Medium (45.47%)
 * Total Accepted:    58K
 * Total Submissions: 127.7K
 * Testcase Example:  '[[1,5,9],[10,11,13],[12,13,15]]\n8'
 *
 * Given a n x n matrix where each of the rows and columns are sorted in
 * ascending order, find the kth smallest element in the matrix.
 * 
 * 
 * Note that it is the kth smallest element in the sorted order, not the kth
 * distinct element.
 * 
 * 
 * Example:
 * 
 * matrix = [
 * ⁠  [ 1,  5,  9],
 * ⁠  [10, 11, 13],
 * ⁠  [12, 13, 15]
 * ],
 * k = 8,
 * 
 * return 13.
 * 
 * 
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ n2.
 */
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
    	int m = matrix.length, n = matrix[0].length;
        for(int i = m - 1; i >= 0; i--)
        	for(int j = n - 1; j >= 0; j--){
        		if((j + 1)*(i + 1) <= k){
        			int rank = lessNum(matrix, j + 1, 0, n - 1, i - 1, matrix[i][j]) + (i + 1)*(j + 1) + lessNum(matrix, 0, i + 1, j - 1, m - 1, matrix[i][j]);
        			if(rank == k)
        				return matrix[i][j];
        		}
        	}
        return 0;
    }

    public int lessNum(int[][] matrix, int left, int top, int right, int bottom, int k){
    	if(top > bottom || left > right)
    		return 0;
    	int sum = 0;
    	int t = left;
    	for(int i = bottom; i >= top; i--)
    		for(int j = right; j >= t; j--)
    			if(k > matrix[i][j]){
    				sum += (i - bottom + 1) * (j - t + 1);
    				t = j + 1;
    				break;
    			}
    	return sum;
    }
}
