package Tree;
/*
 * http://www.geeksforgeeks.org/populate-inorder-successor-for-all-nodes/
 * Time Complexity: O(n)
 */
public class BT_041_PopulateInorderSuccessorForAllNodes {
	// We can avoid the use of static variable by passing reference to next as paramater.
	static SpecialTreeNode next = null;
	
	class SpecialTreeNode{
		int data;
		SpecialTreeNode left;
		SpecialTreeNode right;
		SpecialTreeNode inSucc;
		public SpecialTreeNode(int x){
			data = x;
			this.left = null;
			this.right = null;
			this.inSucc = null;
		}
	}
	
	public static void inorderSuccessor(SpecialTreeNode root){
		
		if(root != null){
			inorderSuccessor(root.right);
			root.inSucc = next;
			next = root;
			inorderSuccessor(root.left);
		}
	}
	
	public static void main(String[] args) {
		BT_041_PopulateInorderSuccessorForAllNodes tree = new BT_041_PopulateInorderSuccessorForAllNodes();
		SpecialTreeNode root = tree.new SpecialTreeNode(1);
		root.left = tree.new SpecialTreeNode(2);
		root.right = tree.new SpecialTreeNode(3);
		root.left.left = tree.new SpecialTreeNode(4);
		root.left.right = tree.new SpecialTreeNode(5);
		root.right.left = tree.new SpecialTreeNode(6);
		inorderSuccessor(root);
		System.out.println(root.left.data+"->"+root.left.inSucc.data);
		//System.out.println(root.right.inSucc.data);
		System.out.println(root.left.left.data+"->"+root.left.left.inSucc.data);
		System.out.println(root.left.right.data+"->"+root.left.right.inSucc.data);
		System.out.println(root.right.left.data+"->"+root.right.left.inSucc.data);
	}
}
