package Easy;
import java.util.*;

import Helper.NaryTreeNode;
/*
 * https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
 */
public class E_0559_MaximumDepthNaryTree {

	public int maxDepth(NaryTreeNode root) {
		if(root == null) return 0;
		int depth = 1;
		int len = root.children.size();
		if(len > 0){          
			for(int i = 0; i < len; i++){
				int d = maxDepth(root.children.get(i));
				depth = Math.max(d, depth);
			}
			return 1 + depth;
		}
		return depth;
	}
	
	// using level order traversal
	public int maxDepthApproach2(NaryTreeNode root) {
		if(root == null) return 0;
		int depth = 0;
		Queue<NaryTreeNode> q = new LinkedList<NaryTreeNode>();
		q.add(root);
		while(!q.isEmpty()){   
			int size = q.size();
			for(int i = 0; i < size; i++){
				NaryTreeNode curr = q.poll();
				for (NaryTreeNode c : curr.children) {
					q.add(c);
				}
			}
			return depth++;
		}
		return depth;
	}
}
