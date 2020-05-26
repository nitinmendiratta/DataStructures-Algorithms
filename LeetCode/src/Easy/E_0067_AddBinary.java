package Easy;
/*
 * https://oj.leetcode.com/problems/add-binary/
 */
public class E_0067_AddBinary {

	public String addBinary(String a, String b) {
		if(a == null && b == null) return null;
		if(a == null) return b;
		if(b == null) return a;
		StringBuilder sb = new StringBuilder();
		int alen = a.length()-1;
		int blen = b.length()-1;
		int carry = 0;
		
		while(alen >= 0 || blen >= 0){
			int num1 = alen >= 0 ? a.charAt(alen--)-'0':0;
			int num2 = blen >= 0 ? b.charAt(blen--)-'0':0;
			int currentSum = (num1+num2+carry)%2;
			carry = (num1+num2+carry)/2;
			sb.insert(0,currentSum);
		}
		if(carry > 0) sb.insert(0,carry);
		return sb.toString();
	}
	
	public static void main(String[] args) {
		E_0067_AddBinary obj = new E_0067_AddBinary();
		System.out.println(obj.addBinary("11","1"));
	}
}
