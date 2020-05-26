package Easy;
import java.util.*;

import Helper.TreeNode;
/*
 * https://leetcode.com/problems/leaf-similar-trees/
 */
public class E_0872_LeafSimilarTrees {

	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		List<Integer> res1 = new ArrayList<Integer>();
		List<Integer> res2 = new ArrayList<Integer>();
		leafSimilarHelper(root1, res1);
		leafSimilarHelper(root2, res2);
        return res1.equals(res2);
    }
    
    public void leafSimilarHelper(TreeNode root, List<Integer> res) {
        if(root != null){
            if(root.left == null && root.right == null)
                res.add(root.val);
            leafSimilarHelper(root.left, res);
            leafSimilarHelper(root.right, res);
        }
    }
	public static void main(String[] args) {
		E_0872_LeafSimilarTrees obj = new E_0872_LeafSimilarTrees();
		TreeNode inputTree1 = TreeNode.stringToTreeNode("3,5,1,6,2,9,8,null,null,7,4");
		TreeNode inputTree2 = TreeNode.stringToTreeNode("3,5,1,6,7,4,2,null,null,null,null,null,null,9,8");
		System.out.println(obj.leafSimilar(inputTree1, inputTree2));
	}
}
