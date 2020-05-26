package Easy;

import Helper.TreeNode;

/*
 * https://leetcode.com/problems/trim-a-binary-search-tree/
 */
public class E_0669_TrimBST {

	public TreeNode trimBST(TreeNode root, int L, int R) {
		if(root == null) return null;
		if(root.val < L) return trimBST(root.right, L, R);
		if(root.val > R) return trimBST(root.left, L, R);
		root.left = trimBST(root.left, L, R);
		root.right = trimBST(root.right, L, R);
		return root;
	}

	// iterative + recursive
	public TreeNode trimBSTApproach2(TreeNode root, int L, int R) {
		if(root == null) return null;
		root = trimBSTHelper(root, L, R);
		if(root != null){
			root.left = trimBSTHelper(root.left, L, R);
			root.right = trimBSTHelper(root.right, L, R);
			trimBST(root.left, L, R);
			trimBST(root.right, L, R);
		}
		return root;
	}
	public TreeNode trimBSTHelper(TreeNode root, int L, int R) {
		while(root != null){
			if(root.val >= L && root.val <= R){
				return root;
			}
			else if(root.val < R){
				root = root.right;
			}else if(root.val > R){
				root = root.left;
			}
		}
		return null;
	}	
	public static void main(String[] args) {
		E_0669_TrimBST obj = new E_0669_TrimBST();
		int[] inputArr = new int[]{1,2,3, 1,4};
		TreeNode inputTree = TreeNode.constructBst(inputArr);
		System.out.println("INPUT");
		TreeNode.print(inputTree);
		System.out.println();
		System.out.println("OUTPUT");
		System.out.println(obj.trimBST(inputTree, 1, 2));
	}
}
