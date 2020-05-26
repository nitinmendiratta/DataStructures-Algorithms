package Helper;

import java.util.*;

public class TreeTraversal {

	/*
	 * 1) Create an empty stack nodeStack and push root node to stack. 2) Do
	 * following while nodeStack is not empty. ….a) Pop an item from stack and
	 * print it. ….b) Push right child of popped item to stack ….c) Push left
	 * child of popped item to stack
	 * 
	 * Right child is pushed before left child to make sure that left subtree is
	 * processed first.
	 */
	public static List<Integer> preOrderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList();
		// Base Case
		if (root == null)
			return res;
		TreeNode current = root;
		// Create an empty stack and push root to it
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		/*
		 * Pop all items one by one. Do following for every popped item a) print it b)
		 * push its right child c) push its left child Note that right child is pushed
		 * first so that left is processed first
		 */
		while (!stack.empty()) {
			// Pop the top item from stack and print it
			current = stack.pop();
			res.add(current.val);
			// Push right and left children of the popped node to stack
			if (current.right != null)
				stack.push(current.right);
			if (current.left != null)
				stack.push(current.left);
		}
		return res;
	}
	
	// Recursive
	public static List<Integer> preOrderTraversalRecursive(TreeNode root) {
		List<Integer> res = new ArrayList();
		preorderTraversalRecursiveHelper(root, res);
		return res;
	}

	public static void preorderTraversalRecursiveHelper(TreeNode root, List<Integer> res) {

		if (root == null)
			return;
		res.add(root.val);
		preorderTraversalRecursiveHelper(root.left, res);
		preorderTraversalRecursiveHelper(root.right, res);
	}

	/*
	 * http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
	 * 
	 * Inorder Tree Traversal without Recursion Time Complexity: O(n)
	 * 
	 * 1) Create an empty stack S. 2) Initialize current node as root 3) Push the
	 * current node to S and set current = current->left until current is NULL 4) If
	 * current is NULL and stack is not empty then a) Pop the top item from stack.
	 * b) Print the popped item, set current = current->right c) Go to step 3. 5) If
	 * current is NULL and stack is empty then we are done.
	 */
	public static void inOrderTraversal(TreeNode root) {
		// Base Case
		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = root;
		while (curr != null || !stack.isEmpty()) {
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			System.out.print(curr.val);
			curr = curr.right;
		}
	}

	/*
	 * Morris Traversal
	 * http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-
	 * without-stack/ 1. Initialize current as root 2. While current is not NULL If
	 * current does not have left child a) Print current�s val b) Go to the right,
	 * i.e., current = current->right Else a) Make current as right child of the
	 * rightmost node in current's left subtree b) Go to this left child, i.e.,
	 * current = current->left
	 */
	public static void inOrderTraversalWithoutStack(TreeNode root) {
		TreeNode current, pre;

		if (root == null)
			return;

		current = root;
		while (current != null) {
			if (current.left == null) {
				System.out.print((char) current.val + " ");
				current = current.right;
			} else {
				/* Find the inorder predecessor of current */
				pre = current.left;
				while (pre.right != null && pre.right != current)
					pre = pre.right;

				/* Make current as right child of its inorder predecessor */
				if (pre.right == null) {
					pre.right = current;
					current = current.left;
				}

				/*
				 * Revert the changes made in if part to restore the original tree i.e.,fix the
				 * right child of predecssor
				 */
				else {
					pre.right = null;
					System.out.print((char) current.val + " ");
					current = current.right;
				} /* End of if condition pre->right == NULL */

			} /* End of if condition current->left == NULL */

		} /* End of while */
	}

	/*
	 * Algo: 1.1 Create an empty stack 2.1 Do following while root is not NULL a)
	 * Push root's right child and then root to stack. b) Set root as root's left
	 * child. 2.2 Pop an item from stack and set it as root. a) If the popped item
	 * has a right child and the right child is at top of stack,then remove the
	 * right child from stack,push the root back and set root as root's right child.
	 * b) Else print root's val and set root as NULL. 2.3 Repeat steps 2.1 and 2.2
	 * while stack is not empty.
	 */
	public static void postOrderTraversal(TreeNode root) {
		if (root == null)
			return;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;

		while (!stack.isEmpty() || node != null) {

			while (node != null) {
				if (node.right != null)
					stack.add(node.right);
				stack.add(node);
				node = node.left;
			}

			node = stack.pop();

			// (node.right) != null means this node is parent of that tiny subtree
			// stack.pop != null ensures it was not the root.
			if (node.right != null && !stack.empty() && node.right == stack.peek()) {
				TreeNode nodeRight = stack.pop();
				stack.push(node);
				node = nodeRight;
			} else {
				System.out.print((char) node.val);
				node = null;
			}
		}
	}

	// Level Order Traversal
	public static List<List<Integer>> levelOrderTraversal(TreeNode root) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList();
		queue.add(root);

		while (!queue.isEmpty()) {

			int len = queue.size(), i = 0;
			List<Integer> temp = new ArrayList();
			while (i < len) {
				TreeNode cur = queue.remove();
				if (cur.left != null)
					queue.add(cur.left);
				if (cur.right != null)
					queue.add(cur.right);
				temp.add(cur.val);
				i++;
			}
			res.add(temp);
		}
		return res;
	}
	
	// Recursive Level Order Traversal
	public List<List<Integer>> levelOrderRecursive(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelHelper(res, root, 0);
        return res;
    }
    
    public void levelHelper(List<List<Integer>> res, TreeNode node, int level) {
        if (node == null) return;
        if (level == res.size()) {
            res.add(new LinkedList<Integer>());
        }
        res.get(level).add(node.val);
        levelHelper(res, node.left, level+1);
        levelHelper(res, node.right, level+1);
    }
    
	public static void printTree(TreeNode root) {
		if (root == null)
			return;
		System.out.print((char) root.val + "->");
		printTree(root.left);
		printTree(root.right);
	}
}
