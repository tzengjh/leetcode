/*
 * [831] Largest Sum of Averages
 *
 * https://leetcode.com/problems/largest-sum-of-averages/description/
 *
 * algorithms
 * Medium (41.43%)
 * Total Accepted:    6.1K
 * Total Submissions: 14.7K
 * Testcase Example:  '[9,1,2,3,9]\n3'
 *
 * We partition a row of numbers A into at most K adjacent (non-empty) groups,
 * then our score is the sum of the average of each group. What is the largest
 * score we can achieve?
 * 
 * Note that our partition must use every number in A, and that scores are not
 * necessarily integers.
 * 
 * 
 * Example:
 * Input: 
 * A = [9,1,2,3,9]
 * K = 3
 * Output: 20
 * Explanation: 
 * The best choice is to partition A into [9], [1, 2, 3], [9]. The answer is 9
 * + (1 + 2 + 3) / 3 + 9 = 20.
 * We could have also partitioned A into [9, 1], [2], [3, 9], for example.
 * That partition would lead to a score of 5 + 2 + 6 = 13, which is worse.
 * 
 * 
 * 
 * 
 * Note: 
 * 
 * 
 * 1 <= A.length <= 100.
 * 1 <= A[i] <= 10000.
 * 1 <= K <= A.length.
 * Answers within 10^-6 of the correct answer will be accepted as correct.
 * 
 * 
 */
class Solution {
    public double largestSumOfAverages(int[] A, int K) {
	int N = A.length;
	int[] accums = new int[N];
	double[][] sum = new double[K][N];
	accums[0] = A[0];
	sum[0][0] = (double)A[0];
	for(int i = 1; i < N; i++){
		accums[i] = accums[i-1] + A[i];
		sum[0][i] = (double) accums[i] / (double) (i + 1);
	}
	for(int i = 1; i < K; i++)
		for(int j = i; j < N; j++){
			int k = 1;
			while(j - k >= i - 1){
				sum[i][j] = Math.max(sum[i][j], sum[i-1][j-k] + (accums[j] - accums[j-k])/ (double)k); 
				k++;
			}
		}
	return sum[K-1][N-1];
    }
}
