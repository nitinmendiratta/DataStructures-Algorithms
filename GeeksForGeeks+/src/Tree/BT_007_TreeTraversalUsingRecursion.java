package Tree;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
 * http://www.geeksforgeeks.org/level-order-tree-traversal/
 * http://quiz.geeksforgeeks.org/print-level-order-traversal-line-line/
 */ 
public class BT_007_TreeTraversalUsingRecursion{

    public String levelOrderTraversal(TreeNode root){
        String result = "";
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null) return null;
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode current = queue.remove();
            result = result + (char)current.data;
            if(current.left != null) queue.add(current.left);
            if(current.right != null) queue.add(current.right);
        }
        return result;
    }

    //Time complexity of this method is O(n) where n is number of nodes in given binary tree.
    public void levelOrderTraversalLineByLine(TreeNode root){
    	// Base Case
    	if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(true){
        	// nodeCount (queue size) indicates number of nodes at current level.
            int nodeCount = queue.size();
            if (nodeCount == 0) break;
            // Dequeue all nodes of current level and Enqueue all nodes of next level
	        while(nodeCount > 0){
	            TreeNode current = queue.remove();
	            System.out.print((char)current.data);
	            if(current.left != null) queue.add(current.left);
	            if(current.right != null) queue.add(current.right);
	            nodeCount--;
	        }
	        System.out.println();
        }
    }
    public void preOrderTraversal(TreeNode root){
        if(root == null) return;
        System.out.print((char)root.data);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public void inOrderTraversal(TreeNode root){
        if(root == null) return;
        inOrderTraversal(root.left);
        System.out.print((char)root.data);
        inOrderTraversal(root.right);
    }

    public void postOrderTraversal(TreeNode root){
        if(root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print((char)root.data);
    }

    public void printTree(TreeNode root){
        if(root == null) return;
        System.out.print((char)root.data+"->");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args){
        /*Code To Test the logic
	    Creating an example tree
	            F
			  /   \
			 D     J
		    / \    /\
		   B   E  G  K
          /\       \ 
         A  C       I
                   /
                  H 
        */
        BT_007_TreeTraversalUsingRecursion traverse = new BT_007_TreeTraversalUsingRecursion();
        TreeNode root = new TreeNode('F');
        root.left = new TreeNode('D');
		root.right = new TreeNode('J');
		root.left.left = new TreeNode('B');
		root.left.right = new TreeNode('E');
		root.right.left = new TreeNode('G');
		root.right.right = new TreeNode('K');
		
		root.left.left.left = new TreeNode('A');
		root.left.left.right = new TreeNode('C');
		
		root.right.left.right = new TreeNode('I');
		root.right.left.right.left = new TreeNode('H');

        traverse.printTree(root);
        System.out.println();
        System.out.println("Level Order Traversal is:"+traverse.levelOrderTraversal(root));
        System.out.println("Level Order Traversal line by line is:");
        traverse.levelOrderTraversalLineByLine(root);
        System.out.print("Preorder Traversal is:");
        traverse.preOrderTraversal(root);
        System.out.println();
        System.out.print("Postorder Traversal is:");
        traverse.postOrderTraversal(root);
        System.out.println();
        System.out.print("Inorder Traversal is:");
        traverse.inOrderTraversal(root);
        System.out.println();
    }
}
