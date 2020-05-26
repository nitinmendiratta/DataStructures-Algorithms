package Easy;
/*
 * https://leetcode.com/problems/maximum-69-number/
 */
public class E_1323_Maximum69Number {

	public int maximum69Number (int num) {
		char[] charArr = Integer.toString(num).toCharArray();
        for(int i = 0;i < charArr.length;i++) {
            if(charArr[i] == '6') {
                charArr[i] = '9';
                break;
            }
        }
        
        return Integer.parseInt(new String(charArr));
	}
	public static void main(String[] args) {
		E_1323_Maximum69Number obj = new E_1323_Maximum69Number();
		System.out.println(obj.maximum69Number(9669));
	}
}
