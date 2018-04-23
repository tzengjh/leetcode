/*
 * [46] Permutations
 *
 * https://leetcode.com/problems/permutations/description/
 *
 * algorithms
 * Medium (47.47%)
 * Total Accepted:    233.7K
 * Total Submissions: 492.3K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 *
 * Input: [1,2,3]
 * Output:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 *
 *
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        permute(nums, 0, list);
        return list;
    }

    private void permute(int[] nums, int lo, List<List<Integer>> list){
        int n = nums.length;
        if(lo == n - 1){
            List<Integer> l = new ArrayList<Integer>();
            for(int i = 0; i < n; i++)
                l.add(nums[i]);
            list.add(l);
        }

        for(int i = lo; i < n; i++){
            swap(nums, lo, i);
            permute(nums, lo + 1, list);
            swap(nums, lo, i);
        }

    }

    private void swap(int[] nums, int a, int b){
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}
