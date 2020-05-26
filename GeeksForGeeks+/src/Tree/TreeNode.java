package Tree;
import java.util.*;
/*http://www.geeksforgeeks.org/write-a-c-program-to-delete-a-tree/*/

public class TreeNode{
	public int data;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int x){
		this.data = x;
		this.left = null;
		this.right = null;
	}
	
	/*
	 * the number of nodes along the longest path from the root node down to the
	 * farthest leaf node.
	 */
	public static int height(TreeNode root) {
		if(root == null) return 0;
		
		return 1 + Math.max(height(root.left) , height(root.right));
	}
	/*  This function traverses tree in post order to 
    to delete each and every node of the tree */
	public void deleteTree(TreeNode node){
	    if (node == null)
	        return;
	
	    /* first delete both subtrees */
	    deleteTree(node.left);
	    deleteTree(node.right);
	
	    /* then delete the node */
	    System.out.println("The deleted node is " + node.data);
	    node = null;
	}
	
	public static void print(TreeNode root){
		if(root == null) return;
		System.out.print(root.data+",");
		print(root.left);
		print(root.right);
	}
}
