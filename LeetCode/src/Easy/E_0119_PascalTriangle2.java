package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/pascals-triangle-ii/
 */
public class E_0119_PascalTriangle2 {
	
	public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        if (rowIndex < 0) return result;
        for (int i = 0; i <= rowIndex; i++) {
            result.add(0, 1);
            for (int j = 1; j < result.size() - 1; j++) {
                result.set(j, result.get(j) + result.get(j+1));
            }
        }
        return result;
    }
	public static void main(String[] args) {
		E_0119_PascalTriangle2 obj = new E_0119_PascalTriangle2();
		List<Integer> result = obj.getRow(2);
		for(int a : result){
			System.out.print(a);
		}
	}

}
