package Easy;
/*
 * https://leetcode.com/problems/defanging-an-ip-address/
 */
public class E_1108_DefangingIPAddress {

	public String defangIPaddr(String address) {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < address.length(); i++){
			if (address.charAt(i) == '.'){
				str.append("[.]");
			} else {
				str.append(address.charAt(i));
			}
		}
		return str.toString();
	}
	public static void main(String[] args) {
		E_1108_DefangingIPAddress obj = new E_1108_DefangingIPAddress();
		System.out.println(obj.defangIPaddr("1.1.1.1"));
	}
}
