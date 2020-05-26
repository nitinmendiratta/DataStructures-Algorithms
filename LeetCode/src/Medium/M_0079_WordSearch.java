package Medium;
import java.util.*;
/*
 * https://leetcode.com/problems/word-search/
 */
public class M_0079_WordSearch {
	
	// DFS
	public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        char[] chs = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(dfs(board, chs, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, char[] words, int idx, int x, int y) {
        if (idx == words.length) {
            return true;
        } 
        if (x < 0 || x == board.length || y < 0 || y == board[0].length) {
            return false;
        }
        if (board[x][y] != words[idx]) {
            return false;
        }
        //The range of char is between 0 - 255. 
        // By doing xor with 256, board[x][y] becomes a number >= 256 and thus is different from any character
        board[x][y] ^= 256;
        boolean exist = dfs(board, words, idx + 1, x, y + 1) ||
        				dfs(board, words, idx + 1, x, y - 1) || 
        				dfs(board, words, idx + 1, x + 1, y) ||
    					dfs(board, words, idx + 1, x - 1, y) ;
        board[x][y] ^= 256;
        return exist;
    }
		
	// My Approach: using extra space for boolean used array
	public boolean existApproach3(char[][] board, String word) {
		int[][] c = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};
		int rows = board.length, cols = board[0].length;
		for(int i = 0;i < rows; i++)
			for(int j = 0;j < cols; j++) {
				if(board[i][j] == word.charAt(0)) {
					boolean[][] used = new boolean[rows][cols];
					used[i][j] = true;
					if(backtrack(board, word, new StringBuilder().append(board[i][j]), i, j, used, c)) return true;
					used[i][j] = false;
				}
			}
		return false;
	}

	private boolean backtrack(char[][] board, String word, StringBuilder currResult, int currX, int currY, boolean[][] used, int[][] c){
		
		String temp = currResult.toString();
		if(temp.equals(word)){
			return true;
		}else if(temp.length() > 1 && !word.startsWith(temp) || currX >= board.length || currY >= board[0].length || currX < 0 || currY < 0) {
			return false;
		}

		for (int i = 0; i < c.length; i++) {
			int x = c[i][0], y = c[i][1], newX = currX+x, newY = currY+y;
			
			if (newX >= board.length || newX < 0 || newY >= board[0].length || newY < 0 || used[newX][newY]) continue;
			currResult.append(board[newX][newY]);
			used[newX][newY] = true;
			if(backtrack(board, word, currResult, newX, newY, used, c)) return true;

			used[newX][newY] = false;
			currResult.deleteCharAt(currResult.length() - 1);
		}
		return false;
	}
	public static void main(String[] args) {
		M_0079_WordSearch obj = new M_0079_WordSearch();

		char[][] board = new char[][] {
			{'A','B','C','E'},
			{'S','F','C','S'},
			{'A','D','E','E'}};
		
		System.out.println(obj.exist(board, "ABCCEDD"));
		System.out.println(obj.exist(board, "SEE"));
		System.out.println(obj.exist(board, "ABCB"));
	}
}
