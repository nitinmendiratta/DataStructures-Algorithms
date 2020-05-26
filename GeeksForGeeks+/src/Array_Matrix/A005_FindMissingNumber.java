package Array_Matrix;
/* 
 * http://www.geeksforgeeks.org/find-the-missing-number/
 * 
 * You are given a list of n-1 integers and these integers are in the range of 1 to n. 
 * There are no duplicates in list. One of the integers is missing in the list. 
 * Write an efficient code to find the missing integer.
 * 
 * METHOD 1(Use sum formula)
 * 1. Get the sum of numbers total = n*(n+1)/2
 * 2  Subtract all the numbers from sum and you will get the missing number.
   
  METHOD 2(Use XOR)
  1) XOR all the array elements, let the result of XOR be X1.
  2) XOR all numbers from 1 to n, let XOR be X2.
  3) XOR of X1 and X2 gives the missing number.
 */
 
public class A005_FindMissingNumber {

	private int getMissingNumber(int[] arr){
		int n = arr.length;
		int x1 = arr[0];
		int x2 = 1;
		
		for(int i = 1;i < n;i++){
			x1 = x1^arr[i];
		}
		
		for(int i = 2; i <= n+1 ; i++){
			x2 = x2^i;
		}
		return x1^x2;
	}
	
	public static void main(String[] args) {
		A005_FindMissingNumber obj = new A005_FindMissingNumber();
		int a[] = {1, 2, 4, 5, 6};
    	int miss = obj.getMissingNumber(a);
    	System.out.println(miss);
	}

}
