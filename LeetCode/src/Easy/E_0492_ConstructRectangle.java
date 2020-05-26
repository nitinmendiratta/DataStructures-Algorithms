package Easy;
import java.util.Arrays;
/*
 * https://leetcode.com/problems/construct-the-rectangle/
 */
public class E_0492_ConstructRectangle {

	public int[] constructRectangle(int area) {
		int w = (int) Math.sqrt(area);
		while (area % w != 0) w--;
		return new int[]{area/w, w};
	}
	public static void main(String[] args) {
		E_0492_ConstructRectangle obj = new E_0492_ConstructRectangle();
		System.out.println(Arrays.toString(obj.constructRectangle(12)));
	}
}
