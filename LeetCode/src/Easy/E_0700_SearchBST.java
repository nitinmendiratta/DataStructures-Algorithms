package Easy;

import Helper.TreeNode;

/*
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 */
public class E_0700_SearchBST {

	public TreeNode searchBST(TreeNode root, int val) {
		if(root == null) return null;
		if(root.val == val){
			return root;
		}else if(val < root.val){
			return searchBST(root.left, val);
		}else{
			return searchBST(root.right, val);
		}
	}
	public TreeNode searchBSTIterative(TreeNode root, int val) {
		while(root != null && root.val != val){
			root = val < root.val ? root.left:root.right;
		}
		return root;
	}
	public static void main(String[] args) {
		E_0700_SearchBST obj = new E_0700_SearchBST();
		int[] inputArr = new int[]{1,2,3,1,4};
		TreeNode inputTree = TreeNode.constructBst(inputArr);
		System.out.println("INPUT");
		TreeNode.print(inputTree);
		System.out.println();
		System.out.println("OUTPUT");
		TreeNode.print(obj.searchBST(inputTree, 2));
	}
}
