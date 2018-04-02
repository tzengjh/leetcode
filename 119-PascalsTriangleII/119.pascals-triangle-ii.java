/*
 * [119] Pascal's Triangle II
 *
 * https://leetcode.com/problems/pascals-triangle-ii/description/
 *
 * algorithms
 * Easy (38.05%)
 * Total Accepted:    140.8K
 * Total Submissions: 370K
 * Testcase Example:  '0'
 *
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * 
 * For example, given k = 3,
 * Return [1,3,3,1].
 * 
 * 
 * 
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 * 
 */
class Solution {
    public List<Integer> getRow(int rowIndex) {
        // List<Integer> prev = new ArrayList<Integer>();
        // List<Integer> curr = new ArrayList<Integer>();
        // for(int i = 0; i <= rowIndex; i ++){
        // 	curr = new ArrayList<Integer>();
        // 	curr.add(1);
        // 	for(int j = 1; j < i; j ++){
        // 		curr.add(prev.get(j-1) + prev.get(j));
        // 	}
        // 	if(i != 0)
        // 		curr.add(1);
        // 	prev = curr;
        // }
        // return curr;
        List<Integer> curr = new ArrayList<Integer>();
        if(rowIndex < 0) return curr;
        for(int i = 0; i <= rowIndex; i ++){
        	curr.add(i, 1);
        	for(int j = i - 1; j > 0; j --){
        		curr.set(j, curr.get(j) + curr.get(j - 1));
        	}
        }
        return curr;
    }
}
