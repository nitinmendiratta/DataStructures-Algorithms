package Stack_Queue;
import java.util.*;
import Tree.TreeNode;;

// http://www.geeksforgeeks.org/print-ancestors-of-a-given-binary-tree-node-without-recursion/

public class S22_PrintAncestorsOfBTnodeWithoutRecursion {

	private static void printAncestors(TreeNode root, int key) {
		
		if (root == null) return;
		 
	    // Create a stack to hold ancestors
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	 
	    // Traverse the complete tree in postorder way till we find the key
	    while(true){
	        // Traverse the left side. While traversing, push the nodes into
	        // the stack so that their right subtrees can be traversed later
	        while (root != null && root.data != key){
	        	stack.push(root);   // push current node
	            root = root.left;  // move to next node
	        }
	 
	        // If the node whose ancestors are to be printed is found,
	        // then break the while loop.
	        if (root != null && root.data == key)
	            break;
	 
	        // Check if right sub-tree exists for the node at top
	        // If not then pop that node because we don't need this
	        // node any more.
	        
	        if (stack.peek().right == null){
	            root = (TreeNode) stack.pop();
	 
	            // If the popped node is right child of top, then remove the top
	            // as well. Left child of the top must have processed before.
	            // Consider the following tree for example and key = 3.  If we
	            // remove the following loop, the program will go in an
	            // infinite loop after reaching 5.
	            //          1
	            //        /   \
	            //       2     3
	            //         \
	            //           4
	            //             \
	            //              5
	            while (!stack.isEmpty() && stack.peek().right == root)
	               root = (TreeNode) stack.pop();
	        }
	 
	        // if stack is not empty then simply set the root as right child
	        // of top and start traversing right sub-tree.
	        root = stack.isEmpty()? null: stack.peek().right;
	    }
	 
	    // If stack is not empty, print contents of stack
	    // Here assumption is that the key is there in tree
	    while (!stack.isEmpty())
	        System.out.println(stack.pop().data);
		
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		printAncestors(root,7);
		printAncestors(root,3);
		printAncestors(root,5);
		//printAncestors(root,1);
	}
}
