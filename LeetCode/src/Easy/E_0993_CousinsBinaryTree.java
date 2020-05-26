package Easy;

import Helper.TreeNode;

/*
 * https://leetcode.com/problems/cousins-in-binary-tree/
 */
public class E_0993_CousinsBinaryTree {

	public boolean isCousins(TreeNode root, int x, int y) {
        //return getLevel(root, x, 1) == getLevel(root, y, 1) && differentParent(root, x, y);
		return getLevel(root, x, 1) == getLevel(root, y, 1) && getParent(root, x) != getParent(root, y);
    }

	public static int  getLevel(TreeNode root, int x, int level){
		if(root == null) return 0;
		if(root.val == x) return level;
		
		int result = getLevel(root.left, x, level+1);
		if(result != 0) return result;
		
		result = getLevel(root.right, x, level+1);
		return result;
	}
    
	public static int  getParent(TreeNode root, int x){
		if(root == null || root.val == x) return 0;
		
		if(root.left != null && root.left.val == x || root.right != null && root.right.val == x) return root.val;
		
		int result = getParent(root.left, x);
		if(result != 0) return result;
		
		result = getParent(root.right, x);
		return result;
	}
	
	
	// can be further optimized to match parent as soon as we find 1 node
    public boolean differentParent(TreeNode root, int x, int y) {
        if(root == null) return true;
        
        if((root.left != null && root.left.val == x) || (root.right != null && root.right.val == x)){
            if((root.right != null && root.right.val == y) || (root.left != null && root.left.val == y)) return false;
            return true;
        } else if((root.right != null && root.right.val == y) ||  (root.left != null && root.left.val == y)){
             if((root.right != null && root.right.val == x) || (root.left != null && root.left.val == x)) return false;
             return true;
        }
        
        return differentParent(root.left, x, y) && differentParent(root.right, x, y);
    }
    
	public static void main(String[] args) {
		E_0993_CousinsBinaryTree obj = new E_0993_CousinsBinaryTree();
		TreeNode inputTree = TreeNode.stringToTreeNode("1,2,3,null,4,null,5");
		System.out.println("INPUT");
		TreeNode.print(inputTree);
		System.out.println();
		System.out.println("OUTPUT");
		System.out.println(obj.isCousins(inputTree, 5,4));
	}
}
