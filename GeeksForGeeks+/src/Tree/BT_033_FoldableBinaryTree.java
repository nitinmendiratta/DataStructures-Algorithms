package Tree;
/*
 * http://www.geeksforgeeks.org/foldable-binary-trees/
 * Time complexity: O(n)
 */
public class BT_033_FoldableBinaryTree {

	public static boolean isFoldable(TreeNode root){
		if(root == null) return true;
		BT_018_ConvertBinaryTreeIntoItsMirrorTree.getMirrorTree(root.left);
		
		boolean result = isStructSame(root.left,root.right);
		
		/* Get the originial tree back */
		BT_018_ConvertBinaryTreeIntoItsMirrorTree.getMirrorTree(root.left);
		return result;
	}
	
	public static boolean isStructSame(TreeNode a, TreeNode b){
		if(a == null && b == null) return true;
		if(a != null && b != null && isStructSame(a.left, b.left) && isStructSame(a.right, b.right))return true;
		return false;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(7);
		root.right = new TreeNode(15);
		//root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(9);
		root.right.left = new TreeNode(11);
		//root.right.right = new TreeNode(7);
		System.out.println("isFoldable:"+isFoldable(root));
	}
}
