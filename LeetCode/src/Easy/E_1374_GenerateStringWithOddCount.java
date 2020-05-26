package Easy;

/*
 * https://leetcode.com/problems/generate-a-string-with-characters-that-have-odd-counts/
 */
public class E_1374_GenerateStringWithOddCount {

	// works only with java 11
//	public String generateTheString(int n) {
//        return n % 2 == 1 ? "a".repeat(n) : "a".repeat(n - 1) + "b";
//    }
	
	// My Approach
	public String generateTheString(int n) {
		int i = 1;
		StringBuilder sb = new StringBuilder();
		
		while(i < n) {
			sb.append('a');
			i++;
		}
			
		if(n%2 == 0) {
			sb.append('b');
		}else {
			sb.append('a');
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		E_1374_GenerateStringWithOddCount obj = new E_1374_GenerateStringWithOddCount();
		System.out.println(obj.generateTheString(3));
	}
}
