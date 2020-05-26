package Tree;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/connect-nodes-at-same-level/
 */

public class NC_BT_039a_ConnectNodesAtSameLevel {

	class SpecialTreeNode{
		int data;
		SpecialTreeNode left;
		SpecialTreeNode right;
		SpecialTreeNode nextRight;
		public SpecialTreeNode(int x){
			data = x;
			this.left = null;
			this.right = null;
			this.nextRight = null;
		}
	}

	// not working
	public static void connect(SpecialTreeNode root){
		/*if(root == null || (root.left == null && root.right == null)) return;

		if(root.left != null && root.right != null){
			root.left.nextRight = root.right;
			if(root.nextRight != null){
				if(root.nextRight.left != null) root.right.nextRight = root.nextRight.left;
			}
		}
		if(root.right == null){
			if(root.nextRight.left != null) root.left.nextRight = root.nextRight.left;
			else if(root.nextRight.right != null) root.left.nextRight = root.nextRight.right;
		}
		if(root.left == null){
			if(root.nextRight.left != null) root.right.nextRight = root.nextRight.left;
			else if(root.nextRight.right != null) root.right.nextRight = root.nextRight.right;
		}
		connect(root.left);
		connect(root.right);*/
	}
	//Time complexity of this method is O(n) where n is number of nodes in given binary tree.
	//    public void levelOrderTraversalLineByLine(TreeNode root){
	//    	// Base Case
	//    	if(root == null) return;
	//        Queue<TreeNode> queue = new LinkedList<TreeNode>();
	//        queue.add(root);
	//        while(true){
	//        	// nodeCount (queue size) indicates number of nodes at current level.
	//            int nodeCount = queue.size();
	//            if (nodeCount == 0) break;
	//            // Dequeue all nodes of current level and Enqueue all nodes of next level
	//	        while(nodeCount > 0){
	//	            TreeNode current = queue.remove();
	//	            System.out.print((char)current.data);
	//	            if(current.left != null) queue.add(current.left);
	//	            if(current.right != null) queue.add(current.right);
	//	            nodeCount--;
	//	        }
	//	        System.out.println();
	//        }
	//    }

	public static void main(String[] args) {
		NC_BT_039a_ConnectNodesAtSameLevel tree = new NC_BT_039a_ConnectNodesAtSameLevel();

		/* Constructed binary tree is
	             10
	            /  \
	          8     2
	         /
	        3
		 */
		//	        tree.root = new Node(10);
		//	        tree.root.left = new Node(8);
		//	        tree.root.right = new Node(2);
		//	        tree.root.left.left = new Node(3);
		//	  
		//	        // Populates nextRight pointer in all nodes
		//	        tree.connect(tree.root);
		//	  
		//	        // Let us check the values of nextRight pointers
		//	        System.out.println("Following are populated nextRight pointers in "
		//	                + "the tree" + "(-1 is printed if there is no nextRight)");
		//	        int a = tree.root.nextRight != null ? tree.root.nextRight.data : -1;
		//	        System.out.println("nextRight of " + tree.root.data + " is "
		//	                + a);
		//	        int b = tree.root.left.nextRight != null ? 
		//	                                    tree.root.left.nextRight.data : -1;
		//	        System.out.println("nextRight of " + tree.root.left.data + " is "
		//	                + b);
		//	        int c = tree.root.right.nextRight != null ? 
		//	                                   tree.root.right.nextRight.data : -1;
		//	        System.out.println("nextRight of " + tree.root.right.data + " is "
		//	                + c);
		//	        int d = tree.root.left.left.nextRight != null ? 
		//	                              tree.root.left.left.nextRight.data : -1;
		//	        System.out.println("nextRight of " + tree.root.left.left.data + " is "
		//	                + d);

	}
}
