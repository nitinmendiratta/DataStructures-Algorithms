package Array_Matrix;
/*
 * http://www.geeksforgeeks.org/increasing-subsequence-of-length-three-with-maximum-product/
 * http://www.ideserve.co.in/learn/increasing-subsequence-of-length-three-for-maximum-product-optimized
 * 
 * O(nLogn)
 */
public class A095_FindIncreasingSubsequenceOfLength3WithMaximumProduct {

	final static int INVALID_VALUE = -1;
    class AVLTree {
        // final static int INVALID_VALUE = -1;
        private class AVLTreeNode{
            int data;
            AVLTreeNode left;
            AVLTreeNode right;
            int height;
             
            AVLTreeNode(int data){
                this.data = data;
                this.height = 1;
            }
        }
         
        AVLTreeNode root;
         
        AVLTree(int rootValue){
            this.root = new AVLTreeNode(rootValue);
        }
         
        public AVLTree() {}
        
        int getHeight(AVLTreeNode node){
            if (node == null)
                return 0;
             
            return node.height;
        }
         
        void updateHeight(AVLTreeNode node){
            if (node == null) return;
             
            node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        }
         
         
        AVLTreeNode rotateRight(AVLTreeNode node){
            if (node == null) return node;
             
            AVLTreeNode beta  = node.left;
             
            AVLTreeNode t2  = beta.right;
             
            beta.right = node;
            node.left = t2;
             
            // we first need to update the height of node because height of beta uses height of node
            updateHeight(node);
             
            // now we update height of beta
            updateHeight(beta);
             
            return beta;
        }
         
         
        AVLTreeNode rotateLeft(AVLTreeNode node){
            if (node == null) return node;
             
            AVLTreeNode beta  = node.right;
            AVLTreeNode t2  = beta.left;
             
            beta.left = node;
            node.right = t2;
             
            // we first need to update the height of node because height of beta uses height of node
            updateHeight(node);
             
            // now we update height of beta
            updateHeight(beta);
             
            return beta;
        }
         
         
        int getBalance(AVLTreeNode node){
            if (node == null){
                return 0;
            }
            int balance;
             
            balance = getHeight(node.left) - getHeight(node.right);
             
            return balance;
        }
         
         
        int getMinValue(AVLTreeNode node){
            // though this case should not be hit ever for the usecase this function is employed for
            if (node == null) return Integer.MIN_VALUE;
             
            // if this is the left-most node
            if (node.left == null) return node.data;
             
            return getMinValue(node.left);
        }
         
        int getFloor(AVLTreeNode currentNode, int key){
            if (currentNode == null){
                return INVALID_VALUE; 
            }
             
            int floor;
             
            // if currentNode is less than key then we might find floor in right sub-tree
            // if found, return else return currentNode value
            if (currentNode.data < key){
                floor = getFloor(currentNode.right, key);
                if (floor == INVALID_VALUE){
                    return currentNode.data;
                }
            }
            else // if currentNode is greater than or equal to key, we must search in left sub-tree
            {
                floor = getFloor(currentNode.left, key);
            }
            return floor;
        }
         
        int getFloor(int key){
            return getFloor(root, key);
        }
         
        private AVLTreeNode insert(AVLTreeNode node, int key){
            // do usual BST insertion first
            if (node == null){
                return new AVLTreeNode(key);
            }
             
            if (key < node.data){
                node.left = insert(node.left, key);
            }
            else if (key > node.data){
                node.right = insert(node.right, key);
            }
            else {
                return node;
            }
             
            // now update the height of the node
            updateHeight(node);
             
            // check the balance at this node and perform rotations accordingly
            int balance = getBalance(node);
            // indicates either left-left or left-right case
            if (balance > 1){
            	// confirms left-left case
                if (key < node.left.data){
                    node = rotateRight(node);
                }
                // confirms left-right case
                else {
                    node.left = rotateLeft(node.left);
                    node = rotateRight(node);
                }
            }
            // indicates either right-right or right-left case
            else if (balance < -1) {
                if (key > node.right.data) // confirms right-right case
                {
                    node = rotateLeft(node);
                }
                else // confirms right-left case
                {
                    node.right = rotateRight(node.right);
                    node = rotateLeft(node);
                }
            }
            return node;
        }
         
        public void insert(int key)
        {
            root = insert(this.root, key);
            return;
        }
         
    }
     
    private void fillLeftGreatest(int[] array, int[] leftGreatest){
        AVLTree tree = new AVLTree();
        for (int  i = 0; i < array.length; i++){
            int floor = tree.getFloor(array[i]);
            if (floor == INVALID_VALUE){
                leftGreatest[i] = 0;
            }
            else{
                leftGreatest[i] = floor;
            }
            tree.insert(array[i]);
        }
    }
     
    private void fillRightGreatest(int[] array, int[] rightGreatest){
        int maxValueToRight = array[array.length-1];
        rightGreatest[array.length-1] = 0;
         
        for (int i = array.length-2; i >= 0; i--){
            if (array[i] > maxValueToRight){
                rightGreatest[i] = 0;
                maxValueToRight = array[i];
            }
            else{
                rightGreatest[i] = maxValueToRight;
            }
        }
    }
     
    public void findSequence(int[] array, int[] sequence){
        int[] leftGreatest = new int[array.length];
        int[] rightGreatest = new int[array.length];
         
        fillLeftGreatest(array, leftGreatest);
        fillRightGreatest(array, rightGreatest);
         
        int maxProduct = 0;
        for (int i = 0; i < array.length-1; i++){
            if ((leftGreatest[i]*array[i]*rightGreatest[i]) > maxProduct){
                maxProduct = leftGreatest[i]*array[i]*rightGreatest[i];
                sequence[0] = leftGreatest[i];
                sequence[1] = array[i];
                sequence[2] = rightGreatest[i];
            }
        }
    }
     
    public static void main(String[] args) {
    	A095_FindIncreasingSubsequenceOfLength3WithMaximumProduct solution = new A095_FindIncreasingSubsequenceOfLength3WithMaximumProduct(); 
         
        int[] testArray =  {6, 7, 8, 1, 2, 3, 9, 10};
         
        int[] sequence = new int[3]; 
        solution.findSequence(testArray,sequence);
         
        System.out.println("Increasing Sub-sequence of which would yield maximum product is: " );
        for (int i = 0; i < sequence.length; i++){
            System.out.print(sequence[i] + ", ");
        }
    }
}
