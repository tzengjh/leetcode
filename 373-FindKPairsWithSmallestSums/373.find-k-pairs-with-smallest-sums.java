/*
 * [373] Find K Pairs with Smallest Sums
 *
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/
 *
 * algorithms
 * Medium (31.32%)
 * Total Accepted:    39.8K
 * Total Submissions: 127K
 * Testcase Example:  '[1,7,11]\n[2,4,6]\n3'
 *
 *
 * You are given two integer arrays nums1 and nums2 sorted in ascending order
 * and an integer k.
 *
 *
 * Define a pair (u,v) which consists of one element from the first array and
 * one element from the second array.
 *
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 *
 *
 * Example 1:
 *
 * Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3
 *
 * Return: [1,2],[1,4],[1,6]
 *
 * The first 3 pairs are returned from the sequence:
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 *
 *
 *
 * Example 2:
 *
 * Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2
 *
 * Return: [1,1],[1,1]
 *
 * The first 2 pairs are returned from the sequence:
 * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 *
 *
 *
 * Example 3:
 *
 * Given nums1 = [1,2], nums2 = [3],  k = 3
 *
 * Return: [1,3],[2,3]
 *
 * All possible pairs are returned from the sequence:
 * [1,3],[2,3]
 *
 *
 *
 * Credits:Special thanks to @elmirap and @StefanPochmann for adding this
 * problem and creating all test cases.
 */
class Solution {
    private class Node implements Comparable<Node>{
        int[] vs = new int[2];
        int sum = 0;
        int i = 0;
        int j = 0;
        Node(int x, int y, int i, int j){
            vs[0] = x;
            vs[1] = y;
            sum = x + y;
            this.i = i;
            this.j = j;
        }

        public int compareTo(Node node){
            return sum - node.sum;
        }
    }

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> list = new ArrayList<int[]>();
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k == 0) return list;
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        int l1 = nums1.length, l2 = nums2.length;
        for(int i = 0; i < l2 && i < k; i++){
            pq.offer(new Node(nums1[0], nums2[i], 0, i));
        }
        Node node = null;
        for(int i = 0; i < k && !pq.isEmpty(); i++){
            node = pq.poll();
            list.add(node.vs);
            if(node.i+1 < l1){
                pq.offer(new Node(nums1[node.i+1], nums2[node.j], node.i+1, node.j));
            }
        }
        return list;
    }
}
