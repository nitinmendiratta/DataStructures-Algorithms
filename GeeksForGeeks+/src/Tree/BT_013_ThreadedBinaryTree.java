package Tree;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/threaded-binary-tree/
 */ 
/** Class TBSTNode **/
class TBSTNode{
    int data;
    TBSTNode left, right;
    boolean leftThread, rightThread;

    public TBSTNode(int data){
        this(data, null, null, true, true);
    }

    public TBSTNode(boolean leftThread, boolean rightThread){
        this.data = Integer.MAX_VALUE;
        this.left = this;
        this.right = this;
        this.leftThread = leftThread;
        this.rightThread = rightThread;
    }

    public TBSTNode(int data, TBSTNode left, TBSTNode right, boolean leftThread, boolean rightThread){
        this.data = data;
        this.left = left;
        this.right = right;
        this.leftThread = leftThread;
        this.rightThread = rightThread;
    }
}
 
/** Class ThreadedBinarySearchTree **/
class BT_013_ThreadedBinaryTree{
    private TBSTNode root;
 
    public BT_013_ThreadedBinaryTree (){
        root = new TBSTNode(true, false);      
    }
 
    /** Function to clear tree **/
    public void clear(){
        root = new TBSTNode(true, false);  
    }
 
    /** Function to insert an element **/
    public void insert(int data){
        TBSTNode ptr = findNode(root, data);
 
        /** element already present **/
        if (ptr == null)
            return;         
 
        if (ptr.data < data){ 
            TBSTNode nptr = new TBSTNode(data, ptr, ptr.right, true, true);            
            ptr.right = nptr;
            ptr.rightThread = false;
        }
        else{
            TBSTNode nptr = new TBSTNode(data, ptr.left, ptr, true, true);         
            ptr.left = nptr;
            ptr.leftThread = false;
        }
    }
 
    /** function to find left/right most threaded node closest to the data**/
    public TBSTNode findNode(TBSTNode r, int data){
        if (r.data < data){
            if (r.rightThread)
                return r;
            return findNode(r.right, data);
        }
        else if (r.data > data){
            if (r.leftThread)
                return r;
            return findNode(r.left, data);
        }
        else
            return null;        
    }
 
    /** Function to search for an element **/
    public boolean search(int data){
        return findNode(root, data) == null;
    }
 
    /** Function to print tree **/
    public void inOrder(){
        TBSTNode temp = root;
        for (;;){
            temp = insucc(temp);
            if (temp == root)
                break;
            System.out.print(temp.data +" ");
        }
    } 
 
    /** Function to get inorder successor **/
    public TBSTNode insucc(TBSTNode tree){
        TBSTNode temp;
        temp = tree.right;
        if (!tree.rightThread)
            while (!temp.leftThread)
                temp = temp.left;
        return temp;
    }

 // Utility function to find leftmost node in a tree rooted with n
//    public TBSTNode leftMost(TBSTNode n){
//        if (n == null)
//           return null;
//     
//        while (n.left != null)
//            n = n.left;
//     
//        return n;
//    } 
//    // C code to do inorder traversal in a threaded binary tree
//    public void inOrderGFG(){
//    	TBSTNode cur = leftMost(root);
//        while (cur != null){
//            System.out.println(cur.data);
//     
//            // If this node is a thread node, then go to inorder successor
//            if (cur.rightThread)
//                cur = cur.right;
//            else // Else go to the leftmost child in right subtree
//                cur = leftMost(cur.right);
//        }
//    }
    
    public static void main(String[] args){                 
        Scanner scan = new Scanner(System.in);
        /** Creating object of ThreadedBinarySearchTree **/
        BT_013_ThreadedBinaryTree tbst = new BT_013_ThreadedBinaryTree(); 
        System.out.println("Threaded Binary Search Tree Test\n");          
        char ch;
        /**  Perform tree operations  **/
        do{
            System.out.println("\nThreaded Binary Search Tree Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. search");
            System.out.println("3. clear"); 
 
            int choice = scan.nextInt();            
            switch (choice){
            case 1 : 
                System.out.println("Enter integer element to insert");
                tbst.insert( scan.nextInt() );                     
                break;                          
            case 2 : 
                System.out.println("Enter integer element to search");
                System.out.println("Search result : "+ tbst.search( scan.nextInt() ));
                break;       
            case 3 : 
                System.out.println("\nTree Cleared\n");
                tbst.clear();
                break;           
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
            /**  Display tree  **/ 
            System.out.print("\nTree = ");
            tbst.inOrder();            
            System.out.println();
 
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');               
    }
}