package Easy;
import java.util.Arrays;

import Helper.TreeNode;
/*
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 */
public class E_0530_MinimumAbsoluteDifferenceBST {

	TreeNode prev = null;
    int diff = Integer.MAX_VALUE;
    
    public int getMinimumDifference(TreeNode root) {
        getMinimumDifferenceHelper(root);
        return diff;
    }
    
    public void getMinimumDifferenceHelper(TreeNode root) {
        if(root == null) return;
        getMinimumDifferenceHelper(root.left);
        if(prev != null){
            diff = Math.min(diff, root.val - prev.val);
        }
        prev = root;
        getMinimumDifferenceHelper(root.right);
    }
	public static void main(String[] args) {
		E_0530_MinimumAbsoluteDifferenceBST obj = new E_0530_MinimumAbsoluteDifferenceBST();
		int[] inputArr = new int[]{6,2,2,2,3,3,3};
		TreeNode inputTree = TreeNode.constructBst(inputArr);
		System.out.println("INPUT");
		TreeNode.print(inputTree);
		System.out.println();
		System.out.println("OUTPUT");
		System.out.println(obj.getMinimumDifference(inputTree));
	}
}
