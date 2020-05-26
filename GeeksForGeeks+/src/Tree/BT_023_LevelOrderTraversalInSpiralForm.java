package Tree;
import java.util.Stack;
/*
 * http://www.geeksforgeeks.org/level-order-traversal-in-spiral-form/
 * spiral order traversal in O(n) time and O(n) extra space,
 * The idea is to use two stacks. We can use one stack for printing from left to right and other stack for printing from right to left. 
 * In every iteration, we have nodes of one level in one of the stacks. 
 * We print the nodes, and push nodes of next level in other stack.
 */

public class BT_023_LevelOrderTraversalInSpiralForm {

	public static void printSpiral(TreeNode root){
		if(root == null) return;
		TreeNode temp;
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();

		System.out.print(root.data);
		if(root.right != null) s1.push(root.right);
		if(root.left != null) s1.push(root.left);
		
		while(!s1.isEmpty() || !s2.isEmpty()){
		
			while(!s1.isEmpty()){
				temp = s1.pop();
				System.out.print(temp.data);
				if(temp.left != null) s2.push(temp.left);
				if(temp.right != null) s2.push(temp.right);
			}

			while(!s2.isEmpty()){
				temp = s2.pop();
				System.out.print(temp.data);
				if(temp.right != null) s1.push(temp.right);
				if(temp.left != null) s1.push(temp.left);
			}
		}
	}

	public static void main(String[] args) {
				/*    1
		           /     \     
		         /         \
		       2             3
		     / \             /\
		   /     \          /   \
		  4        5      6      7*/
		  
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		//root.right.right = new TreeNode(7);
		printSpiral(root);
	}

}
