package Array_Matrix;
/*
 * http://www.geeksforgeeks.org/find-the-two-numbers-with-odd-occurences-in-an-unsorted-array/
 */
public class A058_FindTwoNumbersWithOddOccurrencesInAnUnsortedArray {

	private int[] oddOccurrenceNumbers(int [] arr){
		int[] result = new int[2];
		int i = 0, x = 0, y = 0,set_bit_no = 0, xor = 0, n = arr.length;
		for(i = 0;i < n;i++) xor ^= arr[i];

		/* Get one set bit in the xor2. We get rightmost set bit in the following line as it is easy to get */
		set_bit_no = xor & ~(xor-1);

		/* Now divide elements in two sets: 
    	1) The elements having the corresponding bit as 1. 
    	2) The elements having the corresponding bit as 0.  */
		for(i = 0; i < n; i++){
			/* XOR of first set is finally going to hold one odd occurring number x */
			if((arr[i] & set_bit_no) > 0)
				x = x ^ arr[i];

			/* XOR of second set is finally going to hold the other odd occurring number y */
			else
				y = y ^ arr[i]; 
		}	
		result[0] = x;
		result[1] = y;
		return result;
	}

	public static void main(String[] args) {
		A058_FindTwoNumbersWithOddOccurrencesInAnUnsortedArray obj = new A058_FindTwoNumbersWithOddOccurrencesInAnUnsortedArray();
		int a[] = {4, 2, 4, 5, 2, 3, 3, 1};
		int[] miss = obj.oddOccurrenceNumbers(a);
		System.out.println("2 odd Occurrence Numbers are: "+miss[0]+","+miss[1]);
	}
}
