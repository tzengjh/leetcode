/*
 * [118] Pascal's Triangle
 *
 * https://leetcode.com/problems/pascals-triangle/description/
 *
 * algorithms
 * Easy (39.98%)
 * Total Accepted:    167.3K
 * Total Submissions: 418.4K
 * Testcase Example:  '0'
 *
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * 
 * For example, given numRows = 5,
 * Return
 * 
 * [
 * ⁠    [1],
 * ⁠   [1,1],
 * ⁠  [1,2,1],
 * ⁠ [1,3,3,1],
 * ⁠[1,4,6,4,1]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {

    	List<List<Integer>> nLists = new ArrayList<List<Integer>>(); // pay attention to the statement
        for(int i = 1; i <= numRows; i++){
        	List<Integer> list  = new ArrayList<Integer>();

        	list.add(1); 
        	for(int j = 1; j < i - 1; j++){
        		list.add(nLists.get(i - 2).get(j - 1) + nLists.get(i - 2).get(j));
        	}
        	if(i != 1)
        		list.add(1);

        	nLists.add(list);
        }
        return nLists;
    }
}
