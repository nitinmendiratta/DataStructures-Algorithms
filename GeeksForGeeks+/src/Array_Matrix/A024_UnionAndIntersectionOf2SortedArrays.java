package Array_Matrix;
// http://www.geeksforgeeks.org/union-and-intersection-of-two-sorted-arrays-2/

public class A024_UnionAndIntersectionOf2SortedArrays {

	/* Function prints union of arr1[] and arr2[]
	   m is the number of elements in arr1[]
	   n is the number of elements in arr2[] */
	public int[] printUnion(int arr1[], int arr2[], int m, int n){
		int[] result = new int[m+n];
		int i = 0, j = 0, r = 0;
		while (i < m && j < n){
			if (arr1[i] < arr2[j])
			      result[r] = arr1[i++];
			else if (arr2[j] < arr1[i])
				result[r] = arr2[j++];
			else{
				result[r] = arr2[j++];
				i++;
			}
			r++;
		}
 
		/* Print remaining elements of the larger array */
		while(i < m){
			result[r] = arr1[i++];
			r++;
		}
		while(j < n){
			result[r] = arr2[j++];
			r++;
		}
		
		return result;
	}
	
	/* Function prints Intersection of arr1[] and arr2[]
	   m is the number of elements in arr1[]
	   n is the number of elements in arr2[] */
	public int[] printIntersection(int arr1[], int arr2[], int m, int n){
	  int[] result = new int[m+n];
	  int i = 0, j = 0, r = 0;
	  while (i < m && j < n){
	    if (arr1[i] < arr2[j])
	      i++;
	    else if (arr2[j] < arr1[i])
	      j++;
	    else /* if arr1[i] == arr2[j] */
	    {
	      result[r] = arr2[j++];
	      i++;
	      r++;
	    }
	  }
	  
	  return result;
	}
	
	public static void main(String[] args) {
		  A024_UnionAndIntersectionOf2SortedArrays obj = new A024_UnionAndIntersectionOf2SortedArrays();
		  int arr1[] = {1, 2, 4, 5, 6};
		  int arr2[] = {2, 3, 5, 7};
		  int m = arr1.length;
		  int n = arr2.length;
		  int[] result = obj.printUnion(arr1, arr2, m, n);
		  System.out.println("Union");
		  for(int i=0;i<result.length;i++){
			  System.out.print(result[i]+",");
		  };
		  System.out.println();
		  System.out.println("Intersection");
		  result = obj.printIntersection(arr1, arr2, m, n);
		  for(int i=0;i<result.length;i++){
			  System.out.print(result[i]+",");
		  };
	}
}
