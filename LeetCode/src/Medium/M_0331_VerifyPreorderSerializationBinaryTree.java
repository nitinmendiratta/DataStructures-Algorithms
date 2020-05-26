package Medium;
import java.util.Stack;
/*
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
 */
public class M_0331_VerifyPreorderSerializationBinaryTree {

	/*
	 * https://www.youtube.com/watch?v=_mbnPPHJmTQ
	 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/discuss/78551/7-lines-Easy-Java-Solution 
	 * If we treat null's as leaves, then
	 * 
	 * the binary tree will always be full. A full binary tree has a good property that
	 * # of leaves = # of nonleaves + 1. 
	 * Since we are given a pre-order
	 * serialization, we just need to find the shortest prefix of the serialization
	 * sequence satisfying the property above. If such prefix does not exist, then
	 * the serialization is definitely invalid; otherwise, the serialization is
	 * valid if and only if the prefix is the entire sequence.
	 */
	public boolean isValidSerialization(String preorder) {
		String[] nodes = preorder.split(",");
	    int diff = 1;
	    for (String node: nodes) {
	        if (--diff < 0) return false;
	        if (!node.equals("#")) diff += 2;
	    }
	    return diff == 0;
	}
	
	// Using stack
	public boolean isValidSerializationApproach2(String preorder) {
        // using a stack, scan left to right
        // case 1: we see a number, just push it to the stack
        // case 2: we see #, check if the top of stack is also #
        // if so, pop #, pop the number in a while loop, until top of stack is not #
        // if not, push it to stack
        // in the end, check if stack size is 1, and stack top is #
        if (preorder == null) {
            return false;
        }
        Stack<String> st = new Stack<>();
        String[] strs = preorder.split(",");
        for (int pos = 0; pos < strs.length; pos++) {
            String curr = strs[pos];
            while (curr.equals("#") && !st.isEmpty() && st.peek().equals(curr)) {
                st.pop();
                if (st.isEmpty()) {
                    return false;
                }
                st.pop();
            }
            st.push(curr);
        }
        return st.size() == 1 && st.peek().equals("#");
    }

	public static void main(String[] args) {
		M_0331_VerifyPreorderSerializationBinaryTree obj = new M_0331_VerifyPreorderSerializationBinaryTree();
		System.out.println(obj.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
	}
}
