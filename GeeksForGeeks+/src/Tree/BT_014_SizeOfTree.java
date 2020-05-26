package Tree;
/*
 * http://www.geeksforgeeks.org/write-a-c-program-to-calculate-size-of-a-tree/
 */
public class BT_014_SizeOfTree {

	public static int size(TreeNode root){
		if(root == null){
			return 0;
		}
		else{
			return (size(root.left) + 1 + size(root.right));
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		System.out.println("size of tree is:"+size(root));
	}

}
