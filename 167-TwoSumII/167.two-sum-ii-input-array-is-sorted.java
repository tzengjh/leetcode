/*
 * [167] Two Sum II - Input array is sorted
 *
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 *
 * algorithms
 * Easy (47.39%)
 * Total Accepted:    157.1K
 * Total Submissions: 331.6K
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * Given an array of integers that is already sorted in ascending order, find
 * two numbers such that they add up to a specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2.
 * 
 * Note:
 * 
 * 
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may
 * not use the same element twice.
 * 
 * 
 * Example:
 * 
 * 
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 * 
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
	if(numbers == null || numbers.length <= 1) return new int[]{-1, -1};
	for(int i = 0; i < numbers.length; i++){
		int findIndex = binarySearch(numbers, i + 1, numbers.length - 1, target - numbers[i]);
		if(findIndex != -1)
			return new int[]{i + 1, findIndex + 1};
	}
	return new int[]{-1, -1};
    }

    private int binarySearch(int[] numbers, int lo, int hi, int value){
	if(numbers == null || numbers.length == 0 || lo > hi) return -1;
	while(lo <= hi){
		int mid = lo + (hi - lo) / 2;
		if(numbers[mid] < value) lo = mid + 1;
		else if(numbers[mid] > value) hi = mid - 1;
		else return mid;
	}
	return -1;
    }
}
