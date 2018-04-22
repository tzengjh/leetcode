/*
 * [34] Search for a Range
 *
 * https://leetcode.com/problems/search-for-a-range/description/
 *
 * algorithms
 * Medium (31.60%)
 * Total Accepted:    188.2K
 * Total Submissions: 595.7K
 * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * Given an array of integers nums sorted in ascending order, find the starting
 * and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Example 2:
 *
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        // find the first index
        int lo = 0, hi = nums.length - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        int[] range = {-1, -1};
        if(lo == nums.length || nums[lo] != target)
            return range;
        range[0] = lo;
        // find the last index
        hi = nums.length - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] > target) hi = mid - 1;
            else lo = mid + 1;
        }
        range[1] = hi;
        return range;
    }
}
