package Easy;

import Helper.TreeNode;

/*
 * https://leetcode.com/problems/binary-tree-tilt/
 */
public class E_0563_BinaryTreeTilt {

	int tilt = 0;
    public int findTilt(TreeNode root) {
        if(root == null) return 0;
        findTiltHelper(root);
        return tilt;
    }
    
    public int findTiltHelper(TreeNode root) {
        if(root == null) return 0;
        int l = findTiltHelper(root.left);
        int r = findTiltHelper(root.right);
        tilt += Math.abs(l - r);
        return l + r + root.val;
    }
    public static void main(String[] args) {
    	E_0563_BinaryTreeTilt obj = new E_0563_BinaryTreeTilt();
		int[] inputArr = new int[]{6,2,2,2,3,3,3};
		TreeNode inputTree = TreeNode.constructCompleteBinaryTree(inputArr);
		System.out.println("INPUT");
		TreeNode.print(inputTree);
		System.out.println();
		System.out.println("OUTPUT");
		System.out.println(obj.findTilt(inputTree));
	}
}
