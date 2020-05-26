package Tree;
/*
 * http://www.geeksforgeeks.org/diameter-of-a-binary-tree/
 * Time Complexity: O(n)
 */
//A utility class to pass height object
class Height{
	int h;
}
public class BT_026_DiameterOfBT {

	TreeNode root;

	/* define height =0 globally and  call diameterOpt(root,height) from main */
	public int diameterOpt(TreeNode root, Height height){
		/* lh --> Height of left subtree
	           rh --> Height of right subtree */
		Height lh = new Height();
		Height rh = new Height();

		if (root == null){
			height.h = 0;
			return 0; /* diameter is also 0 */
		}

		/* ldiameter  --> diameter of left subtree
           rdiameter  --> Diameter of right subtree */ 
		/* Get the heights of left and right subtrees in lh and rh
	       And store the returned values in ldiameter and rdiameter */
		lh.h++;
		rh.h++;
		int ldiameter = diameterOpt(root.left, lh);
		int rdiameter = diameterOpt(root.right, rh);

		/* Height of current TreeNode is max of heights of left and right subtrees plus 1*/
		height.h = Math.max(lh.h, rh.h) + 1;

		return Math.max(lh.h + rh.h + 1, Math.max(ldiameter, rdiameter));
	}

	/* A wrapper over diameter(TreeNode root) */
	int diameter(){
		Height height = new Height();
		return diameterOpt(root, height);
	}

	public static void main(String args[]){
		/* creating a binary tree and entering the TreeNodes */
		BT_026_DiameterOfBT tree = new BT_026_DiameterOfBT();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);

		System.out.println("The diameter of given binary tree is : "
				+ tree.diameter());
	}
}
