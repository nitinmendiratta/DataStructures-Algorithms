package Easy;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/flipping-an-image/
 */
public class E_0832_FlippingImage {

	public int[][] flipAndInvertImage(int[][] A) {

		for(int i = 0; i < A.length; i++){
			reverseAndFlip(A[i]);
		}
		return A;
	}

	public void reverseAndFlip(int[] arr){
		int i = 0, j = arr.length -1;
		while(i < j){
			int temp = arr[i];
			arr[i] = arr[j] == 0 ? 1: 0;
			arr[j] = temp == 0 ? 1: 0;
			i++;
			j--;
		}
		if(i == j) arr[i] = arr[i] == 0 ? 1: 0;
	}
	public static void main(String[] args) {
		E_0832_FlippingImage obj = new E_0832_FlippingImage();
		int[][] image = new int[][]{
			{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}
		};
		int[][] output = obj.flipAndInvertImage(image);
		for(int i = 0; i < output.length; i++) {
			System.out.println(Arrays.toString(output[i]));
		}
	}
}
