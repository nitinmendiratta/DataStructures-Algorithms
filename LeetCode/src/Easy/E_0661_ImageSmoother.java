package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/image-smoother/
 */
public class E_0661_ImageSmoother {

	public int[][] imageSmoother(int[][] M) {
		int r = M.length, c = M[0].length; 
		int count = 1, sum = 0;
		int[][] res = new int[r][c];

		for(int i = 0; i < r; i++){
			for(int j = 0; j < c; j++){
				count = 1;
				sum = M[i][j];
				if(j-1 >= 0){
					sum += M[i][j-1];
					count++;
				}
				if(j+1 < c){
					sum += M[i][j+1];
					count++;
				}
				if(i-1 >= 0){
					sum += M[i-1][j];
					count++;
				}
				if(i-1 >= 0 && j-1 >= 0){
					sum += M[i-1][j-1];
					count++;
				}
				if(i-1 >= 0 && j+1 < c){
					sum += M[i-1][j+1];
					count++;
				}
				if(i+1 < r){
					sum += M[i+1][j];
					count++;
				}
				if(i+1 < r && j-1 >= 0){
					sum += M[i+1][j-1];
					count++;
				}
				if(i+1 < r && j+1 < c){
					sum += M[i+1][j+1];
					count++;
				}
				System.out.println(sum);
				res[i][j] = (int) Math.floor(sum/count);
			}
		}
		return res;
	}
	public static void main(String[] args) {
		E_0661_ImageSmoother obj = new E_0661_ImageSmoother();
		int[][] input = {{1,1,1},
				{1,100,1},
				{1,1,1}};
		int[][] output = obj.imageSmoother(input);
		for(int i = 0; i < output.length; i++) {
			System.out.println(Arrays.toString(output[i]));
		}
	}
}
