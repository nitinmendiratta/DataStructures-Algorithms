package Easy;
import java.util.*;

import Helper.TreeNode;
/*
 * https://leetcode.com/problems/binary-tree-paths/
 */
public class E_0257_BinaryTreePaths {

	public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if(root == null) return res;
        binaryTreePathsHelper(root, root.val+"", res);
        return res;
    }
    public void binaryTreePathsHelper(TreeNode root, String path, List<String> res){
        if(root.left == null && root.right == null){
            res.add(path);
        }
        if(root.left != null){
            String temp = path + "->" + root.left.val;
            binaryTreePathsHelper(root.left, temp, res);
        }
        if(root.right != null){
            String temp = path + "->" + root.right.val;
            binaryTreePathsHelper(root.right, temp, res);
        }
    }
	public static void main(String[] args) {
		E_0257_BinaryTreePaths obj = new E_0257_BinaryTreePaths();
		int[] inputArr = new int[]{6,2,8,0,4,7,9,3,5};
		TreeNode inputTree = TreeNode.constructBst(inputArr);
		System.out.println("INPUT");
		TreeNode.print(inputTree);
		System.out.println();
		System.out.println("OUTPUT");
		System.out.println(obj.binaryTreePaths(inputTree));
	}
}
