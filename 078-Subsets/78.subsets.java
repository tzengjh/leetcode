/*
 * [78] Subsets
 *
 * https://leetcode.com/problems/subsets/description/
 *
 * algorithms
 * Medium (44.91%)
 * Total Accepted:    232.2K
 * Total Submissions: 516.9K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a set of distinct integers, nums, return all possible subsets (the
 * power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 * ⁠ [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 *
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums, 0, nums.length - 1);
    }

    private List<List<Integer>> subsets(int[] nums, int lo, int hi){
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0 || lo > hi){
            list.add(new ArrayList<Integer>());
            return list;
        }
        List<List<Integer>> subList = subsets(nums, lo, hi - 1);
        for(List<Integer> l: subList){
            list.add(l);
            List<Integer> t = new ArrayList<Integer>();
            for(int i: l){
                t.add(i);
            }
            t.add(nums[hi]);
            list.add(t);
        }
        return list;
    }
}
