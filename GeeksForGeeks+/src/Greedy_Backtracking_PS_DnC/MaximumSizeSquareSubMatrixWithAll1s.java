package Greedy_Backtracking_PS_DnC;
/*
 * http://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
 */
public class MaximumSizeSquareSubMatrixWithAll1s {

	public int size(int[][] m){
		int row = m.length, col = m[0].length,maxsize = 0;

		for(int i = 1;i < row;i++){

			for(int j = 1;j < col;j++){
				if(m[i][j] == 1)
					m[i][j] = Math.min(Math.min(m[i-1][j-1],m[i-1][j]),m[i][j-1])+1;
				else
					m[i][j] = 0;
				maxsize = Math.max(maxsize,m[i][j]);
			}
		}
		return maxsize;
	}

	public static void main(String[] args) {
		MaximumSizeSquareSubMatrixWithAll1s obj = new MaximumSizeSquareSubMatrixWithAll1s();
		int arr[][] =  {{0, 1, 1, 0, 1}, 
				{1, 1, 0, 1, 0}, 
				{0, 1, 1, 1, 0},
				{1, 1, 1, 1, 0},
				{1, 1, 1, 1, 1},
				{0, 0, 0, 0, 0}};

		System.out.println("Max size:"+obj.size(arr));

		System.out.println("Elements of 2-D array");
		for(int i = 0;i < arr.length;i++){
			for(int j = 0;j < arr[0].length;j++)
				System.out.print(arr[i][j]);
			System.out.println();
		}
	}
}