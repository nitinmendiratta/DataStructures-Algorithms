package Easy;
/*
 * https://leetcode.com/problems/monotonic-array/
 */
public class E_0896_MonotonicArray {

	public boolean isMonotonic(int[] A) {
		int len = A.length, i = 1;
        boolean mi = true, md = true;
        
        while(i < len){
            if(mi && A[i] < A[i-1]){
                mi = false;
            }else if(md && A[i] > A[i-1]){
                md = false;
            }
            i++;
        }
        return mi || md;
    }
	public static void main(String[] args) {
		E_0896_MonotonicArray obj = new E_0896_MonotonicArray();
		System.out.println(obj.isMonotonic(new int[] {1,2,2,1}));
	}
}
