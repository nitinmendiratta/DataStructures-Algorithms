package Tree;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
 * 
 * Inorder Tree Traversal without Recursion
 * Time Complexity: O(n)
 */
public class TreeTraversal{

	// To insert data in BST, returns address of root node
	public TreeNode insertBST(TreeNode root, char input){
		// empty tree
		if(root == null){
			TreeNode newTreeNode = new TreeNode(input);
			root = newTreeNode;
		}
		else{
			// if data to be inserted is lesser, insert in left subtree.
			if(input <= root.data)
				root.left = insertBST(root.left,input);
			// else, insert in right subtree.
			else
				root.right = insertBST(root.right,input);
		}
		return root;
	}

	/*
	 *  1) Create an empty stack nodeStack and push root node to stack.
        2) Do following while nodeStack is not empty.
            ….a) Pop an item from stack and print it.
            ….b) Push right child of popped item to stack
            ….c) Push left child of popped item to stack

            Right child is pushed before left child to make sure that left subtree is 
            processed first.
	 */
	public void preOrderTraversal(TreeNode root){
		// Base Case
		if (root == null)   return;
		TreeNode current = root;
		// Create an empty stack and push root to it
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		/* Pop all items one by one. Do following for every popped item
        a) print it
        b) push its right child
        c) push its left child
        Note that right child is pushed first so that left is processed first 
		 */
		while(!stack.empty()){
			// Pop the top item from stack and print it
			current = stack.pop();
			System.out.print((char)current.data);
			// Push right and left children of the popped node to stack
			if(current.right != null) stack.push(current.right);
			if(current.left != null) stack.push(current.left);
		}
	}
	/*
        1) Create an empty stack S.
        2) Initialize current node as root
        3) Push the current node to S and set current = current->left until current 
            is NULL
        4) If current is NULL and stack is not empty then 
            a) Pop the top item from stack.
            b) Print the popped item, set current = current->right 
            c) Go to step 3.
        5) If current is NULL and stack is empty then we are done.
	 */
	public static void inOrderTraversal(TreeNode root){
		// Base Case
		if (root == null)   return;

		//keep the nodes in the path that are waiting to be visited
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;

		//first node to be visited will be the left one
		while (node != null) {
			stack.push(node);
			node = node.left;
		}

		// traverse the tree
		while (stack.size() > 0) {

			// visit the top node
			node = stack.pop();
			System.out.print(node.data);
			if (node.right != null) {
				node = node.right;

				// the next node to be visited is the leftmost
				while (node != null) {
					stack.push(node);
					node = node.left;
				}
			}
		}
	}
	/*http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
   	1. Initialize current as root 
	2. While current is not NULL
   		If current does not have left child
      		a) Print current�s data
      		b) Go to the right, i.e., current = current->right
   		Else
      		a) Make current as right child of the rightmost 
         		node in current's left subtree
      		b) Go to this left child, i.e., current = current->left
	 */
	public void inOrderTraversalWithoutStack(TreeNode root){
		TreeNode current, pre;

		if (root == null)
			return;

		current = root;
		while (current != null){
			if (current.left == null){
				System.out.print((char)current.data + " ");
				current = current.right;
			}
			else{
				/* Find the inorder predecessor of current */
				pre = current.left;
				while (pre.right != null && pre.right != current) 
					pre = pre.right;

				/* Make current as right child of its inorder predecessor */
				if (pre.right == null) {
					pre.right = current;
					current = current.left;
				} 

				/* Revert the changes made in if part to restore the 
                    original tree i.e.,fix the right child of predecssor*/
				else{
					pre.right = null;
					System.out.print((char)current.data + " ");
					current = current.right;
				}   /* End of if condition pre->right == NULL */

			} /* End of if condition current->left == NULL*/

		} /* End of while */
	}
	/*
	 * Algo: 
	 * 1.1 Create an empty stack
	 * 2.1 Do following while root is not NULL
	 *     a) Push root's right child and then root to stack.
	 *     b) Set root as root's left child.
	 * 2.2 Pop an item from stack and set it as root.
	 *     a) If the popped item has a right child and the right child is at top of 
	 *          stack,then remove the right child from stack,push the root back and 
	 *          set root as root's right child.
	 *     b) Else print root's data and set root as NULL.
	 * 2.3 Repeat steps 2.1 and 2.2 while stack is not empty.
	 */
	public void postOrderTraversal(TreeNode root){
		if (root == null) return;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;

		while (!stack.isEmpty() || node != null) {

			while (node != null) {
				if (node.right != null) stack.add(node.right);
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
				System.out.print((char)node.data);
				node = null;
			}
		}
	}

	public void printTree(TreeNode root){
		if(root == null) return;
		System.out.print((char)root.data+"->");
		printTree(root.left);
		printTree(root.right);
	}
}
