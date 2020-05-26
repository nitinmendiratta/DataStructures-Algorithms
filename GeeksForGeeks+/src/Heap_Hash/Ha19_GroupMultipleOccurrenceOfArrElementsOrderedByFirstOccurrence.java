package Heap_Hash;
import java.util.HashMap;
/*
 * http://www.geeksforgeeks.org/group-multiple-occurrence-of-array-elements-ordered-by-first-occurrence/
 * Time Complexity of the above hashing based solution is O(n) under the assumption that 
 * insert, search and delete operations on HashMap take O(1) time.
 */
public class Ha19_GroupMultipleOccurrenceOfArrElementsOrderedByFirstOccurrence {

	// A hashing based method to group all occurrences of individual elements
    static void orderedGroup(int arr[]){
        // Creates an empty hashmap
        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();
 
        // Traverse the array elements, and store count for every element
        // in HashMap
        for (int i=0; i<arr.length; i++){
           // Check if element is already in HashMap
           Integer prevCount = hM.get(arr[i]);
           if (prevCount == null) 
                prevCount = 0;
            
           // Increment count of element element in HashMap 
           hM.put(arr[i], prevCount + 1);
        }
 
        // Traverse array again 
        for (int i=0; i<arr.length; i++){ 
            // Check if this is first occurrence
            Integer count =  hM.get(arr[i]);     
            if (count != null){
                // If yes, then print the element 'count' times
                for (int j=0; j<count; j++)
                   System.out.print(arr[i] + " ");
                 
                // And remove the element from HashMap.
                hM.remove(arr[i]);
            }
        }
    }
    
	public static void main(String[] args) {
		int arr[] = {10, 5, 3, 10, 10, 4, 1, 3};
        orderedGroup(arr);
	}
}
