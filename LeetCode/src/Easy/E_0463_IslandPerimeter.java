package Easy;
/*
 * https://leetcode.com/problems/island-perimeter/
 */
public class E_0463_IslandPerimeter {

	public int islandPerimeter(int[][] grid) {
		int height = grid.length, width = grid[0].length, perimeterCount = 0, i = 0, j = 0;
		while(i < height){
			j = 0;
			while(j < width){
				if(grid[i][j] == 1){
					if(j-1 < 0 || grid[i][j-1] == 0){
						perimeterCount++;
					}
					if(j+1 >= width || grid[i][j+1] == 0){
						perimeterCount++;
					}
					if(i-1 < 0 || grid[i-1][j] == 0){
						perimeterCount++;
					}
					if(i+1 >= height || grid[i+1][j] == 0){
						perimeterCount++;
					}
				}
				j++;
			}
			i++;
		}
		return perimeterCount;
	}
	public static void main(String[] args) {
		E_0463_IslandPerimeter obj = new E_0463_IslandPerimeter();
		int[][] grid = new int[][] {
			{1,1,0,0},
			{0,0,0,0},
			{0,0,0,0},
			{0,0,0,0}
		};
		System.out.println(obj.islandPerimeter(grid));
	}
}
