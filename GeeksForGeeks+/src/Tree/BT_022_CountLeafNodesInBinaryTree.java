package Tree;

/*
 * http://www.geeksforgeeks.org/write-a-c-program-to-get-count-of-leaf-nodes-in-a-binary-tree/
 */
public class BT_022_CountLeafNodesInBinaryTree {

	public static int count(TreeNode root){
		if(root == null) return 0;
		if(root.left == null && root.right == null) return 1;
		return (count(root.left)+count(root.right));
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.left.right = new TreeNode(4);
		//root.left.left.left = new TreeNode(4);
		//root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		System.out.println("Count of leaf nodes is:"+count(root));
	}

}
