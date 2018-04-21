/*
 * [125] Valid Palindrome
 *
 * https://leetcode.com/problems/valid-palindrome/description/
 *
 * algorithms
 * Easy (27.08%)
 * Total Accepted:    223.5K
 * Total Submissions: 825.4K
 * Testcase Example:  '"A man, a plan, a canal: Panama"'
 *
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid
 * palindrome.
 *
 * Example 1:
 *
 *
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 *
 *
 * Example 2:
 *
 *
 * Input: "race a car"
 * Output: false
 *
 *
 */
class Solution {
    private static final char[] charMap = new char[256];
    static{
        for(int i = 0;i < 10;i++){
            charMap[i+'0'] = (char)(1+i);  // numeric
        }
        for(int i = 0;i < 26;i++){
            charMap[i+'a'] = charMap[i+'A'] = (char)(11+i);  //alphabetic, ignore cases
        }
    }
    public boolean isPalindrome(String s) {
        char[] pChars = s.toCharArray();
        int start = 0,end = pChars.length-1;
        char cS,cE;
        while(start < end){
            cS = charMap[pChars[start]];
            cE = charMap[pChars[end]];
            if(cS != 0 && cE != 0){
                if(cS != cE) return false;
                start++;
                end--;
            }else{
                if(cS == 0) start++;
                if(cE == 0) end--;
            }
        }
        return true;
    }

}
