package Easy;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/flood-fill/
 */
public class E_0733_FloodFill {

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int startColor = image[sr][sc];
		floodFillHelper(image, sr, sc, newColor, startColor);
		return image;
	}
	public void floodFillHelper(int[][] image, int sr, int sc, int newColor, int startColor) {
		if(sr >= image.length || sr < 0 || sc < 0 || sc >= image[0].length) {
			return;
		}
		int currColor = image[sr][sc];
		if(currColor == startColor && currColor != newColor) {
			image[sr][sc] = newColor;
		}else 
			return;
		
		floodFillHelper(image, sr-1, sc, newColor, startColor);
		floodFillHelper(image, sr+1, sc, newColor, startColor);
		floodFillHelper(image, sr, sc-1, newColor, startColor);
		floodFillHelper(image, sr, sc+1, newColor, startColor);
	}
	public static void main(String[] args) {
		E_0733_FloodFill obj = new E_0733_FloodFill();
		int[][] image = new int[][] {
			{0, 0, 0},
			{0, 1, 1}
		};
		int[][] output = obj.floodFill(image, 1, 1, 1);
		for(int i = 0; i < output.length; i++) {
			System.out.println(Arrays.toString(output[i]));
		}
	}
}
