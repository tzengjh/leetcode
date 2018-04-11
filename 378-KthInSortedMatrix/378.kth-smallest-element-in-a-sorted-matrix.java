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
    private class Node implements Comparable<Node>{
        int x;
        int i;
        int j;
        Node(int x, int i, int j){
            this.x = x;
            this.i = i;
            this.j = j;
        }

        public int compareTo(Node node){
            return this.x - node.x;
        }
    }


    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0 || k <= 0) throw new IllegalArgumentException();
        int m = matrix.length, n = matrix[0].length;
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        for(int i = 0; i < n && i < k; i++)
            pq.offer(new Node(matrix[0][i], 0, i));
        Node node = null;
        for(int i = 0; i < k && !pq.isEmpty(); i++){
            node = pq.poll();
            if(node.i + 1 < m){
                pq.offer(new Node(matrix[node.i + 1][node.j], node.i + 1, node.j));
            }
        }
        return node.x;
    }
}
