package Greedy_Backtracking_PS_DnC;

/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-9-binomial-coefficient/
 * 
 * the below problem tells you coefficient of x^k in (1+x)^n
 * 
 */
public class BinomialCoefficient {

	public static int coefficient(int n, int k){
		int[][] matrix = new int[n+1][k+1];
		
		for(int i = 0; i <= n; i++){
			for(int j = 0; j <= Math.min(i,k); j++){
				
				if(j == 0 || j == i){
					matrix[i][j] = 1;
				}
				else
					matrix[i][j] = matrix[i-1][j-1] + matrix[i-1][j];
			}
		}
		return matrix[n][k];
	}
	
	public static void main(String[] args) {
		int n = 2, k = 0;
		System.out.println("Coefficient of x^"+k+" in (1+x)^"+n+" is:"+coefficient(n,k));
	}

}
