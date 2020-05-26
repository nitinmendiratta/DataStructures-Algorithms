package Medium;
import java.util.HashMap;
/*
 * https://leetcode.com/problems/fraction-to-recurring-decimal/
 */
public class M_0166_FractionToRecurringDecimal {

	public String fractionToDecimal(int numerator, int denominator) {
		StringBuilder result = new StringBuilder();
		String sign = (numerator < 0 == denominator < 0 || numerator == 0) ? "" : "-";
		
		long num = Math.abs((long) numerator);
		long den = Math.abs((long) denominator);
		long remainder = num % den;
		
		result.append(sign);
		result.append(num / den);
				
		if (remainder == 0)
			return result.toString();
		result.append(".");
		HashMap<Long, Integer> hashMap = new HashMap<Long, Integer>();
		
		while (!hashMap.containsKey(remainder)) {
			hashMap.put(remainder, result.length());
			result.append(10 * remainder / den);
			remainder = 10 * remainder % den;
		}
		
		int index = hashMap.get(remainder);
		
		result.insert(index, "(");
		result.append(")");
		
		return result.toString().replace("(0)", "");
	}

	public static void main(String[] args) {
		M_0166_FractionToRecurringDecimal obj = new M_0166_FractionToRecurringDecimal();
		 System.out.println(obj.fractionToDecimal(1, 2));
		 System.out.println(obj.fractionToDecimal(2, 1));
		System.out.println(obj.fractionToDecimal(2, 3));
	}
}
