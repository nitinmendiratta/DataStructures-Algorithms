package Heap_Hash;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;
/*
 * http://algorithms.tutorialhorizon.com/print-the-binary-tree-in-vertical-order-path/
 * http://www.geeksforgeeks.org/print-binary-tree-vertical-order-set-2/
 * Time Complexity of hashing based solution can be considered as O(n) 
 * under the assumption that we have good hashing function that allows insertion and retrieval operations in O(1) time. 
 */
class ListNode {
	int data;
	ListNode next;

	public ListNode(int data) {
		this.data = data;
		next = null;
	}
}

public class Ha4_PrintBinaryTreeInVerticalOrder {
	public static TreeMap<Integer, ArrayList> map = new TreeMap<>();;
	public static int level;
	public ArrayList<Integer> al;

	public Node vertical(Node root, int level) {
		if (root == null) {
			return null;
		}
		Node y = vertical(root.left, --level);
		if (y == null) {
			level++;
		}
		if (map.get(level) != null) {
			ArrayList x = map.get(level);
			x.add(root.key);
			map.put(level, x);
		} else {
			al = new ArrayList<>();
			al.add(root.key);
			map.put(level, al);
		}
		return vertical(root.right, ++level);
	}

	public void printResult(TreeMap map) {
		Set<Integer> i = map.keySet();
		for (int keys : i) {
			System.out.println(map.get(keys));
		}
	}

	public static void main(String args[]) {
		Ha4_PrintBinaryTreeInVerticalOrder obj = new Ha4_PrintBinaryTreeInVerticalOrder();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		obj.vertical(root, 0);
		obj.printResult(map);

	}
}