package Tree;
/*
 * http://www.geeksforgeeks.org/check-if-a-binary-tree-is-subtree-of-another-binary-tree/
 * Time Complexity: Time worst case complexity of above solution is O(mn) where m and n are number of nodes in given two trees.
 */
public class BT_038_CheckIfBinaryTreeIsSubtreeOfAnotherBinaryTree {

	/* A utility function to check whether trees with roots as root1 and
    root2 are identical or not */
	public static boolean areIdentical(TreeNode root1, TreeNode root2){

		/* base cases */
		if (root1 == null && root2 == null)
			return true;

		if (root1 == null || root2 == null)
			return false;

		/* Check if the data of both roots is same and data of left and right
        subtrees are also same */
		return (root1.data == root2.data
				&& areIdentical(root1.left, root2.left)
				&& areIdentical(root1.right, root2.right));
	}

	/* This function returns true if S is a subtree of T, otherwise false */
	public static boolean isSubtree(TreeNode T, TreeNode S) {
		/* base cases */
		if (S == null) 
			return true;

		if (T == null)
			return false;

		/* Check the tree with root as current TreeNode */
		if (areIdentical(T, S)) 
			return true;

		/* If the tree with root as current TreeNode doesn't match then
        try left and right subtrees one by one */
		return isSubtree(T.left, S)
				|| isSubtree(T.right, S);
	}
	public static void main(String[] args) {
		// t2 is a subtree of t1
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);
		root1.left.left = new TreeNode(4);
		root1.left.right = new TreeNode(5);
		root1.right.left = new TreeNode(6);
		root1.right.right = new TreeNode(7);

		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2);
		root2.right = new TreeNode(3);
		root2.left.left = new TreeNode(4);
		root2.left.right = new TreeNode(50);
		//root2.right.left = new TreeNode(6);
		//root2.right.right = new TreeNode(7);

		if (isSubtree(root1, root2))
			System.out.println("t2 is a subtree of t1");
		else
			System.out.println("t2 is not a subtree of t1");
	}
}
