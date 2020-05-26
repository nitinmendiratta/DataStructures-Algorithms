package Array_Matrix;

/*
 * http://www.geeksforgeeks.org/counting-inversions/
 * http://stackoverflow.com/questions/337664/counting-inversions-in-an-array
 * Time Complexity: O(nlogn)
	Algorithmic Paradigm: Divide and Conquer
 */
public class A016_CountInversionsInAnArray {

	public static int countInversions(int[] a) {
		int[] temp = new int[a.length];
        return mergeSort(a, temp, 0, a.length-1);
    }

    private static int mergeSort (int[] arr, int[] temp, int left, int right) {
    	int mid, inv_count = 0;
    	if (right > left){

    		 /* Divide the array into two parts and call _mergeSortAndCountInv()
    	       for each of the parts */
    	    mid = (right + left)/2;
    	 
    	    /* Inversion count will be sum of inversions in left-part, right-part
    	      and number of inversions in merging */
    	    inv_count  = mergeSort(arr, temp, left, mid);
    	    inv_count += mergeSort(arr, temp, mid+1, right);
    	 
    	    /*Merge the two parts*/
    	    inv_count += merge(arr, temp, left, mid+1, right);
    	}
    	return inv_count;
    }
    /* This funt merges two sorted arrays and returns inversion count in
    the arrays.*/
    private static int merge (int arr[], int temp[], int left, int mid, int right) {
    	int i, j, k;
    	  int inv_count = 0;
    	 
    	  i = left; /* i is index for left subarray*/
    	  j = mid;  /* i is index for right subarray*/
    	  k = left; /* i is index for resultant merged subarray*/
    	  while ((i <= mid - 1) && (j <= right)){
    	    if (arr[i] <= arr[j]){
    	      temp[k++] = arr[i++];
    	    }
    	    else{
    	      temp[k++] = arr[j++];
    	 
    	     /*this is tricky -- see above explanation/diagram for merge()*/
    	      inv_count = inv_count + (mid - i);
    	    }
    	  }
    	 
    	  /* Copy the remaining elements of left subarray
    	   (if there are any) to temp*/
    	  while (i <= mid - 1)
    	    temp[k++] = arr[i++];
    	 
    	  /* Copy the remaining elements of right subarray
    	   (if there are any) to temp*/
    	  while (j <= right)
    	    temp[k++] = arr[j++];
    	 
    	  /*Copy back the merged elements to original array*/
    	  for (i=left; i <= right; i++)
    	    arr[i] = temp[i];
    	 
    	  return inv_count;
    }
	public static void main(String[] args) {
		A016_CountInversionsInAnArray obj = new A016_CountInversionsInAnArray();
		int[] arr = {2, 4, 1, 3, 5};
		System.out.println("Count of inversions:"+countInversions(arr));
	}
}
