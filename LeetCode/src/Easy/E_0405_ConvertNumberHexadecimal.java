package Easy;
/*
 * https://leetcode.com/problems/convert-a-number-to-hexadecimal/
 */
public class E_0405_ConvertNumberHexadecimal {

	public String toHex(int num) {
		if (num == 0) return "0";
		StringBuilder s = new StringBuilder();
		while(num != 0){
			//15 decimal is 1111 in binary. By anding (&) 1111 and the input number, you basically get the last 4 binary digits of the input number.
			//e.g. input number is decimal 33. In binary 33 is 0010 0001. So, 0010 0001 & 0000 1111 = 0000 0001. 
			int rem = num & 0xf;
			if(rem >= 10){
				s.append((char)(rem - 10 + 'a'));
			}else{
				s.append((char)(rem + '0'));
			}

			//we are dividing it by 16, right shift by 1 means dividing by 2 to the power 1, so right shift by means dividing by 2 to the power 4 that is 16, 
			// have done this because bit manipulation is faster
			num >>>= 4;
		}
		//return res;
		return s.reverse().toString();
	}

	public static void main(String[] args) {
		E_0405_ConvertNumberHexadecimal obj = new E_0405_ConvertNumberHexadecimal();
		System.out.println(obj.toHex(-1));
	}
}
