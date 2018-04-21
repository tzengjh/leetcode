/*
 * [73] Set Matrix Zeroes
 *
 * https://leetcode.com/problems/set-matrix-zeroes/description/
 *
 * algorithms
 * Medium (36.54%)
 * Total Accepted:    137.9K
 * Total Submissions: 377.2K
 * Testcase Example:  '[[1,1,1],[1,0,1],[1,1,1]]'
 *
 * Given a m x n matrix, if an element is 0, set its entire row and column to
 * 0. Do it in-place.
 *
 * Example 1:
 *
 *
 * Input:
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * Output:
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 *
 *
 * Example 2:
 *
 *
 * Input:
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * Output:
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 *
 *
 * Follow up:
 *
 *
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best
 * solution.
 * Could you devise a constant space solution?
 *
 *
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return;
        int m = matrix.length, n = matrix[0].length;
        boolean fr = false, fc = false;
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(matrix[i][j] == 0){
                    if(i == 0) fr = true;
                    if(j == 0) fc = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }

        for(int i = 1; i < m; i++)
            if(matrix[i][0] == 0)
                for(int j = 1; j < n; j++)
                    matrix[i][j] = 0;

        for(int j = 1; j < n; j++)
            if(matrix[0][j] == 0)
                for(int i = 1; i < m; i++)
                    matrix[i][j] = 0;

        // matrix[0][0] indicates whether to clear first row or first column
        if(fc)
            for(int i = 1; i < m; i++)
                matrix[i][0] = 0;
        if(fr)
            for(int j = 1; j < n; j++)
                matrix[0][j] = 0;
    }
}
