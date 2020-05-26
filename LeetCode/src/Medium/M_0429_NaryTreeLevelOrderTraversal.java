package Medium;
import java.util.*;

import Easy.E_0404_SumLeftLeaves;
import Helper.NaryTreeNode;
/*
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 */
public class M_0429_NaryTreeLevelOrderTraversal {

	public List<List<Integer>> levelOrder(NaryTreeNode root) {
		List<List<Integer>> ret = new LinkedList<>();
        
        if (root == null) return ret;
        
        Queue<NaryTreeNode> queue = new LinkedList<>();
        
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            List<Integer> curLevel = new LinkedList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
            	NaryTreeNode curr = queue.poll();
                curLevel.add(curr.val);
                for (NaryTreeNode c : curr.children)
                    queue.offer(c);
            }
            ret.add(curLevel);
        }
        
        return ret;
    }
	public static void main(String[] args) {
		E_0404_SumLeftLeaves obj = new E_0404_SumLeftLeaves();
		int[] inputArr = new int[]{6,2,8,0,4,7,9,3,5};
		//NaryTreeNode inputTree = NaryTreeNode.constructBst(inputArr);
		System.out.println("INPUT");
		//NaryTreeNode.print(inputTree);
		System.out.println();
		System.out.println("OUTPUT");
		//System.out.println(obj.levelOrder(inputTree));
	}
}
