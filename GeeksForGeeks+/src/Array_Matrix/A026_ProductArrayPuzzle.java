package Array_Matrix;

/*
 * http://www.geeksforgeeks.org/a-product-array-puzzle/
 * http://stackoverflow.com/questions/2680548/given-an-array-of-numbers-return-array-of-products-of-all-other-numbers-no-div
 * 
 * Given an array arr[] of n integers, construct a Product Array prod[] (of same size) such that prod[i] is equal to the product of 
 * all the elements of arr[] except arr[i]. Solve it without division operator and in O(n).
 */
public class A026_ProductArrayPuzzle {

	public int[] product(int[] arr){
		int n = arr.length;
		int temp = 1,i = 0;
		int[] prod = new int[n];
		for(i = 0;i < n;i++) prod[i] = 1;
		
		for(i = 0; i < n;i++){
			prod[i] = temp;
			temp *= arr[i];
		}
		
		temp = 1;
		
		for(i = n-1;i >= 0;i--){
			prod[i] *= temp;
			temp *= arr[i];
		}
		
		return prod;
	}
	
	public static void main(String[] args) {
		A026_ProductArrayPuzzle obj = new A026_ProductArrayPuzzle();
		int[] arr = {10, 3, 5, 6, 2};
		arr = obj.product(arr);
		for(int i = 0; i < arr.length;i++){
			System.out.print(arr[i]+",");
		}
	}
}
