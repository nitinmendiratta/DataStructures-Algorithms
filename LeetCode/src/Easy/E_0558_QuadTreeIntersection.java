package Easy;
/*
 * https://leetcode.com/problems/quad-tree-intersection/
 */
public class E_0558_QuadTreeIntersection {

	class Node {
	    public boolean val;
	    public boolean isLeaf;
	    public Node topLeft;
	    public Node topRight;
	    public Node bottomLeft;
	    public Node bottomRight;

	    public Node() {}

	    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
	        val = _val;
	        isLeaf = _isLeaf;
	        topLeft = _topLeft;
	        topRight = _topRight;
	        bottomLeft = _bottomLeft;
	        bottomRight = _bottomRight;
	    }
	};
	
	public Node intersect(Node q1, Node q2) {
		if (q1.isLeaf) {
            return q1.val ? q1 : q2;
        }
        if (q2.isLeaf) {
            return q2.val ? q2 : q1;
        }
        
        q1.topLeft = intersect(q1.topLeft, q2.topLeft);
        q1.topRight = intersect(q1.topRight, q2.topRight);
        q1.bottomLeft = intersect(q1.bottomLeft, q2.bottomLeft);
        q1.bottomRight = intersect(q1.bottomRight, q2.bottomRight);
        
        if (q1.topLeft.isLeaf && q1.topRight.isLeaf 
            && q1.bottomLeft.isLeaf && q1.bottomRight.isLeaf
            && q1.topLeft.val == q1.topRight.val 
            && q1.topRight.val == q1.bottomLeft.val 
            && q1.bottomLeft.val == q1.bottomRight.val) {
            q1.isLeaf = true;
            q1.val = q1.topLeft.val;
        }
        return q1;
    }
	public static void main(String[] args) {
//		E_0558_QuadTreeIntersection obj = new E_0558_QuadTreeIntersection();
//		int[] inputArr = new int[]{6,2,2,2,3,3,3};
//		TreeNode inputTree = TreeNode.constructBst(inputArr);
//		System.out.println("INPUT");
//		TreeNode.print(inputTree);
//		System.out.println();
//		System.out.println("OUTPUT");
//		System.out.println(obj.intersect(inputTree));
	}
}
