package Tree;
/*
 * http://www.geeksforgeeks.org/convert-an-arbitrary-binary-tree-to-a-tree-that-holds-children-sum-property/
 * O(n^2), Worst case complexity is for a skewed tree such that nodes are in decreasing order from root to leaf.
 */
public class BT_025_ConvertBinaryTreeToTreeThatHoldsChildrenSumProperty {

	public static void convert(TreeNode root){
		int leftVal = 0,rightVal = 0;
		if(root == null) return;
		
		if(root.left != null) leftVal = root.left.data;
		if(root.right != null) rightVal = root.right.data;
		
		int diff = (leftVal + rightVal) - root.data;
		if(diff > 0){
			root.data += diff;
		}
		else if(diff < 0){
			if(root.left != null) root.left.data += Math.abs(diff);
			else if(root.right != null) root.right.data += Math.abs(diff);
		}
		convert(root.left);
		convert(root.right);
	}
	
	public static void main(String[] args) {
		BT_024_CheckChildrenSumPropertyInBinaryTree obj = new BT_024_CheckChildrenSumPropertyInBinaryTree();	
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(8);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(1);
		root.right.left = new TreeNode(2);
		TreeNode.print(root);
		System.out.println(obj.check(root));
		System.out.println();
		convert(root);
		System.out.println(obj.check(root));
		TreeNode.print(root);
	}
}
