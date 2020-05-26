package Easy;
/*
 * https://leetcode.com/problems/first-bad-version/
 */
public class E_0278_FirstBadVersion {

	 public int firstBadVersion(int n) {
	        int start = 1, end = n;
	        while(start < end){
	            int mid = (end-start)/2 + start;
	            if(isBadVersion(mid)){
	                end = mid;
	            }else{
	                start = mid+1;
	            }
	        }
	        return start;
	    }
	private boolean isBadVersion (int mid) {
		return false;
	}
	public static void main(String[] args) {
		E_0278_FirstBadVersion obj = new E_0278_FirstBadVersion();
		System.out.println(obj.firstBadVersion(6));
	}
}
