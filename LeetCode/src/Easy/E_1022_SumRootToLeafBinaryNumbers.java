package Easy;

import java.util.Stack;

import Helper.TreeNode;

/*
 * https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
 */
public class E_1022_SumRootToLeafBinaryNumbers {

	/*
	 * Recursive
	 */
	int total = 0;
	public int sumRootToLeaf(TreeNode root) {
		sumRootToLeafHelper(root, 0);
		return total;
	}
	public void sumRootToLeafHelper(TreeNode root, int path) {

		if(root ==  null) return;
		path = (path<<1) | root.val;
		if(root.left == null && root.right == null) {
			total += path;
			return;
		}
		sumRootToLeafHelper(root.left, path);
		sumRootToLeafHelper(root.right, path);
	}
	/*
	 * maintain pathsum so far and node in 2 diff stack
	 */
	public int sumRootToLeafIterative(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> stackTreeNode = new Stack<>();
        Stack<Integer> stackNodeValue = new Stack<>();
        
        stackTreeNode.push(root);
        stackNodeValue.push(root.val);
        
        int sum = 0;
        
        while (!stackTreeNode.isEmpty()) {
            TreeNode node = stackTreeNode.pop();
            Integer pathSum = stackNodeValue.pop(); //path sum so far
            
            if (node.left != null) {
            	//If left child is not empty, store left child and path sum up to left child
            	stackTreeNode.push(node.left);
            	stackNodeValue.push((pathSum<<1) | node.left.val);
            }
            
            if (node.right != null) {
            	//If right child is not empty, store child child and path sum up to right child
            	stackTreeNode.push(node.right);
            	stackNodeValue.push((pathSum<<1) | node.right.val);
            }
            
            if (node.left == null && node.right == null) { 
            	//If current node is at the end of the path with no children, add path sum to total sum
                sum += pathSum;
            }
        }
        return sum;
    }
	public static void main(String[] args) {
		E_1022_SumRootToLeafBinaryNumbers obj = new E_1022_SumRootToLeafBinaryNumbers();
		TreeNode inputTree = TreeNode.stringToTreeNode("1,0,1,0,1,0,1");
		System.out.println("INPUT");
		TreeNode.print(inputTree);
		System.out.println();
		System.out.println("OUTPUT");
		System.out.println(obj.sumRootToLeaf(inputTree));
		System.out.println(obj.sumRootToLeafIterative(inputTree));
	}
}
