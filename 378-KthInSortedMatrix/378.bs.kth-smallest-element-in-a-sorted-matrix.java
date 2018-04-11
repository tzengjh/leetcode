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

    // use binary search
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0 || k <= 0) throw new IllegalArgumentException();
        int m = matrix.length, n = matrix[0].length;
        int lo = matrix[0][0], hi = matrix[m-1][n-1];
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            int j = n-1;
            int count = 0;
            for(int i = 0; i < m; i++){
                while(j >= 0 && matrix[i][j] > mid) j--;
                count += (j + 1);
            }
            if(count < k) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
