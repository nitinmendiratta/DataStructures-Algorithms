package Tree;
/*
 * http://www.geeksforgeeks.org/check-for-children-sum-property-in-a-binary-tree/
 */
public class BT_024_CheckChildrenSumPropertyInBinaryTree {

	public static boolean check(TreeNode root){
		int leftVal = 0,rightVal = 0;
		if(root == null || (root.left == null && root.right == null)) return true;
		
		// check if left or right child is null then there data wud be 0
		if(root.left !=null) leftVal =  root.left.data;
		if(root.right != null) rightVal = root.right.data;
		
		// if sum holds then call recursively otherwise return false
		if(root.data != (leftVal + rightVal)) {
			System.out.println(root.data+" = "+leftVal+"+"+rightVal);
			return false;
		}
		else return (check(root.left) && check(root.right));
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(8);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		//root.left.right = new TreeNode(1);
		//root.right.left = new TreeNode(2);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(2);
		System.out.println("Holds children sum property:"+check(root));
	}

}
