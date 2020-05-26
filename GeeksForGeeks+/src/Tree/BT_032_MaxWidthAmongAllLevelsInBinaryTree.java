package Tree;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/maximum-width-of-a-binary-tree/
 */
public class BT_032_MaxWidthAmongAllLevelsInBinaryTree {

	// Function to find the maximum width of the tree using level order traversal
	//The Queue based level order traversal will take O(n) time in worst case. 
    public static int maxwidthQueueBased(TreeNode root){
        // Base case
        if (root == null)
            return 0;
         
        // Initialize result
        int maxwidth = 0;
         
        // Do Level order traversal keeping track of number of nodes at every level
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            // Get the size of queue when the level order traversal for one level finishes
            int count = q.size();
             
            // Update the maximum TreeNode count value
            maxwidth = Math.max(maxwidth, count);
             
            // Iterate for all the nodes in the queue currently
            while (count-- > 0){
                // Dequeue an TreeNode from queue
                TreeNode temp = q.remove();
             
                // Enqueue left and right children 
                // of dequeued TreeNode
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null){
                    q.add(temp.right);
                }
            }
        }
        return maxwidth;
    }
    
	public static int maxWidth(TreeNode root){
		if(root == null) return 0;
		TreeNode temp;
		int max = 1,count = 0;
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();

		if(root.left != null) s1.push(root.left);
		if(root.right != null) s1.push(root.right);

		while(!s1.isEmpty() || !s2.isEmpty()){
		
			while(!s1.isEmpty()){
				temp = s1.pop();
				count++;
				if(temp.left != null) s2.push(temp.left);
				if(temp.right != null) s2.push(temp.right);
			}
			
			if(count > max) max = count;
			count = 0;
			
			while(!s2.isEmpty()){
				temp = s2.pop();
				count++;
				if(temp.left != null) s1.push(temp.left);
				if(temp.right != null) s1.push(temp.right);
			}
			if(count > max) max = count;
			count = 0;
		}
		return max;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(6);
        root.right.right.right = new TreeNode(7);
 
                /*   Constructed Binary tree is:
                1
              /   \
            2      3
          /  \      \
         4    5      8
                   /   \
                  6     7    */
                   
		
		TreeNode.print(root);
		System.out.println();
		System.out.println("Max Level Width is:"+maxWidth(root));
		System.out.println("Max Level Width is:"+maxwidthQueueBased(root));
		
	}
}
