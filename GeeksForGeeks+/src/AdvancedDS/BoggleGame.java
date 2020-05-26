package AdvancedDS;
/*
 * https://www.geeksforgeeks.org/boggle-find-possible-words-board-characters/
 */
public class BoggleGame {

	String dictionary[] = {"GEEKS", "FOR", "QUIZ", "GO"};
	
	public void validWordsUtil(char boggle[][], int i, int j, boolean[][] visited, String str) {
		int M = boggle.length;
		int N = boggle[0].length;
		visited[i][j] = true;
		str += boggle[i][j];
		if (isValidWord(str)) System.out.println(str);
		// Traverse 8 adjacent cells of boggle[i][j]
		for (int row = i-1; row <= i+1 && row < M; row++)
			for (int col = j-1; col <= j+1 && col < N; col++)
				if (row >= 0 && col >= 0 && !visited[row][col])
					validWordsUtil(boggle, row, col, visited, str);

		// Erase current character from string and mark visited of current cell as false
		str = str.substring(0,str.length()-1);
		visited[i][j] = false;
	}

	public void validWords(char boggle[][]) {
		int m = boggle.length;
		int n = boggle[0].length;
		String str = "";
		boolean[][] visited = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					System.out.println("\nSTARTING AT " + boggle[i][j]);
					validWordsUtil(boggle, i, j, visited, str);
				}
			}
		}
	}

	public boolean isValidWord(String str){
		System.out.println("Checking for: "+str);
		if(str == null) return false;
		for(int i = 0;i < dictionary.length;i++){
			if(str.equals(dictionary[i])) return true;
		}
		return false;
	}

	public static void main(String[] args) {
		BoggleGame obj = new BoggleGame();
		char boggle[][]   = {{'G','I','Z'},
			{'U','E','K'},
			{'Q','S','E'}};

		obj.validWords(boggle);
	}
}