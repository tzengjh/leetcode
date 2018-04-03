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
        boolean[][] seen = new boolean[n][n];
        int r = 0, c = 0, k = 0;
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        for(int i = 1; i <= n*n; i++){
        	matrix[r][c] = i;
        	seen[r][c] = true;
        	int nr = r + dr[k];
        	int nc = c + dc[k];
        	if(nr >= 0 && nr < n && nc >= 0 && nc < n && !seen[nr][nc]){
        		r = nr;
        		c = nc;
        	}else{
        		k = (k + 1) % 4;
        		r = r + dr[k];
        		c = c + dc[k];
        	}
        }
        return matrix;
    }
}
