package Tree;
/*
 * http://www.geeksforgeeks.org/write-a-c-program-to-find-the-maximum-depth-or-height-of-a-tree/
 */
public class BT_016_MaximumDepthOrHeightOfTree {

	public static int height(TreeNode root){
		if(root == null) return -1 ;
		return 1+ (Math.max(height(root.left),height(root.right)));
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		System.out.println("height is:"+height(root));
	}
}
