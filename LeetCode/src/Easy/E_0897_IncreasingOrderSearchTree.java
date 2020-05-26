package Easy;

import Helper.TreeNode;

/*
 * https://leetcode.com/problems/increasing-order-search-tree/
 */
public class E_0897_IncreasingOrderSearchTree {
	
	TreeNode ptr;
	public TreeNode increasingBST(TreeNode root) {
		TreeNode res = new TreeNode(0);
		ptr = res;
		increasingBSTHelper(root);
		return res.right;
    }
    public void increasingBSTHelper(TreeNode root) {
    	if(root == null) return;
        increasingBSTHelper(root.left);
        
        root.left = null;	
        ptr.right = root;
        //ptr.right = new TreeNode(root.val);
        ptr = ptr.right;
        increasingBSTHelper(root.right);
    }
	public static void main(String[] args) {
		E_0897_IncreasingOrderSearchTree obj = new E_0897_IncreasingOrderSearchTree();
		TreeNode inputTree = TreeNode.stringToTreeNode("5,3,6,2,4,null,8,1,null,null,null,7,9");
		TreeNode outputTree = obj.increasingBST(inputTree);
		TreeNode.print(outputTree);
	}
}
