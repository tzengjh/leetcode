/*
 * [59] Spiral Matrix II
 *
 * https://leetcode.com/problems/spiral-matrix-ii/description/
 *
 * algorithms
 * Medium (40.94%)
 * Total Accepted:    99.2K
 * Total Submissions: 242.4K
 * Testcase Example:  '0'
 *
 * Given an integer n, generate a square matrix filled with elements from 1 to
 * n2 in spiral order.
 * 
 * 
 * For example,
 * Given n = 3,
 * 
 * You should return the following matrix:
 * 
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 8, 9, 4 ],
 * ⁠[ 7, 6, 5 ]
 * ]
 * 
 */
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int count = 1;
        while(left <= right){
        	for(int j = left; j <= right; j++)
        		matrix[top][j] = count++;
        	top ++;
        	for(int i = top; i <= bottom; i++)
        		matrix[i][right] = count++;
        	right --;
        	for(int j = right; j >= left; j--)
        		matrix[bottom][j] = count++;
        	bottom --;
        	for(int i = bottom; i >= top; i--)
        		matrix[i][left] = count++;
        	left ++;
        }
        return matrix;
    }
}
