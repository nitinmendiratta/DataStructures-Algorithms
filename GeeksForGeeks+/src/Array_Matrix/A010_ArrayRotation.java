package Array_Matrix;
/*
 * http://www.geeksforgeeks.org/array-rotation/
 * http://www.geeksforgeeks.org/program-for-array-rotation-continued-reversal-algorithm/
 * http://www.geeksforgeeks.org/block-swap-algorithm-for-array-rotation/
 * Time complexity: O(n)
	Auxiliary Space: O(1)
 */
public class A010_ArrayRotation {

	public int[] rotate(int[] arr, int d){
	
		int n = arr.length,k,j,temp;
		int gcd = gcd(d,n);
		for(int i = 0; i < gcd; i++){
			temp = arr[i];
			j = i;
			while(true){
				k = j+d;
				if(k >= n) k = k-n;
				if(k == i) break;
				arr[j] = arr[k];
				j = k;
			}
			arr[j] = temp;
		}
		return arr;
	}	
	
	public int gcd(int a, int b){
		if(b == 0) return a;
		else return gcd(b,a%b);
	}
	
	public static void main(String[] args) {
		A010_ArrayRotation obj = new A010_ArrayRotation();
		int[] arr = {1, 4, 45, 5, 10, 8};
		arr = obj.rotate(arr,2);
		for(int i = 0; i < arr.length;i++){
			System.out.print(arr[i]+",");
		}
	}
}
