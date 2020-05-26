package AdvancedDS;
/*
 * http://www.geeksforgeeks.org/print-unique-rows/
 */
 
public class NC_PrintUniqueRowsInGivenBooleanMatrix {
/*
	// Inserts a new matrix row to Trie.  If row is already present, then returns 0, otherwise insets the row and return 1
	public boolean insert(TrieNode root, int M[][], int row, int col){
		// base case
		
		int COL = M[row].length;
		
		if (root == null)
			root = TrieNode.newNode();

		// Recur if there are more entries in this row
		if (col < COL){
			System.out.println("processing:"+row+","+col);	
			return insert(root.child[M[row][col]], M, row, col+1);
		}

		else{ // If all entries of this row are processed unique row found, return 1
			
			if (!root.isEndOfCol){
					root.isEndOfCol = true;
					System.out.println("setting:"+root.isEndOfCol);
					return true;
			}
			System.out.println("Already:"+root.isEndOfCol);
			// duplicate row found, return 0
			return false;
		}
	}

	// A utility function to print a row
	public void printRow( int M[][], int row){
		int i = 0, COL = M[row].length;
		for( i = 0; i < COL; ++i )
			System.out.print(M[row][i]);
		System.out.println();
	}

	// The main function that prints all unique rows in a given matrix.
	public void findUniqueRows(int M[][]){
		TrieNode root = null; // create an empty Trie
		int i = 0;
		int ROW = M.length;
		int COL = M[0].length;
		
		// Iterate through all rows
		for (i = 0; i < ROW; ++i )
			// insert row to TRIE
			if (insert(root, M, i, 0) )
				// unique row found, print it
				printRow( M, i );
	}*/

	// Driver program to test above functions
	public static void main(String[] args) {
		/*NC_PrintUniqueRowsInGivenBooleanMatrix obj = new NC_PrintUniqueRowsInGivenBooleanMatrix();
		int M[][] = {	{0, 1, 0, 0, 1},
						{1, 0, 1, 1, 0},
						{0, 1, 0, 0, 1},
						{1, 0, 1, 0, 0}
		};
		obj.findUniqueRows( M );*/
	}
}
