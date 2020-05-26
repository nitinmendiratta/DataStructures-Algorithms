package Medium;

import Helper.TreeNode;

/*
 * 
 */
public class M_0114_FlattenBinaryTreeToLinkedList {

	public void flatten(TreeNode root) {
		flatten(root, null);
	}

	private TreeNode flatten(TreeNode root, TreeNode pre) {
		if (root == null)
			return pre;

		pre = flatten(root.right, pre);
		pre = flatten(root.left, pre);
		root.right = pre;
		root.left = null;
		pre = root;
		return pre;
	}

	// Iterative
	public void flattenApproach2(TreeNode root) {
		TreeNode cur = root;
		while (cur != null) {

			if (cur.left != null) {

				TreeNode last = cur.left;
				while (last.right != null)
					last = last.right;

				last.right = cur.right;
				cur.right = cur.left;
				cur.left = null;
			}
			cur = cur.right;
		}
	}

	// My approach
	public void flattenApproach3(TreeNode root) {
		if (root == null)
			return;

		flatten(root.left);

		TreeNode temp = root.right;
		if (root.left != null) {
			root.right = root.left;
			root.left = null;
			while (root.right != null)
				root = root.right;
			root.right = temp;
		}

		flatten(temp);
	}

	public static void main(String[] args) {
		M_0114_FlattenBinaryTreeToLinkedList obj = new M_0114_FlattenBinaryTreeToLinkedList();
		TreeNode root = TreeNode.createRandomBST(4);
		System.out.println();
		TreeNode.printNode(root);
		obj.flatten(root);
		TreeNode.printNode(root);
	}
}
