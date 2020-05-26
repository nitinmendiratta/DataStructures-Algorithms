package Medium;

import java.util.*;
import Helper.*;

public class M_0199_BinaryTreeRightSideView {

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList();
		if(root == null) return res;
		Queue<TreeNode> queue = new LinkedList();
		queue.add(root);

		while (!queue.isEmpty()) {

			int len = queue.size(), i = 0;
			res.add(queue.peek().val);
			while (i < len) {
				TreeNode cur = queue.remove();
				if (cur.right != null) {
					queue.add(cur.right);	
				}

				if (cur.left != null) {
					queue.add(cur.left);
				}

				i++;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		M_0199_BinaryTreeRightSideView obj = new M_0199_BinaryTreeRightSideView();
		System.out.println(obj.rightSideView(TreeNode.createRandomBST(5)));

	}

}
