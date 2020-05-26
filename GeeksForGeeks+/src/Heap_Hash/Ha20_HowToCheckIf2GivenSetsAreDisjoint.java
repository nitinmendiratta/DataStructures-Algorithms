package Heap_Hash;
import java.util.HashSet;
/*
 * http://www.geeksforgeeks.org/check-two-given-sets-disjoint/
 * Time complexity of the above implementation is O(m+n) under the assumption 
 * that hash set operations like add() and contains() work in O(1) time.
 */
public class Ha20_HowToCheckIf2GivenSetsAreDisjoint {

	// This function prints all distinct elements
    static boolean areDisjoint(int set1[], int set2[]){
        // Creates an empty hashset
        HashSet<Integer> set = new HashSet<>();
 
        // Traverse the first set and store its elements in hash
        for (int i=0; i<set1.length; i++)
            set.add(set1[i]);
 
        // Traverse the second set and check if any element of it
        // is already in hash or not.
        for (int i=0; i<set2.length; i++)
            if (set.contains(set2[i]))
                return false;
 
        return true;
    }
	public static void main(String[] args) {
		 int set1[] = {10, 5, 3, 4, 6};
	        int set2[] = {8, 7, 9, 3};
	        if (areDisjoint(set1, set2))
	            System.out.println("Yes");
	        else
	            System.out.println("No");
	}
}
