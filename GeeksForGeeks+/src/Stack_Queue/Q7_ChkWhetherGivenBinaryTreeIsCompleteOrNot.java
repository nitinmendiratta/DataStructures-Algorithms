package Stack_Queue;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-complete-tree-or-not/
 * 
 * A CBT is a tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible.
 * so if the right node is not present left shud also be not there but if left is present, right may or maynot be there .
 * The following trees are examples of Complete Binary Trees
    1
  /   \
 2     3

       1
    /    \
   2       3
  /
 4

       1
    /    \
   2      3
  /  \    /
 4    5  6
The following trees are examples of Non-Complete Binary Trees
    1
      \
       3

       1
    /    \
   2       3
    \     /  \   
     4   5    6

       1
    /    \
   2      3
         /  \
        4    5
        
Time Complexity: O(n) where n is the number of nodes in given Binary Tree

Auxiliary Space: O(n) for queue.
*/

class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;
	public TreeNode(int x){
		this.data = x;
		this.left = null;
		this.right = null;
	}
}

public class Q7_ChkWhetherGivenBinaryTreeIsCompleteOrNot {

	public static boolean isComplete(TreeNode root){
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
					
		if(root == null) return true;
		System.out.println("Adding:"+root.data);
		queue.add(root);
		// Create a flag variable which will be set true
		// when a non full node is seen
		boolean flag = false;
		
		while(!queue.isEmpty()){

			TreeNode temp = queue.remove();
			System.out.println("popping:"+temp.data);
			/* Check if left child is present*/
		    if(temp.left != null){
		       // If we have seen a non full node, and we see a node
		       // with non-empty left child, then the given tree is not
		       // a complete Binary Tree
		       if(flag)
		         return false;
		       
		       System.out.println("Adding: "+temp.left.data);
		       queue.add(temp.left);  // Enqueue Left Child
		    }
		    else // If this a non-full node, set the flag as true
		       flag = true;
			// only right is present
			if(temp.right != null){
					// If we have seen a non full node, and we see a node
			       // with non-empty right child, then the given tree is not
			       // a complete Binary Tree
			       if(flag == true)
			         return false;
			 
			       System.out.println("Adding: "+temp.right.data);
			       queue.add(temp.right);  // Enqueue Right Child
			}
			else // If this a non-full node, set the flag as true
		       flag = true;
		}
		return true;
	}

	public static void main(String[] args) {
	/*
	  		1
          /   \
         2     3
        / \   / \
       4   5     6	
       
     */
       
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		//root.right.left = new TreeNode(5);
		root.right.right  = new TreeNode(6);
		System.out.println("isComplete:"+isComplete(root));
	}
}
