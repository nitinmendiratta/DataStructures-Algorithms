package Medium;
import java.util.*;
/*
 * https://leetcode.com/problems/valid-sudoku/
 */
public class M_0036_ValidSudoku {

	// https://leetcode.com/problems/valid-sudoku/discuss/15617/Java-solution-easy-to-understand
	public boolean isValidSudoku(char[][] board) {
		boolean[][] col = new boolean[9][9];
		boolean[][] row = new boolean[9][9];
		boolean[][] block = new boolean[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {

				if (board[i][j] == '.') continue;

				int digit = board[i][j] - '1';
				int blockId = 3*(i/3) + j/3;

				// check column
				if (col[j][digit]) {
					return false;
				} else {
					col[j][digit] = true;
				}

				// check row
				if (row[i][digit]) {
					return false;
				} else {
					row[i][digit] = true;
				}

				// check block
				if (block[blockId][digit]) {
					return false;
				} else {
					block[blockId][digit] = true;
				}
			}
		}
		return true;
	}
	// https://leetcode.com/problems/valid-sudoku/discuss/15472/Short%2BSimple-Java-using-Strings
	public boolean isValidSudokuApproach2(char[][] board) {
		Set<String> seen = new HashSet<String>();
		for (int i=0; i<9; ++i) {
			for (int j=0; j<9; ++j) {
				char number = board[i][j];
				if (number != '.')
					if (!seen.add(number + " in row " + i) ||
							!seen.add(number + " in column " + j) ||
							!seen.add(number + " in block " + i/3 + "-" + j/3))
						return false;
			}
		}
		return true;
	}

	//https://leetcode.com/problems/valid-sudoku/discuss/15450/Shared-my-concise-Java-code
	public boolean isValidSudokuApproach3(char[][] board) {
		for(int i = 0; i<9; i++){
			HashSet<Character> rows = new HashSet<Character>();
			HashSet<Character> columns = new HashSet<Character>();
			HashSet<Character> cube = new HashSet<Character>();
			for (int j = 0; j < 9;j++){
				if(board[i][j]!='.' && !rows.add(board[i][j]))
					return false;
				if(board[j][i]!='.' && !columns.add(board[j][i]))
					return false;

				int RowIndex = 3*(i/3) + j/3;
				int ColIndex = 3*(i%3) + j%3;

				if(board[RowIndex][ColIndex]!='.' && !cube.add(board[RowIndex][ColIndex]))
					return false;
			}
		}
		return true;
	}

	
	// stupid approach
	public boolean isValidSudokuBruteForce(char[][] board) {  

		// rule1, column  
		for(int i=0; i<board[0].length; i++){  
			HashSet<Character> test = new HashSet<Character>();  
			for(int j=0; j<board.length; j++){  
				if(board[j][i]!='.' && !test.add(board[j][i])) return false;  
			}  
		}  

		// rule2, row  
		for(int i=0; i<board.length; i++){  
			HashSet<Character> test = new HashSet<Character>();  
			for(int j=0; j<board[0].length; j++){  
				if(board[i][j]!='.' && !test.add(board[i][j])) return false;  
			}  
		}     

		// rule3, sub-box  
		for(int i=0; i<3; i++){  
			for(int j=0; j<3; j++){// for each sub-box  
				HashSet<Character> test = new HashSet<Character>();  
				for(int m=i*3; m<i*3+3; m++){//row  
					for(int n=j*3; n<j*3+3; n++){//column  
						if(board[m][n]!='.' && !test.add(board[m][n])) return false;  
					}  
				}  
			}  
		}
		return true;  
	}  


	public static void main(String[] args) {
		M_0036_ValidSudoku obj = new M_0036_ValidSudoku();
		char[][] board = new char[][] {
			{'5','3','.','.','7','.','.','.','.'},
			{'6','.','.','1','9','5','.','.','.'},
			{'.','9','8','.','.','.','.','6','.'},
			{'8','.','.','.','6','.','.','.','3'},
			{'4','.','.','8','.','3','.','.','1'},
			{'7','.','.','.','2','.','.','.','6'},
			{'.','6','.','.','.','.','2','8','.'},
			{'.','.','.','4','1','9','.','.','5'},
			{'.','.','.','.','8','.','.','7','9'}
		};
		System.out.println(obj.isValidSudoku(board));
	}
}
