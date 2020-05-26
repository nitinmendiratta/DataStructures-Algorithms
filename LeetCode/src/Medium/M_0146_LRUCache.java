package Medium;
import java.util.Hashtable;

class DLinkedNode {
	int key;
	int value;
	DLinkedNode prev;
	DLinkedNode next;
}
/*
 * https://leetcode.com/problems/lru-cache/
 * https://www.youtube.com/watch?v=S6IfqDXWa10
 */
public class M_0146_LRUCache {

	// in hashtable store key, node
	private Hashtable<Integer, DLinkedNode> cache = new Hashtable<Integer, DLinkedNode>();
	private int capacity;
	private DLinkedNode head, tail;

	public M_0146_LRUCache(int capacity) {
		this.capacity = capacity;

		head = new DLinkedNode();
		head.prev = null;

		tail = new DLinkedNode();
		tail.next = null;

		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {

		DLinkedNode node = cache.get(key);
		if (node == null) {
			return -1; // should raise exception here.
		}

		// move the accessed node to the head;
		this.moveToHead(node);

		return node.value;
	}

	public void put(int key, int value) {
		DLinkedNode node = cache.get(key);

		if (node == null) {

			DLinkedNode newNode = new DLinkedNode();
			newNode.key = key;
			newNode.value = value;

			this.cache.put(key, newNode);
			this.addNode(newNode);

			if (cache.size() > capacity) {
				// pop the tail
				DLinkedNode tail = this.popTail();
				this.cache.remove(tail.key);
			}
		} else {
			// update the value.
			node.value = value;
			this.moveToHead(node);
		}
	}

	/**
	 * Always add the new node right after head;
	 */
	private void addNode(DLinkedNode node) {

		node.prev = head;
		node.next = head.next;

		head.next.prev = node;
		head.next = node;
	}

	/**
	 * Remove an existing node from the linked list.
	 */
	private void removeNode(DLinkedNode node) {
		DLinkedNode prev = node.prev;
		DLinkedNode next = node.next;

		prev.next = next;
		next.prev = prev;
	}

	/**
	 * Move certain node in between to the head.
	 */
	private void moveToHead(DLinkedNode node) {
		this.removeNode(node);
		this.addNode(node);
	}

	// pop the current tail.
	private DLinkedNode popTail() {
		DLinkedNode res = tail.prev;
		this.removeNode(res);
		return res;
	}


	public static void main(String[] args) {
		M_0146_LRUCache cache = new M_0146_LRUCache(2);
		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1)); // returns 1
		cache.put(3, 3); // evicts key 2
		System.out.println(cache.get(2)); // returns -1 (not found)
		cache.put(4, 4); // evicts key 1
		System.out.println(cache.get(1)); // returns -1 (not found)
		System.out.println(cache.get(3)); // returns 3
		System.out.println(cache.get(4)); // returns 4
	}

}
