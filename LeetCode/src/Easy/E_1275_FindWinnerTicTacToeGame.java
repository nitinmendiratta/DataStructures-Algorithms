package Easy;
/*
 * https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/
 */
public class E_1275_FindWinnerTicTacToeGame {

	// Use r == c and r + c == 2 to judge main and skew diagonals.
	public String tictactoe(int[][] moves) {
		int[][] row = new int[2][3], col = new int[2][3];
		int[] d1 = new int[2], d2 = new int[2];
		for (int i = 0; i < moves.length; ++i) {
			int r = moves[i][0], c = moves[i][1], id = i % 2;
			if (++row[id][r] == 3 || ++col[id][c] == 3 || r == c && ++d1[id] == 3 || r + c == 2 && ++d2[id] == 3) 
				return id == 0 ? "A" : "B";
		}
		return moves.length == 9 ? "Draw" : "Pending";        
	}


	// my approach
	public String tictactoeMyApproach(int[][] moves) {

		int r = moves.length;
		String[][] game = new String[3][3];

		for(int i = 0; i < r; i++) {
			int[] curr = moves[i];
			if(i%2 == 0) {
				game[curr[0]][curr[1]] = "X";
			}else {
				game[curr[0]][curr[1]] = "O";
			}
		}

		if(checkWin(game, "X")) {
			return "A";
		}else if(checkWin(game, "O")){
			return "B";
		}

		return moves.length == 9 ? "Draw" : "Pending"; 
	}

	public boolean checkWin(String[][] game, String player) {
		boolean win = true;
		for(int i = 0; i < game.length; i++) {
			win = true;
			for(int j = 0; j < game[0].length; j++) {
				String curr = game[i][j];
				if(curr == null || !curr.equals(player)) {
					win = false;
					break;
				}
			}
			if(win) return true;
		}

		for(int i = 0; i < game.length; i++) {
			win = true;
			for(int j = 0; j < game[0].length; j++) {
				String curr = game[j][i];
				if(curr == null || !curr.equals(player)) {
					win = false;
					break;
				}
			}
			if(win) return true;
		}

		if(game[0][0] != null && game[0][0].equals(player) && game[1][1] != null && game[1][1].equals(player) && game[2][2] != null && game[2][2].equals(player) || 
				game[0][2] != null && game[0][2].equals(player) && game[1][1] != null && game[1][1].equals(player) && game[2][0] != null && game[2][0].equals(player)){
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		E_1275_FindWinnerTicTacToeGame obj = new E_1275_FindWinnerTicTacToeGame();
		int[][] moves = new int[][] {
			{0,0},{2,0},{1,1},{2,1},{2,2}
		};
		System.out.println(obj.tictactoe(moves));
	}
}
