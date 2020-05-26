package Easy;
/**
 * https://leetcode.com/problems/sqrtx/
 * https://www.geeksforgeeks.org/square-root-of-an-integer/
 *
 */
public class E_0069_Sqrt {
	
	public int mySqrt(int x) {
		if(x == 0 || x == 1) {
			return x;
		}
		int start = 1, end  = x/2;
		while(start <= end) {
			int mid = (end - start)/ 2 + start;
			if(mid == x/mid) {
				return mid;
			}
			else if(x/(mid+1) < (mid+1)) {
				if(x/(mid) > (mid)){
					return mid;
				}
				end = mid-1;
			} else if(x/(mid+1) >= (mid+1)){
				if((x/(mid)) < (mid)){
					return mid;
				}
				start = mid+1;
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		E_0069_Sqrt obj = new E_0069_Sqrt();
		int x = 2147395599; 
        System.out.println(obj.mySqrt(x));
	}

}
