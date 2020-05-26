package Hard;

import java.util.*;

/*
 * Question: https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
 * https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/discuss/85540/Java-HaspMap-LinkedHashSet-ArrayList-(155-ms)
 * I modified the code by replacing HashSet with LinkedHashSet because the set.iterator() 
 * might be costly when a number has too many duplicates.
 * Using LinkedHashSet can be considered as O(1)if we only get the first element to remove.
*/
public class H_0381_InsertDeleteGetRandomDuplicatesAllowed {

	ArrayList<Integer> numsList;
	HashMap<Integer, Set<Integer>> numLocMap;
	java.util.Random rand = new java.util.Random();

	/** Initialize your data structure here. */
	public H_0381_InsertDeleteGetRandomDuplicatesAllowed() {
		numsList = new ArrayList<Integer>();
		numLocMap = new HashMap<Integer, Set<Integer>>();
	}

	/**
	 * Inserts a value to the collection. Returns true if the collection did not
	 * already contain the specified element.
	 */
	public boolean insert(int val) {
		boolean contain = numLocMap.containsKey(val);
		if (!contain)
			numLocMap.put(val, new LinkedHashSet<Integer>());
		numLocMap.get(val).add(numsList.size());
		numsList.add(val);
		return !contain;
	}

	/**
	 * Removes a value from the collection. Returns true if the collection contained
	 * the specified element.
	 */
	public boolean remove(int val) {
		boolean contain = numLocMap.containsKey(val);
		if (!contain)
			return false;
		int loc = numLocMap.get(val).iterator().next();
		numLocMap.get(val).remove(loc);
		if (loc < numsList.size() - 1) {
			int lastone = numsList.get(numsList.size() - 1);
			numsList.set(loc, lastone);
			numLocMap.get(lastone).remove(numsList.size() - 1);
			numLocMap.get(lastone).add(loc);
		}
		numsList.remove(numsList.size() - 1);

		if (numLocMap.get(val).isEmpty())
			numLocMap.remove(val);
		return true;
	}

	/** Get a random element from the collection. */
	public int getRandom() {
		return numsList.get(rand.nextInt(numsList.size()));
	}

	public static void main(String[] args) {
		// Init an empty collection.
		H_0381_InsertDeleteGetRandomDuplicatesAllowed collection = new H_0381_InsertDeleteGetRandomDuplicatesAllowed();

		// Inserts 1 to the collection. Returns true as the collection did not contain
		// 1.
		collection.insert(1);

		// Inserts another 1 to the collection. Returns false as the collection
		// contained 1. Collection now contains [1,1].
		collection.insert(1);

		// Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
		collection.insert(2);

		// getRandom should return 1 with the probability 2/3, and returns 2 with the
		// probability 1/3.
		collection.getRandom();

		// Removes 1 from the collection, returns true. Collection now contains [1,2].
		collection.remove(1);

		// getRandom should return 1 and 2 both equally likely.
		collection.getRandom();
	}

}
