/*
 * [54] Spiral Matrix
 *
 * https://leetcode.com/problems/spiral-matrix/description/
 *
 * algorithms
 * Medium (27.24%)
 * Total Accepted:    138.5K
 * Total Submissions: 508.4K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * 
 * 
 * For example,
 * Given the following matrix:
 * 
 * 
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 4, 5, 6 ],
 * ⁠[ 7, 8, 9 ]
 * ]
 * 
 * 
 * You should return [1,2,3,6,9,8,7,4,5].
 * 
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
    	
        List<Integer> list = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
    		return list;
        int m = matrix.length;
        int n = matrix[0].length;
        int total = n * m;
        int left = 0, right = n - 1, top = 0, bottom = m - 1;
        while(true){
        	for(int j = left; j <= right; j ++)
        		list.add(matrix[top][j]);
        	top ++;
        	if(list.size() == total) break;
        	for(int i = top; i <= bottom; i ++)
        		list.add(matrix[i][right]);
        	right --;
        	if(list.size() == total) break;
        	for(int j = right; j >= left; j --)
        		list.add(matrix[bottom][j]);
        	bottom --;
        	if(list.size() == total) break;
        	for(int i = bottom; i >= top; i --)
        		list.add(matrix[i][left]);
        	left ++;
        	if(list.size() == total) break;
        }
        return list;
    }
}
