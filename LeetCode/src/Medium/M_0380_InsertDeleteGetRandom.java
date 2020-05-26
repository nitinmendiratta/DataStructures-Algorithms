package Medium;
import java.util.*;
/*
 * https://leetcode.com/problems/insert-delete-getrandom-o1/
 */
public class M_0380_InsertDeleteGetRandom {
	
	ArrayList<Integer> numsList; // list to store all elements
	HashMap<Integer, Integer> numLocMap; // map to store elt and its location in the list
	java.util.Random rand = new java.util.Random();

	/** Initialize your data structure here. */
	public M_0380_InsertDeleteGetRandom() {
		numsList = new ArrayList<Integer>();
		numLocMap = new HashMap<Integer, Integer>();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already contain
	 * the specified element.
	 */
	public boolean insert(int val) {
		boolean contain = numLocMap.containsKey(val);
		if (contain)
			return false;
		numLocMap.put(val, numsList.size());
		numsList.add(val);
		return true;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the specified
	 * element.
	 */
	public boolean remove(int val) {
		boolean contain = numLocMap.containsKey(val);
		if (!contain)
			return false;
		int loc = numLocMap.get(val);
		if (loc < numsList.size() - 1) { // not the last one than swap the last one with this val
			int lastone = numsList.get(numsList.size() - 1);
			numsList.set(loc, lastone); // move last elt to curr elts position
			numLocMap.put(lastone, loc); // update last elt position in the map
		}
		numLocMap.remove(val);
		numsList.remove(numsList.size() - 1);
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		return numsList.get(rand.nextInt(numsList.size()));
	}

	public static void main(String[] args) {
		M_0380_InsertDeleteGetRandom randomSet = new M_0380_InsertDeleteGetRandom();
		// Inserts 1 to the set. Returns true as 1 was inserted successfully.
		System.out.println(randomSet.insert(1));

		// Returns false as 2 does not exist in the set.
		System.out.println(randomSet.remove(2));

		// Inserts 2 to the set, returns true. Set now contains [1,2].
		randomSet.insert(2);

		// getRandom should return either 1 or 2 randomly.
		randomSet.getRandom();

		// Removes 1 from the set, returns true. Set now contains [2].
		randomSet.remove(1);

		// 2 was already in the set, so return false.
		randomSet.insert(2);

		// Since 2 is the only number in the set, getRandom always return 2.
		randomSet.getRandom();
	}
}
