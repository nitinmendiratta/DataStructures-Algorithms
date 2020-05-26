package Array_Matrix;

/*
 * http://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/
 * 
 * same as find-the-two-repeating-elements-in-a-given-array
 */
public class A045_FindTheRepeatingAndTheMissing {

	public int[] repeatMiss(int[] arr){
		int n = arr.length;
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

		// calculating the first set bit of the number
		int firstSetBit = xor & ~(xor-1); //ie 0010
		
		// now we will find those numbr which have their same bit set as one of the missing number
		// in this case it is 3, so we will xor 3 with the 2^2^3 ie from 1-n array and we get the missing number

		for(i = 0; i < arr.length; i++){
			if((arr[i] & firstSetBit) != 0)
				x = x ^ arr[i]; /*XOR of first set in arr[] 2^2^3 */
			else
				y = y ^ arr[i]; /*XOR of second set in arr[] 1^4^4^5 */
		}
		
		//Now we will xor 2^2^3 with those elem which have their have firstbit set in 1-n ie 2^3 so 2^2^3 ^ 2^3 would be 2
		
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
		A045_FindTheRepeatingAndTheMissing obj = new A045_FindTheRepeatingAndTheMissing();
		int a[] = {4, 3, 6, 2, 1, 1};
		int[] miss = obj.repeatMiss(a);
		System.out.println(miss[0]+","+miss[1]);
	}
}
