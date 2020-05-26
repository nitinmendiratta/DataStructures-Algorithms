package Medium;
/*
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */

class Node {
	public int val;
	public Node left;
	public Node right;
	public Node next;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, Node _left, Node _right, Node _next) {
		val = _val;
		left = _left;
		right = _right;
		next = _next;
	}
};

public class M_0116_PopulatingNextRightPointers {

	// Recursive: DFS
	public Node connect(Node root) {
		if (root == null) {
			return null;
		}
		if (root.left != null)
			root.left.next = root.right;
		if (root.right != null && root.next != null) {
			root.right.next = root.next.left;
		}
		connect(root.left);
		connect(root.right);
		return root;
	}

	// Iterative: BFS
	public void connectApproach2(Node root) {
		Node level_start = root;
		while (level_start != null) {
			Node cur = level_start;
			
			while (cur != null) {
				if (cur.left != null)
					cur.left.next = cur.right;
				if (cur.right != null && cur.next != null)
					cur.right.next = cur.next.left;

				cur = cur.next;
			}
			level_start = level_start.left;
		}
	}

	public static void main(String[] args) {
		M_0116_PopulatingNextRightPointers obj = new M_0116_PopulatingNextRightPointers();
		Node root = null;
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root = obj.connect(root);

	}
}
