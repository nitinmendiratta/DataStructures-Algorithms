package Tree;
/*
 * http://www.geeksforgeeks.org/convert-a-given-tree-to-sum-tree/
 * Time Complexity: The solution involves a simple traversal of the given tree. 
 * So the time complexity is O(n) where n is the number of nodes in the given Binary Tree.
 */
public class BT_042_ConvertGivenTreeToItsSumTree {

	public static int sumTree(TreeNode root){
		// Base case
        if (root == null)
            return 0;
  
        // Store the old value
        int old_val = root.data;
  
        // Recursively call for left and right subtrees and store the sum
        // as new value of this node
        root.data = sumTree(root.left) + sumTree(root.right);
  
        // Return the sum of values of nodes in left and right subtrees
        // and old_value of this node
        return root.data + old_val;
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		//covertToSumTree(root);
		sumTree(root);
		root.print(root);
	}
}
