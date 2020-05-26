package Medium;
/*
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 */

public class M_0117_PopulatingNextRightPointers2 {
	
	// DFS Iterative
	public Node connect(Node root) {
		/*
		 * Approach: For each node in current level, 1. Store the first node of next
		 * level in a pointer 2. Have a pointer that will connect the nodes of next
		 * level in a level-order traversal manner 3. Move to the next level
		 */

		Node firstNodeOfThisLevel = root;

		while (firstNodeOfThisLevel != null) {

			Node dummyfirstNodeOfNextLevel = new Node(0); 	// Dummy node that will be situated before
															// first node of next level, with "next"
															// pointing to the first node

			Node currentNodeOfNextLevel = dummyfirstNodeOfNextLevel; 	// Node that will move in the next level
																		// and build the connection

			for (Node currentNodeOfThisLevel = firstNodeOfThisLevel; 				// For each node in this level
					currentNodeOfThisLevel != null; currentNodeOfThisLevel = currentNodeOfThisLevel.next) {

				if (currentNodeOfThisLevel.left != null) { 							// If this level node has left child
					currentNodeOfNextLevel.next = currentNodeOfThisLevel.left; 		// Build the connection
					currentNodeOfNextLevel = currentNodeOfNextLevel.next; 			// Move to next node
				}
				if (currentNodeOfThisLevel.right != null) { 						// If this level node has right child
					currentNodeOfNextLevel.next = currentNodeOfThisLevel.right; 	// Build the connection
					currentNodeOfNextLevel = currentNodeOfNextLevel.next; 			// Move to next node
				}
			}

			firstNodeOfThisLevel = dummyfirstNodeOfNextLevel.next; // Since this dummy node's "next" points to
																	// the actual first node of the next level,
																	// move to it
		}

		return root;
	}

	// Recursive: DFS my approach
	public Node connectApproach2(Node root) {
		if (root == null) {
			return null;
		}
		Node next = getNext(root);

		if (root.left != null) {
			root.left.next = root.right != null ? root.right : next;
		}
		if (root.right != null) {
			root.right.next = next;
		}
		connect(root.right);
		connect(root.left);

		return root;
	}

	public Node getNext(Node root) {
		if (root == null)
			return null;

		Node next = root.next;
		while (next != null) {
			if (next.left != null) {
				return next.left;
			} else if (next.right != null) {
				return next.right;
			}
			next = next.next;
		}
		return next;
	}

	// Iterative: BFS: tricky
	public Node connectApproach3(Node root) {

		Node head = root, nextHead = new Node(0), nextTail;

		while (head != null) {

			(nextTail = nextHead).next = null;
			while (head != null) {

				if (head.left != null) {
					nextTail.next = head.left;
					nextTail = head.left;
				}
				if (head.right != null) {
					nextTail.next = head.right;
					nextTail = head.right;
				}
				head = head.next;
			}
			head = nextHead.next;
		}
		return root;
	}

	public static void main(String[] args) {
		M_0117_PopulatingNextRightPointers2 obj = new M_0117_PopulatingNextRightPointers2();
		Node root = null;
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root = obj.connectApproach2(root);
	}
}
