package Medium;
import java.util.Stack;
import Helper.TreeNode;
/*
 * https://leetcode.com/problems/binary-search-tree-iterator/
 */
public class M_0173_BinarySearchTreeIterator {
	
	private class DLLNode {
		int val;
		DLLNode prev;
		DLLNode next;
	}

	private DLLNode head, tail;

	public M_0173_BinarySearchTreeIterator(TreeNode root) {
		head = new DLLNode();
		head.prev = null;

		tail = new DLLNode();
		tail.next = null;

		head.next = tail;
		tail.prev = head;

		createDLL(root);
	}

	public void createDLL(TreeNode root) {
		if (root == null)
			return;

		createDLL(root.left);
		DLLNode newNode = new DLLNode();
		newNode.val = root.val;
		addNode(newNode);
		createDLL(root.right);
	}

	/** @return the next smallest number */
	public int next() {
		int val = head.next.val;
		head.next = head.next.next;
		return val;
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return head.next.next != null ? true : false;
	}

	/**
	 * Always add the new node right after head;
	 */
	private void addNode(DLLNode node) {
		tail.prev.next = node;
		node.next = tail;
		node.prev = tail.prev;
		tail.prev = node;
	}
	
	// Approach2 using stack
	class BSTIteratorApproach2 {

		Stack<TreeNode> stack;

		public BSTIteratorApproach2(TreeNode root) {

			// Stack for the recursion simulation
			this.stack = new Stack<TreeNode>();

			// Remember that the algorithm starts with a call to the helper function
			// with the root node as the input
			this._leftmostInorder(root);
		}

		private void _leftmostInorder(TreeNode root) {

			// For a given node, add all the elements in the leftmost branch of the tree
			// under it to the stack.
			while (root != null) {
				this.stack.push(root);
				root = root.left;
			}
		}

		/**
		 * @return the next smallest number
		 */
		public int next() {
			// Node at the top of the stack is the next smallest element
			TreeNode topmostNode = this.stack.pop();

			// Need to maintain the invariant. If the node has a right child, call the
			// helper function for the right child
			if (topmostNode.right != null) {
				this._leftmostInorder(topmostNode.right);
			}

			return topmostNode.val;
		}

		/**
		 * @return whether we have a next smallest number
		 */
		public boolean hasNext() {
			return this.stack.size() > 0;
		}
	}

	public static void main(String[] args) {
		TreeNode root = TreeNode.createRandomBST(4);
		System.out.println();
		TreeNode.printNode(root);
		M_0173_BinarySearchTreeIterator obj = new M_0173_BinarySearchTreeIterator(root);
		System.out.println(obj.next());
		System.out.println(obj.hasNext());
	}
}
