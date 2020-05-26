package Easy;
/*
 * https://leetcode.com/problems/ugly-number/
 */
public class E_0263_UglyNumber {

	 public boolean isUgly(int n) {
	        if(n == 0) return false;
	        while(true){
	            if(n == 1) return true;
	            if(n%2 == 0){
	                n = n/2;
	                continue;
	            }else if(n%3 == 0){
	                n = n/3;
	                continue;
	            }else if(n%5 == 0){
	                n = n/5;
	                continue;
	            }
	            return false;
	        }
	    }
	public static void main(String[] args) {
		E_0263_UglyNumber obj = new E_0263_UglyNumber();
		System.out.println(obj.isUgly(7));
	}
}
