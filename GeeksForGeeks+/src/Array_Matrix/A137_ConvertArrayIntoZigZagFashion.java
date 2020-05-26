package Array_Matrix;
/*
 * http://www.geeksforgeeks.org/convert-array-into-zig-zag-fashion/
 * Time complexity: O(n)
 * Auxiliary Space: O(1)
 */
public class A137_ConvertArrayIntoZigZagFashion {

	// Program for zig-zag conversion of array
	public void zigZag(int arr[]) {
	    // Flag true indicates relation "<" is expected,
	    // else ">" is expected.  The first expected relation
	    // is "<"
	    boolean flag = true;
	    int n = arr.length;
	    for (int i=0; i<=n-2; i++) {
	        if (flag) { /* "<" relation expected */
	        
	            /* If we have a situation like A > B > C,
	               we get A > B < C by swapping B and C */
	            if (arr[i] > arr[i+1])
	                swap(arr, i, i+1);
	        }
	        else {/* ">" relation expected */
	        
	            /* If we have a situation like A < B < C,
	               we get A < C > B by swapping B and C */
	            if (arr[i] < arr[i+1])
	                swap(arr,i, i+1);
	        }
	        flag = !flag; /* flip flag */
	    }
	}
	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void main(String[] args) {
		A137_ConvertArrayIntoZigZagFashion obj = new A137_ConvertArrayIntoZigZagFashion();
	 	int  arr[] = {4, 3, 7, 8, 6, 2, 1};
	   
	    obj.zigZag(arr);
	    for (int i=0; i<arr.length; i++)
		        System.out.print(arr[i]+"  ");
	}
}
