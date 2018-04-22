/*
 * [36] Valid Sudoku
 *
 * https://leetcode.com/problems/valid-sudoku/description/
 *
 * algorithms
 * Medium (37.69%)
 * Total Accepted:    153.4K
 * Total Submissions: 406.9K
 * Testcase Example:  '[["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]'
 *
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be
 * validated according to the following rules:
 *
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without
 * repetition.
 *
 *
 *
 * A partially filled sudoku which is valid.
 *
 * The Sudoku board could be partially filled, where empty cells are filled
 * with the character '.'.
 *
 * Example 1:
 *
 *
 * Input:
 * [
 * ⁠ ["5","3",".",".","7",".",".",".","."],
 * ⁠ ["6",".",".","1","9","5",".",".","."],
 * ⁠ [".","9","8",".",".",".",".","6","."],
 * ⁠ ["8",".",".",".","6",".",".",".","3"],
 * ⁠ ["4",".",".","8",".","3",".",".","1"],
 * ⁠ ["7",".",".",".","2",".",".",".","6"],
 * ⁠ [".","6",".",".",".",".","2","8","."],
 * ⁠ [".",".",".","4","1","9",".",".","5"],
 * ⁠ [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: true
 *
 *
 * Example 2:
 *
 *
 * Input:
 * [
 * ["8","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner
 * being
 * ⁠   modified to 8. Since there are two 8's in the top left 3x3 sub-box, it
 * is invalid.
 *
 *
 * Note:
 *
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily
 * solvable.
 * Only the filled cells need to be validated according to the mentioned
 * rules.
 * The given board contain only digits 1-9 and the character '.'.
 * The given board size is always 9x9.
 *
 *
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0) return false;
        int m = board.length, n = board[0].length;
        if(m != 9 || n != 9) return false;
        for(int i = 0; i < m; i++){
            Set<Character> set = new HashSet<Character>();
            for(int j = 0; j < n; j++){
                if(board[i][j] == '.') continue;
                if(board[i][j] < '0' || board[i][j] > '9') return false;
                if(set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }

        for(int j = 0; j < n; j++){
            Set<Character> set = new HashSet<Character>();
            for(int i = 0; i < m; i++){
                if(board[i][j] == '.') continue;
                if(board[i][j] < '0' || board[i][j] > '9') return false;
                if(set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }

        for(int k = 0; k < 3; k++){
            for(int p = 0; p < 3; p++){
                Set<Character> set = new HashSet<Character>();
                for(int j = k*3; j < 3 + k*3; j++){
                    for(int i = p*3; i < 3 + p*3; i++){
                        if(board[i][j] == '.') continue;
                        if(board[i][j] < '0' || board[i][j] > '9') return false;
                        if(set.contains(board[i][j])) return false;
                        set.add(board[i][j]);
                    }
                }
            }
        }
        return true;
    }
}
