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
    List<List<Integer>> list;

    public List<List<Integer>> permute(int[] nums){
        list = new ArrayList<>();
        ArrayList<Integer> perm = new ArrayList<Integer>();
        backTrack(perm,0,nums);
        return list;
    }

    void backTrack (ArrayList<Integer> perm,int i,int[] nums){
        //Permutation completes
        if(i==nums.length){
            list.add(new ArrayList(perm));
            return;
        }

        ArrayList<Integer> newPerm = new ArrayList<Integer>(perm);
       //Insert elements in the array by increasing index
        for(int j=0;j<=i;j++){
            newPerm.add(j,nums[i]);
            backTrack(newPerm,i+1,nums);
            newPerm.remove(j);
        }

    }
}
