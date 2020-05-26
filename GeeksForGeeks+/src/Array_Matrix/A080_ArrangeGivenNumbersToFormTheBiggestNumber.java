package Array_Matrix;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/given-an-array-of-numbers-arrange-the-numbers-to-form-the-biggest-number/
 */

public class A080_ArrangeGivenNumbersToFormTheBiggestNumber {

	public String max(List<Integer> arr){
		String result = "";
		Collections.sort(arr, new Comparator<Integer>(){
			public int compare(Integer x, Integer y){
				String a = x.toString();
				String b = y.toString();
				String ab = a+b;
				String ba = b+a;
				return ba.compareTo(ab);
			}
		});
		
		for (int i = 0; i < arr.size(); i++)result += arr.get(i);
		return result;
	}

	public static void main(String[] args) {
		A080_ArrangeGivenNumbersToFormTheBiggestNumber obj = new A080_ArrangeGivenNumbersToFormTheBiggestNumber();
		List<Integer> arr1 = new ArrayList<Integer>(Arrays.asList(7,776,7,7));
		List<Integer> arr2 = new ArrayList<Integer>(Arrays.asList(54,546,548,60));
		List<Integer> arr3 = new ArrayList<Integer>(Arrays.asList(1,34,3,98,9,76,45,4));
		System.out.println("Biggest num is:"+obj.max(arr1));
		System.out.println("Biggest num is:"+obj.max(arr2));
		System.out.println("Biggest num is:"+obj.max(arr3));
	}
}
