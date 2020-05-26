package Easy;
import java.util.*;

import Helper.TreeNode;
/*
 * https://leetcode.com/problems/diameter-of-binary-tree/
 */
public class E_0543_DiameterBinaryTree {

	int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        diameterOfBinaryTreeHelper(root);
        return diameter;
    }
    public int diameterOfBinaryTreeHelper(TreeNode root) {
        if(root == null) return 0;
        int lDepth = diameterOfBinaryTreeHelper(root.left);
        int rDepth = diameterOfBinaryTreeHelper(root.right);
        diameter = Math.max(diameter, rDepth + lDepth);
        return 1 + Math.max(rDepth, lDepth);
    }
    
    // iterative
    public int diameterOfBinaryTreeIterative(TreeNode root) {
        if( root == null){
            return 0;
        }
        int overallNodeMax = 0;
        Stack<TreeNode> nodeStack = new Stack<>();
        Map<TreeNode,Integer> nodePathCountMap = new HashMap<>();
        nodeStack.push(root);
        while(!nodeStack.isEmpty()){
            TreeNode node = nodeStack.peek();
            if(node.left != null && !nodePathCountMap.containsKey(node.left)){
                nodeStack.push(node.left);
            }else if(node.right!=null && !nodePathCountMap.containsKey(node.right)){
                nodeStack.push(node.right);
            }else {
                TreeNode rootNodeEndofPostOrder = nodeStack.pop();
                int leftMax = nodePathCountMap.getOrDefault(rootNodeEndofPostOrder.left,0);
                int rightMax = nodePathCountMap.getOrDefault(rootNodeEndofPostOrder.right,0);
                int nodeMax = 1 + Math.max(leftMax,rightMax);
                nodePathCountMap.put(rootNodeEndofPostOrder,nodeMax);
                overallNodeMax = Math.max(overallNodeMax,leftMax + rightMax );
            }
        }
        return overallNodeMax;
    } 
	public static void main(String[] args) {
		E_0543_DiameterBinaryTree obj = new E_0543_DiameterBinaryTree();
		int[] inputArr = new int[]{6,2,2,2,3,3,3};
		TreeNode inputTree = TreeNode.constructBst(inputArr);
		System.out.println("INPUT");
		TreeNode.print(inputTree);
		System.out.println();
		System.out.println("OUTPUT");
		System.out.println(obj.diameterOfBinaryTree(inputTree));
		System.out.println(obj.diameterOfBinaryTreeIterative(inputTree));
	}
}
