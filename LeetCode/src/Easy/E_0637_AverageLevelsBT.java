package Easy;
import java.util.*;

import Helper.TreeNode;
/*
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/
 */
public class E_0637_AverageLevelsBT {

	public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<Double>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        
        while(!q.isEmpty()){
            double sum = 0.0, count = 0.0, avg = 0.0;
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = q.remove();
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
                sum += curr.val;
                count++;
            }
            avg = sum/count;
            res.add(avg);
        }
        return res;
    }
	public static void main(String[] args) {
		E_0637_AverageLevelsBT obj = new E_0637_AverageLevelsBT();
		int[] inputArr = new int[]{1,2,3, -1,4};
		TreeNode inputTree = TreeNode.constructCompleteBinaryTree(inputArr);
		System.out.println("INPUT");
		TreeNode.print(inputTree);
		System.out.println();
		System.out.println("OUTPUT");
		System.out.println(obj.averageOfLevels(inputTree));
	}
}
