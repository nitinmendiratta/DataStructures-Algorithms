package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/design-hashset/
 */
public class E_0705_DesignHashSet {

	// https://leetcode.com/problems/design-hashset/discuss/355141/Java-Solution
	// https://leetcode.com/problems/design-hashset/discuss/249424/A-complete-Java-Solution-using-load-factor-BST-Rehashing!-Faster-than-90
	List<Integer>[] container = null;
	int cap = 1000;
	double loadFactor = 0.75;
	int count = 0; 
	
	/** Initialize your data structure here. */
	public E_0705_DesignHashSet() {
		container = new LinkedList[cap];
	}

	public void add(int key) {
		if(loadFactor*cap == count){
			count = 0;
			//rehash
			cap *= 2;
			List<Integer>[] oldC = container;
			container = new LinkedList[cap];
			for(int i=0; i < oldC.length; i++){
				List<Integer> list = oldC[i];
				if(list != null){
					for(int entry : list)
						this.add(entry); 
				}
			}
		}
		int hash = key % cap;
		if(container[hash] == null)
			container[hash] = new LinkedList<>();
		container[hash].add(key);
		++count;
	}

	public void remove(int key) {
		int hash = key % cap;
		List<Integer> list = container[hash];
		if(list != null){
			Iterator<Integer> itr = list.iterator();
			while(itr.hasNext())
				if(itr.next() == key){
					itr.remove();
					--count;
				}
		}
	}

	/** Returns true if this set contains the specified element */
	public boolean contains(int key) {
		int hash = key % cap;
		List<Integer> list = container[hash];
		if(list != null){
			Iterator<Integer> itr = list.iterator();
			while(itr.hasNext())
				if(itr.next() == key)
					return true;
		}
		return false;
	}
	public static void main(String[] args) {
		E_0705_DesignHashSet hashSet = new E_0705_DesignHashSet();
		hashSet.add(1);         
		hashSet.add(2);         
		System.out.println(hashSet.contains(1));    // returns true
		System.out.println(hashSet.contains(3));    // returns false (not found)
		hashSet.add(2);          
		System.out.println(hashSet.contains(2));    // returns true
		hashSet.remove(2);          
		System.out.println(hashSet.contains(2));    // returns false (already removed)
	}
}
