/*
 * [154] Find Minimum in Rotated Sorted Array II
 *
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/
 *
 * algorithms
 * Hard (37.83%)
 * Total Accepted:    94.9K
 * Total Submissions: 250.9K
 * Testcase Example:  '[1]'
 *
 *
 * Follow up for "Find Minimum in Rotated Sorted Array":
 * What if duplicates are allowed?
 *
 * Would this affect the run-time complexity? How and why?
 *
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * Find the minimum element.
 *
 * The array may contain duplicates.
 */
class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int lo = 0, hi = nums.length - 1;
        if(nums[lo] < nums[hi]) return nums[lo];
        while(lo + 1 < hi){
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] > nums[lo]) lo = mid;
            else if(nums[mid] < nums[hi]) hi = mid;
            else if(nums[mid] == nums[lo] && nums[mid] > nums[hi]) lo = mid;
            else if(nums[mid] == nums[hi] && nums[mid] < nums[lo]) hi = mid;
            else if(nums[mid] == nums[hi] && nums[mid] == nums[lo]) return findMin(nums, lo, hi);
        }
        return nums[hi];

    }

    public int findMin(int[] nums, int lo, int hi){
        int min = nums[lo];
        for(int i = lo + 1; i <= hi; i++){
            if(nums[i] < min)
                min = nums[i];
        }
        return min;
    }
}
