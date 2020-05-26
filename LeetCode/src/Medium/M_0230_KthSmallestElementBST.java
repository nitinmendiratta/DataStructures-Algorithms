package Medium;
import Helper.TreeNode;
/*
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * Follow up: https://www.geeksforgeeks.org/find-k-th-smallest-element-in-bst-order-statistics-in-bst/
 */
public class M_0230_KthSmallestElementBST {

	/*
	 * For second approach you can use MaxHeap of size k. So kth smallest will be on
	 * top of the heap. If new inserted node is greater then top() don't do anything
	 * to MaxHeap. Just insert in to BST. logN (assuming balanced) Otherwise remove
	 * top(), logK operation, insert the new node logK When removing a node remove
	 * it from MaxHeap logK, if it's there. Remove it from Tree. logN operation. If
	 * node was removed, find new topK in BST (H + K) and insert in to MaxHeap logK
	 */
	int count = 0, res = 0;

	public int kthSmallest(TreeNode root, int k) {

		kthSmallestHelper(root, k);
		return res;
	}

	public void kthSmallestHelper(TreeNode root, int k) {
		if (root == null) {
			return;
		}
		kthSmallest(root.left, k);
		count++;
		if (k == count) {
			res = root.val;
			return;
		}
		kthSmallest(root.right, k);
	}

	public static void main(String[] args) {
		M_0230_KthSmallestElementBST obj = new M_0230_KthSmallestElementBST();
		TreeNode root = TreeNode.createRandomBST(5);
		System.out.println(obj.kthSmallest(root, 3));
	}
}
