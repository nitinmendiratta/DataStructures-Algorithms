package Array_Matrix;
/*
 * http://www.geeksforgeeks.org/find-the-number-occurring-odd-number-of-times/
 * XOR of two elements is 0 if both elements are same and XOR of a number x with 0 is x.
 */
public class A003_FindNumOccurringOddNumberOfTimes {

	public int odd(int[] arr){
		int n = arr.length;
		if(n == 0 ) throw new IllegalStateException("exception");
		if(n == 1) return arr[0];

		int i = 0, result = 0;
		while(i < n){
			result = result^arr[i];
			i++;
		}
		if(result == 0) throw new IllegalStateException("exception");
		return result;
	}

	public static void main(String[] args) {
		A003_FindNumOccurringOddNumberOfTimes obj = new A003_FindNumOccurringOddNumberOfTimes();
		int[] arr = {1,1,4,4,8, 8, 8, 8};
		try{
			int result = obj.odd(arr);
			System.out.println("odd elem is:"+result);
		}
		catch(Exception e){
			System.out.println("No odd elem found");
		}
	}
}
