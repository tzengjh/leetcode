/*
 * [153] Find Minimum in Rotated Sorted Array
 *
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (40.82%)
 * Total Accepted:    190.4K
 * Total Submissions: 466.4K
 * Testcase Example:  '[1]'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * Find the minimum element.
 *
 * You may assume no duplicate exists in the array.
 */
class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int lo = 0, hi = nums.length - 1;
        if(nums[lo] <= nums[hi]) return nums[lo];  //check wheter the array is rotated
        while(hi > lo + 1){  // the length of array is larger than or equal to 3
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] > nums[lo]) lo = mid;
            else if(nums[mid] < nums[hi]) hi = mid;
        }
        return nums[hi];
    }
}
