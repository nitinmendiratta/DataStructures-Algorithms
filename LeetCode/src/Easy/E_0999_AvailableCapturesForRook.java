package Easy;
/*
 * https://leetcode.com/problems/available-captures-for-rook/
 */
public class E_0999_AvailableCapturesForRook {


	// clean approach
	public int numRookCaptures(char[][] board) {
		int[] rook = findRook(board);
		int r = board.length, c = board[0].length, res = 0;
		int x0 = rook[0], y0 = rook[1];

		int[][] directions = new int[][] {{1, 0}, {0, 1}, { -1, 0}, {0, -1}};

		for (int[] d : directions) {
			int x = x0 + d[0],
					y = y0 + d[1];

			for (; 0 <= x && x < c && 0 <= y && y < r; x += d[0], y += d[1]) {
				if (board[x][y] == 'p') res++;
				if (board[x][y] != '.') break;
			}
		}
		return res;
	}
	
	public int[] findRook(char[][] board){

		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				if(board[i][j] == 'R'){
					return new int[]{i,j};
				}
			}
		}
		return null;
	}

	// my approach
	int count = 0;
	public int numRookCapturesMyApproach(char[][] board) {
		int[] rook = findRook(board);
		int r = board.length, c = board[0].length;

		int i = rook[0], j = rook[1];
		while(j < c){
			if(!check(board, i , j)) break;
			j++;
		}

		i = rook[0]; j = rook[1];
		while(j >= 0){
			if(!check(board, i , j)) break;
			j--;
		}

		i = rook[0]; j = rook[1];
		while(i < r){
			if(!check(board, i , j)) break;
			i++;
		}

		i = rook[0]; j = rook[1];
		while(i >= 0){
			if(!check(board, i , j)) break;
			i--;
		}
		return count;
	}

	public boolean check(char[][] board, int i, int j) {
		if(board[i][j] == 'p'){
			count++;
			return false;
		}else if(board[i][j] == 'B'){
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		E_0999_AvailableCapturesForRook obj = new E_0999_AvailableCapturesForRook();
		System.out.println(obj.numRookCaptures(new char[][] {
			{'.','.','.','.','.','.','.','.'},
			{'.','.','.','p','.','.','.','.'},
			{'.','.','.','R','.','.','.','p'},
			{'.','.','.','.','.','.','.','.'},
			{'.','.','.','.','.','.','.','.'},
			{'.','.','.','p','.','.','.','.'},
			{'.','.','.','.','.','.','.','.'},
			{'.','.','.','.','.','.','.','.'}
		}));
	}
}
