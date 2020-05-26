package Easy;
/*
 * https://leetcode.com/problems/rectangle-overlap/
 */
public class E_0836_RectangleOverlap {

	public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
		return !(rec1[2] <= rec2[0] ||   // left
                rec1[3] <= rec2[1] ||   // bottom
                rec1[0] >= rec2[2] ||   // right
                rec1[1] >= rec2[3]);    // top
    }
	public static void main(String[] args) {
		E_0836_RectangleOverlap obj = new E_0836_RectangleOverlap();
		System.out.println(obj.isRectangleOverlap(new int[] {0,0,2,2}, new int[] {1,1,3,3}));
	}
}
