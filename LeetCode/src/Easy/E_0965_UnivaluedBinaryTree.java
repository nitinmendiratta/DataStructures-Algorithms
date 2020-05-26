package Easy;

import Helper.TreeNode;

/*
 * https://leetcode.com/problems/univalued-binary-tree/
 */
public class E_0965_UnivaluedBinaryTree {

	public boolean isUnivalTree(TreeNode root) {
        return isUnivalTreeHelper(root, root.val);
    }
    public boolean isUnivalTreeHelper(TreeNode root, int value) {
        if(root == null) return true;
        return root.val == value && isUnivalTreeHelper(root.left, value) && isUnivalTreeHelper(root.right, value);
    }
	public static void main(String[] args) {
		E_0965_UnivaluedBinaryTree obj = new E_0965_UnivaluedBinaryTree();
		TreeNode inputTree = TreeNode.stringToTreeNode("1,1,1,1,1,null,1");
		System.out.println("INPUT");
		TreeNode.print(inputTree);
		System.out.println();
		System.out.println("OUTPUT");
		System.out.println(obj.isUnivalTree(inputTree));
	}
}
