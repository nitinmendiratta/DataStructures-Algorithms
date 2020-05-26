package Tree;
/*
 * http://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-sumtree/
 */
public class BT_037_CheckIfGivenBinaryTreeIsSumTree {
	
	// APPROACH 1: Time Complexity: O(n)
	/* Utility function to check if the given node is leaf or not */
    public boolean isLeaf(TreeNode node){
        if (node == null)
            return false;
        if (node.left == null && node.right == null)
            return true;
        return false;
    }

    /* returns 1 if SumTree property holds for the given tree */
    public boolean isSumTreeApproach1(TreeNode node){
        int ls; // for sum of nodes in left subtree
        int rs; // for sum of nodes in right subtree
  
        /* If node is NULL or it's a leaf node then return true */
        if (node == null || isLeaf(node))
            return true;
  
        if (isSumTreeApproach1(node.left) && isSumTreeApproach1(node.right)){
            // Get the sum of nodes in left subtree
            if (node.left == null)
                ls = 0;
            else if (isLeaf(node.left))
                ls = node.left.data;
            else
                ls = 2 * (node.left.data);
  
            // Get the sum of nodes in right subtree
            if (node.right == null)
                rs = 0;
            else if (isLeaf(node.right))
                rs = node.right.data;
            else
                rs = 2 * (node.right.data);
              
            /* If root's data is equal to sum of nodes in left
               and right subtrees then return 1 else return 0*/
            if ((node.data == rs + ls))
                return true;
            else
                return false;
        }
  
        return false;
    }
    // APPROACH 2: 
	// Time Complexity: O(n^2) in worst case. Worst case occurs for a skewed tree.
	// A utility function to get the sum of values in tree with root as root
   public static int sum(TreeNode node){
       if (node == null)
           return 0;
       return sum(node.left) + node.data + sum(node.right);
   }
 
   /* returns 1 if sum property holds for the given node and both of its children */
   public static boolean isSumTreeApproach2(TreeNode node) {
       int ls, rs;
 
       /* If node is NULL or it's a leaf node then return true */
       if ((node == null) || (node.left == null && node.right == null))
           return true;
 
       /* Get sum of nodes in left and right subtrees */
       ls = sum(node.left);
       rs = sum(node.right);
 
       /* if the node and both of its children satisfy the property return true else false*/
       if ((node.data == ls + rs) && (isSumTreeApproach2(node.left) && isSumTreeApproach2(node.right)))
           return true;
 
       return false;
   }
	
	public static void main(String[] args) {
		BT_037_CheckIfGivenBinaryTreeIsSumTree obj = new BT_037_CheckIfGivenBinaryTreeIsSumTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		System.out.println("Approach1 IsSumTree:"+obj.isSumTreeApproach1(root));
		System.out.println("Approach2 IsSumTree:"+obj.isSumTreeApproach2(root));
		
		TreeNode root2 = new TreeNode(22);
		root2.left = new TreeNode(8);
		root2.right = new TreeNode(3);
		root2.left.left = new TreeNode(2);
		root2.left.right = new TreeNode(6);
		root2.right.right = new TreeNode(3);
		System.out.println("Approach1 IsSumTree:"+obj.isSumTreeApproach1(root2));
		System.out.println("Approach2 IsSumTree:"+obj.isSumTreeApproach2(root2));
	}
}
