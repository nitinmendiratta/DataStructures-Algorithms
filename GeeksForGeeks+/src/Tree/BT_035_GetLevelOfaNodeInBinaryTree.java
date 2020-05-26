package Tree;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/get-level-of-a-node-in-a-binary-tree/
 * Time Complexity: O(n) where n is the number of nodes in the given Binary Tree.
 */

public class BT_035_GetLevelOfaNodeInBinaryTree {

	public static int getLevel(TreeNode root, int x){
		return getActualLevel(root,x,1);
	}
	
	public static int  getActualLevel(TreeNode root, int x, int level){
		if(root == null) return 0;
		if(root.data == x) return level;
		
		int result = getActualLevel(root.left,x,level+1);
		if(result != 0) return result;
		
		result = getActualLevel(root.right,x,level+1);
		return result;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		System.out.println("Level is:"+getLevel(root,7));
	}
}
