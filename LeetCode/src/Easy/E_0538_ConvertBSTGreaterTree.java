package Easy;

import Helper.TreeNode;

/*
 * https://leetcode.com/problems/convert-bst-to-greater-tree/
 */
public class E_0538_ConvertBSTGreaterTree {

	TreeNode prev = null;

	public TreeNode convertBST(TreeNode root) {
		if(root == null) return null;
		convertBST(root.right);
		if(prev != null){
			root.val = root.val + prev.val;
		}
		prev = root;
		convertBST(root.left);
		return root;
	}
	public static void main(String[] args) {
		E_0538_ConvertBSTGreaterTree obj = new E_0538_ConvertBSTGreaterTree();
		int[] inputArr = new int[]{6,2,2,2,3,3,3};
		TreeNode inputTree = TreeNode.constructBst(inputArr);
		System.out.println("INPUT");
		TreeNode.print(inputTree);
		System.out.println();
		System.out.println("OUTPUT");
		TreeNode.print(obj.convertBST(inputTree));
	}
}
