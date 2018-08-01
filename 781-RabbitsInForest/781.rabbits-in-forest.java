/*
 * [797] Rabbits in Forest
 *
 * https://leetcode.com/problems/rabbits-in-forest/description/
 *
 * algorithms
 * Medium (49.66%)
 * Total Accepted:    6.7K
 * Total Submissions: 13.6K
 * Testcase Example:  '[1,0,1,0,0]'
 *
 * In a forest, each rabbit has some color. Some subset of rabbits (possibly
 * all of them) tell you how many other rabbits have the same color as them.
 * Those answers are placed in an array.
 * 
 * Return the minimum number of rabbits that could be in the forest.
 * 
 * 
 * Examples:
 * Input: answers = [1, 1, 2]
 * Output: 5
 * Explanation:
 * The two rabbits that answered "1" could both be the same color, say red.
 * The rabbit than answered "2" can't be red or the answers would be
 * inconsistent.
 * Say the rabbit that answered "2" was blue.
 * Then there should be 2 other blue rabbits in the forest that didn't answer
 * into the array.
 * The smallest possible number of rabbits in the forest is therefore 5: 3 that
 * answered plus 2 that didn't.
 * 
 * Input: answers = [10, 10, 10]
 * Output: 11
 * 
 * Input: answers = []
 * Output: 0
 * 
 * 
 * Note:
 * 
 * 
 * answers will have length at most 1000.
 * Each answers[i] will be an integer in the range [0, 999].
 * 
 */
class Solution {
    public int numRabbits(int[] answers) {
	if(answers == null || answers.length == 0) return 0;
	Arrays.sort(answers);
	int num = 0, count = 0, temp = 0;
	for(int i = 0; i < answers.length; i++){
		if(i == 0 || answers[i] != answers[i - 1] || count >= temp){
			count = 0;
			temp = 1 + answers[i];
			num += temp;
		}
		count += 1;
	}
	return num;
    }
}
