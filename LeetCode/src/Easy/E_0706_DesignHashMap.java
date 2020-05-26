package Easy;
/*
 * https://leetcode.com/problems/design-hashmap/
 * Reference: https://leetcode.com/problems/design-hashmap/discuss/152746/Java-Solution
 */
public class E_0706_DesignHashMap {

	/*
	 * Some of the questions which can be asked to the interviewer before implementing the solution
	 * 
	 * For simplicity, are the keys integers only? 
	 * For collision resolution, can we use chaining? 
	 * Do we have to worry about load factors? Can we assume inputs are valid or do we have to validate them? 
	 * Can we assume this fits memory?
	 */
	
	//Collisions are resolved using linked list
	class ListNode {
		int key, val;
		ListNode next;

		ListNode(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}

	final ListNode[] nodes = new ListNode[10000];

	public void put(int key, int value) {
		// get existing index of the key
		int i = idx(key);
		// if not present create a node
		if (nodes[i] == null)
			nodes[i] = new ListNode(-1, -1);
		
		// find the prev node with input key in case of collision 
		// so that we can add next of this node as the new value if not present or 
		// update existing if present
		ListNode prev = find(nodes[i], key);
		if (prev.next == null)
			prev.next = new ListNode(key, value);
		else prev.next.val = value;
	}

	public int get(int key) {
		int i = idx(key);
		if (nodes[i] == null)
			return -1;
		ListNode node = find(nodes[i], key);
		return node.next == null ? -1 : node.next.val;
	}

	public void remove(int key) {
		int i = idx(key);
		if (nodes[i] == null) return;
		ListNode prev = find(nodes[i], key);
		if (prev.next == null) return;
		prev.next = prev.next.next;
	}
	// get the hashed idx of the key using its hashed value there could be collision
	int idx(int key) { 
		return Integer.hashCode(key) % nodes.length;
	}

	// return the prev node of the the node we want to find, in the collision link list
	ListNode find(ListNode bucket, int key) {
		ListNode node = bucket, prev = null;
		while (node != null && node.key != key) {
			prev = node;
			node = node.next;
		}
		return prev;
	}


	public static void main(String[] args) {
		E_0706_DesignHashMap hashMap = new E_0706_DesignHashMap();
		hashMap.put(1, 1);          
		hashMap.put(2, 2);         
		System.out.println(hashMap.get(1));;            // returns 1
		System.out.println(hashMap.get(3));            	// returns -1 (not found)
		hashMap.put(2, 1);          					// update the existing value
		System.out.println(hashMap.get(2));            // returns 1 
		hashMap.remove(2);          					// remove the mapping for 2
		System.out.println(hashMap.get(2));            // returns -1 (not found) 
	}
}
