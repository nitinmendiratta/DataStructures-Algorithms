package Array_Matrix;
/*
 * http://www.geeksforgeeks.org/find-lost-element-from-a-duplicated-array/
 */
public class A152_FindLostEltFromDuplicatedArray {

	// This function mainly does XOR of all elements of arr1[] and arr2[]
	public void findMissing(int arr1[], int arr2[]){
		int M = arr1.length;
		int N = arr2.length;
	    if (M != N-1 && N != M-1){
	        System.out.println("Invalid Input");
	        return;
	    }
	    // Do XOR of all element
	    int res = 0;
	    for (int i=0; i<M; i++)
	       res = res^arr1[i];
	    for (int i=0; i<N; i++)
	       res = res^arr2[i];
	 
	    System.out.println("Missing element is: "+ res);
	}
	
	public static void main(String[] args) {
		A152_FindLostEltFromDuplicatedArray obj = new A152_FindLostEltFromDuplicatedArray();
		int arr1[] = {4, 1, 5, 9, 7};
	    int arr2[] = {7, 5, 9, 4};
	    obj.findMissing(arr1, arr2);
	}
}
