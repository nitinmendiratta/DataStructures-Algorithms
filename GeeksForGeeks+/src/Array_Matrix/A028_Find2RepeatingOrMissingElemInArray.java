package Array_Matrix;

/*
 * http://www.geeksforgeeks.org/find-the-two-repeating-elements-in-a-given-array/
 * 
 * Find the two repeating or Missing elements in a given array
You are given an array of n+2 elements. All elements of the array are in range 1 to n. 
And all elements occur once except two numbers which occur twice. Find the two repeating numbers.

For example, array = {4, 2, 4, 5, 2, 3, 1} and n = 5
The above array has n + 2 = 7 elements with all elements occurring once except 2 and 4 which occur twice. 
So the output should be 4 2.

(Use XOR)
Let the repeating numbers be X and Y, if we xor all the elements in the array and all integers from 1 to n, then the result is X xor Y.
The 1's in binary representation of X xor Y is corresponding to the different bits between X and Y. Suppose that the kth bit of X xor Y is 1, 
we can xor all the elements in the array and all integers from 1 to n, whose kth bits are 1. The result will be one of X and Y.
 */
 
public class A028_Find2RepeatingOrMissingElemInArray {

	private int[] getRepeatedNumbers(int [] arr, int n){
		int[] result = new int[2];
		int i = 0, x = 0, y = 0;
		
		int xor = arr[0];

		for(i = 1; i < arr.length; i++){
			xor = xor^arr[i];
		}
		for(i = 1; i <= n; i++){
			xor = xor^i;
		}
		//xor will be 6 ie 2^4 ie 0110

		// calculating the rightmost set bit of the number
		int firstSetBit = xor & ~(xor-1); //ie 0010
		
		// now we will find those numbr which have their same bit set as one of the missing number
		// in this case it is 3, so we will xor 3 with the 2^2^3 ie from 1-n array and we get the missing number

		for(i = 0; i < arr.length; i++){
			if((arr[i] & firstSetBit) != 0)
				x = x ^ arr[i]; /*XOR of first set in arr[] i.e 3 */
			else
				y = y ^ arr[i]; /*XOR of second set in arr[] i.e 1^5 */
		}	
		//Now we will xor 3 with those elem which have their firstbit set in 1-n ie 2^3 so 2^3^3 would be 2	
		for(i = 1; i <= n; i++){
			if((i & firstSetBit) != 0)
				x = x ^ i; /*XOR of first set in arr[] and {1, 2, ...n }*/
			else
				y = y ^ i; /*XOR of second set in arr[] and {1, 2, ...n } */
		}	
		result[0] = x;
		result[1] = y;
		return result;
	}

	public static void main(String[] args) {
		A028_Find2RepeatingOrMissingElemInArray obj = new A028_Find2RepeatingOrMissingElemInArray();
		int a[] = {1,3,5};
		int[] miss = obj.getRepeatedNumbers(a,5);
		System.out.println(miss[0]+","+miss[1]);
	}
}
