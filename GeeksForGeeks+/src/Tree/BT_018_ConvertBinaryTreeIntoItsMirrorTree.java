package Tree;
/*
 * http://www.geeksforgeeks.org/write-an-efficient-c-function-to-convert-a-tree-into-its-mirror-tree/
 */
public class BT_018_ConvertBinaryTreeIntoItsMirrorTree {

	public static void getMirrorTree(TreeNode root){
		if(root == null) return;

		getMirrorTree(root.left);
		getMirrorTree(root.right);

		TreeNode temp;
		temp = root.left;
		root.left = root.right;
		root.right = temp;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		//root.right.left = new TreeNode(6);
		//root.right.right = new TreeNode(7);
		TreeTraversal.inOrderTraversal(root);
		getMirrorTree(root);
		System.out.println();
		TreeTraversal.inOrderTraversal(root);
	}
}
