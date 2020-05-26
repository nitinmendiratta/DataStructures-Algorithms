package Array_Matrix;
/*
 * http://www.geeksforgeeks.org/leaders-in-an-array/
 */
import java.util.ArrayList;
import java.util.Arrays;

public class A014_LeadersInAnArray {

	public ArrayList<Integer> leaders(ArrayList<Integer> arr){
		int n = arr.size();
		if(n == 0 || n == 1) return arr;
		ArrayList<Integer> result = new ArrayList<Integer>();;
		int maxFromRight = arr.get(n-1);
		result.add(maxFromRight);
		
		for(int i = n-2; i >=0; i--){
			if(arr.get(i) > maxFromRight){
				maxFromRight = arr.get(i);
				result.add(maxFromRight);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		A014_LeadersInAnArray obj = new A014_LeadersInAnArray();
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(7,77,7,7));
		ArrayList<Integer> result = obj.leaders(arr);
		System.out.println(result);
	}
}
