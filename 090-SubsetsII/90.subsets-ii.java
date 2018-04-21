/*
 * [90] Subsets II
 *
 * https://leetcode.com/problems/subsets-ii/description/
 *
 * algorithms
 * Medium (38.37%)
 * Total Accepted:    145.1K
 * Total Submissions: 378.1K
 * Testcase Example:  '[1,2,2]'
 *
 * Given a collection of integers that might contain duplicates, nums, return
 * all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 *
 * Input: [1,2,2]
 * Output:
 * [
 * ⁠ [2],
 * ⁠ [1],
 * ⁠ [1,2,2],
 * ⁠ [2,2],
 * ⁠ [1,2],
 * ⁠ []
 * ]
 *
 */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        list.add(new ArrayList<Integer>());
        if(nums == null || nums.length == 0) return list;
        List<List<Integer>> lastList = list;
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i < n; i++){
            List<List<Integer>> tlist = null;
            if(i == 0 || nums[i] == nums[i-1]) tlist = lastList;
            else tlist = list;
            List<List<Integer>> tmp = new ArrayList<List<Integer>>();
            for(List<Integer> l: tlist){
                List<Integer> t = new ArrayList<Integer>(l);
                t.add(nums[i]);
                tmp.add(t);
            }
            list.addAll(tmp);
            lastList = tmp;
        }
        return list;
    }
}
