package Greedy_Backtracking_PS_DnC;
/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/
 */

public class MinCostPath {

	public static int minCost(int[][] table){
		int m = table.length;
		int n = table[m-1].length;
		int[][] matrix = new int[m][n];

		matrix[0][0] = table[0][0];
		for(int i = 1;i < m;i++){
			matrix[0][i] = matrix[0][i-1] + table[0][i];
		}

		for(int i = 1;i < n; i++){
			matrix[i][0] = matrix[i-1][0] + table[i][0];
		}

		for(int i = 1 ; i < m;i++){
			for(int j = 1;j < n;j++){
				matrix[i][j] = min(matrix[i-1][j-1],matrix[i-1][j],matrix[i][j-1]) + table[i][j];
			}
		}
		return matrix[m-1][n-1];
	}

	public static int min(int x, int y, int z){
		if (x < y)
			return (x < z)? x : z;
		else
			return (y < z)? y : z;
	}

	public static void main(String[] args) {
		int cost[][] = 	{ 
				{1, 2, 3},
				{4, 8, 2},
				{1, 5, 3} 
		};
		System.out.println("Min cost is:"+minCost(cost));
	}

}
