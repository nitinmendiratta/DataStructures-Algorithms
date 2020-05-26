package Array_Matrix;
import java.util.HashSet;
/*
 * http://quiz.geeksforgeeks.org/print-distinct-elements-given-integer-array/
 * O(n) time
 */
public class A115_PrintAllDistinctElementsOfIntegerArray {

	// This function prints all distinct elements
    public void printDistinct(int arr[]){
        // Creates an empty hashset
        HashSet<Integer> set = new HashSet<>();
 
        // Traverse the input array
        for (int i=0; i<arr.length; i++){
            // If not present, then put it in hashtable and print it
            if (!set.contains(arr[i])){
                set.add(arr[i]);
                System.out.print(arr[i] + " ");
            }
        }
    }
    
	public static void main(String[] args) {
		A115_PrintAllDistinctElementsOfIntegerArray obj = new A115_PrintAllDistinctElementsOfIntegerArray();
		int arr[] = {10, 5, 3, 4, 3, 5, 6};
        obj.printDistinct(arr);
	}

}
