package Array_Matrix;
/*
 * http://www.geeksforgeeks.org/reorder-a-array-according-to-given-indexes/
 * O(n) time and O(1) extra space
 */
public class A140_ReorderAnArrayAccordingToGivenIndexes {

	// Function to reorder elements of arr[] according to index[]
	public void reorder(int arr[], int index[], int n) {
	    // Fix all elements one by one
	    for (int i=0; i<n; i++){
	        // While index[i] and arr[i] are not fixed
	        while (index[i] != i) {
	            // Store values of the target (or correct) 
	            // position before placing arr[i] there
	            int  oldTargetI  = index[index[i]];
	            int oldTargetE  = arr[index[i]];
	 
	            // Place arr[i] at its target (or correct)
	            // position. Also copy corrected index for
	            // new position
	            arr[index[i]] = arr[i];
	            index[index[i]] = index[i];
	 
	            // Copy old target values to arr[i] and
	            // index[i]
	            index[i] = oldTargetI;
	            arr[i]   = oldTargetE;
	        }
	    }
	}
	
	public static void main(String[] args) {
		A140_ReorderAnArrayAccordingToGivenIndexes obj = new A140_ReorderAnArrayAccordingToGivenIndexes();
		int arr[] = {50, 40, 70, 60, 90};
	    int index[] = {3,  0,  4,  1,  2};
	    int n = arr.length;
	    obj.reorder(arr, index, n);
	 
	    System.out.println("Reordered array is: \n");
	    for (int i=0; i<n; i++)
	        System.out.print(arr[i]+" ");
	 
	    System.out.println("\nModified Index array is: \n");
	    for (int i=0; i<n; i++)
	        System.out.print(index[i]+" ");
	}
}
