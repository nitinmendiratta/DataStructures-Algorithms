package Strings;
/*
 * http://www.geeksforgeeks.org/check-rows-matrix-circular-rotations/
 */
public class S127_CheckIfAllRowsOfaMatrixAreCircularRotationsOfEachOther {

	// Returns true if all rows of mat[0..n-1][0..n-1] are rotations of each other.
	public static boolean isPermutedMatrix( int mat[][]){
	    // Creating a String that contains elements of first row.
	    String str_cat = "";
	    int n = mat.length;
	    for (int i = 0 ; i < n; i++)
	        str_cat = str_cat + "-" + mat[0][i];
	 
	    // Concatenating the String with itself so that
	    // subString search operations can be performed on this
	    str_cat = str_cat + str_cat;
	 
	    // Start traversing remaining rows
	    for (int i=1; i < n; i++){
	        // Store the matrix into vector in the form of Strings
	        String curr_str = "";
	        for (int j = 0 ; j < n ; j++)
	            curr_str = curr_str + "-" + mat[i][j];
	 
	        // Check if the current String is present in the concatenated String or not
	        if (!str_cat.contains(curr_str))
	            return false;
	    }
	 
	    return true;
	}
	public static void main(String[] args) {
		int n = 4 ;
	    int mat[][] = {{1, 2, 3, 4},
	        {4, 1, 2, 3},
	        {3, 4, 1, 2},
	        {2, 3, 4, 1}
	    };
	    System.out.println(isPermutedMatrix(mat));
	}
}
