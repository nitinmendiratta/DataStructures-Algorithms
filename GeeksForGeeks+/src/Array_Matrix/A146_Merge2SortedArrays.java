package Array_Matrix;
/*
 *http://www.geeksforgeeks.org/merge-two-sorted-arrays-o1-extra-space/
 *Time Complexity: The worst case time complexity of code/algorithm is O(m*n). 
 *The worst case occurs when all elements of ar1[] are greater than all elements of ar2[].
 */
public class A146_Merge2SortedArrays {

	// Merge ar1[] and ar2[] with O(1) extra space
	public void merge(int ar1[], int ar2[], int m, int n){
	    // Iterate through all elements of ar2[] starting from the last element
	    for (int i=n-1; i>=0; i--){
	        /* Find the smallest element greater than ar2[i]. Move all
	           elements one position ahead till the smallest greater
	           element is not found */
	        int j, last = ar1[m-1];
	        for (j=m-2; j >= 0 && ar1[j] > ar2[i]; j--)
	            ar1[j+1] = ar1[j];
	 
	        // If there was a greater element
	        if (j != m-1){
	            ar1[j+1] = ar2[i];
	            ar2[i] = last;
	        }
	    }
	}
	
	public static void main(String[] args) {
		A146_Merge2SortedArrays obj = new A146_Merge2SortedArrays();
		int ar1[] = {1, 5, 9, 10, 15, 20};
	    int ar2[] = {2, 3, 8, 13};
	    int m = ar1.length;
	    int n = ar2.length;
	    obj.merge(ar1, ar2, m, n);
	 
	    System.out.println("After Merging \nFirst Array: ");
	    for (int i=0; i<m; i++)
	        System.out.print(ar1[i] + " ");
	    System.out.println("\nSecond Array: ");
	    for (int i=0; i<n; i++)
	        System.out.print(ar2[i] + " ");
	}
}
