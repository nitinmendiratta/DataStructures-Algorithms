package Tree;
import java.util.*;

public class MyBst{

    // To insert data in BST, returns address of root node
    public TreeNode insert(TreeNode root, int input){
        // empty tree
        if(root == null){
            TreeNode newTreeNode = new TreeNode(input);
            root = newTreeNode;
         }
        else{
            // if data to be inserted is lesser, insert in left subtree.
            if(input <= root.data)
                root.left = insert(root.left,input);
            // else, insert in right subtree.
            else
                root.right = insert(root.right,input);
        }
        return root;
    }

    /*
     * There are 3 cases to be considered in case of deleting a node
     * 1. If the node has no child- in this case we only have to set parent of the node
     *      to null
     * 2. If the node has 1 child:- in this case we need to point the child of the node 
     *      to be deleted to the parent of the node.
     * 3. If the node has 2 children:- in this case we need to replace the node to be 
     *      deleted to min of the right subtree and remove the duplicates or to 
     *      the max of the left subtree.
     */
    public TreeNode delete(TreeNode root, int input){
        if(root == null) return root;
        else if(input < root.data) root.left = delete(root.left,input);
        else if(input > root.data) root.right = delete(root.right, input);
        else if(input == root.data){
            //no child
            if(root.left == null && root.right == null) root = null;
            // 1 child
            else if(root.left == null) root = root.right;
            else if(root.right == null) root = root.left;
            // 2 children
            else{
                TreeNode temp = min(root.right);
                root.data = temp.data;
                root.right = delete(root.right,temp.data);
            }
        }
        return root;
    }

    //To search an element in BST, returns true if element is found
    public boolean search(TreeNode root, int input){
        if(root == null) return false;
        else if(input == root.data) return true;
        else if(input < root.data) return search(root.left, input);
        else return search(root.right, input);
    }

   
    public TreeNode min(TreeNode root) throws IllegalStateException{
        if(root == null){
            System.out.println("Tree is Empty");
            throw new IllegalStateException();
        }
        TreeNode ptr = root;
        while(ptr.left != null){
            ptr = ptr.left;
        }
        return ptr;
    }

    public TreeNode max(TreeNode root) throws IllegalStateException{
        if(root == null){
           throw new IllegalStateException();
        }
        TreeNode ptr = root;
        while(ptr.right != null){
            ptr = ptr.right;
        }
        return ptr;
    }

    // height is max number of edges from root to leaf node. Height of leaf node
    // is 0. So for height we take edges into consideration and not nodes.
    // if you wanna count number of nodes then just replace -1 with 0. 
    // Time Complexity is O(n)
    public int height(TreeNode root){
        if(root == null)
            return -1;
        return (Math.max(height(root.left),height(root.right)) + 1);
    }

    public void printTree(TreeNode root){
        if(root == null) return;
        System.out.println(root.data+"->");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args){
        /*Code To Test the logic
	        Creating an example tree
	            30
			  /    \
			20      40
		   /  \    /  \
		 15    25 35  45
     
       */

        MyBst bst = new MyBst();
        TreeNode root = null;
        root = bst.insert(root,30);
        root = bst.insert(root,20);
        root = bst.insert(root,25);
        root = bst.insert(root,15);
        root = bst.insert(root,40);
        root = bst.insert(root,35);
        root = bst.insert(root,45);
        bst.printTree(root);
        System.out.println(bst.search(root,41));
        try{
            System.out.println("Min elem is:"+bst.min(root).data);
            System.out.println("Max elem is:"+bst.max(root).data);
        }
        catch(IllegalStateException e){
             System.out.println("Tree is Empty");
        }
        System.out.println("Height of tree is:"+bst.height(root));
        root = bst.delete(root,40);
        bst.printTree(root);
    }
}
