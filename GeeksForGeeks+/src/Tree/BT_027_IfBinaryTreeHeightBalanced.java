package Tree;
/*
 * http://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
 * Time Complexity: O(n)
 */
//A wrapper class used to modify height across recursive calls.

public class BT_027_IfBinaryTreeHeightBalanced {
	TreeNode root;
	class Height{
		int height = 0;
	}
	
	boolean isBalanced(TreeNode root){
		Height height = new Height();
		return isBalancedUtil(root, height);
	}
	/* Returns true if binary tree with root as root is height-balanced */
	boolean isBalancedUtil(TreeNode root, Height height){
		/* If tree is empty then return true */
		if (root == null){
			height.height = 0;
			return true;
		}

		/* Get heights of left and right sub trees */
		Height lheight = new Height();
		Height rheight = new Height();
		boolean l = isBalancedUtil(root.left, lheight);
		boolean r = isBalancedUtil(root.right, rheight);
		int lh = lheight.height, rh = rheight.height;

		/* Height of current TreeNode is max of heights of left and right subtrees plus 1*/
		height.height = Math.max(lh,rh) + 1;

		/* If difference between heights of left and right
           subtrees is more than 2 then this TreeNode is not balanced so return 0 */
		if ((lh - rh >= 2) ||(rh - lh >= 2))
			return false;

		/* If this TreeNode is balanced and left and right subtrees are balanced then return true */
		else return l && r;
	}


	/*  The function Compute the "height" of a tree. Height is the number of TreeNodes along the 
	 * longest path from the root TreeNode down to the farthest leaf TreeNode.*/
	int height(TreeNode TreeNode){
		/* base case tree is empty */
		if (TreeNode == null)
			return 0;

		/* If tree is not empty then height = 1 + max of left height and right heights */
		return 1 + Math.max(height(TreeNode.left), height(TreeNode.right));
	}

	public static void main(String args[]){
		

		/* Constructed binary tree is
	                   1
	                 /   \
	                2      3
	              /  \    /
	            4     5  6
	            /
	           7         */
		BT_027_IfBinaryTreeHeightBalanced tree = new BT_027_IfBinaryTreeHeightBalanced();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		tree.root.right.right = new TreeNode(6);
		tree.root.left.left.left = new TreeNode(7);

		if (tree.isBalanced(tree.root))
			System.out.println("Tree is balanced");
		else
			System.out.println("Tree is not balanced");
	}
}
