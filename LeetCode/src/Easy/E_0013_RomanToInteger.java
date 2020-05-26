package Easy;
import java.util.HashMap;
/*
 * https://oj.leetcode.com/problems/roman-to-integer/
 */
public class E_0013_RomanToInteger {

	public int getRomanToIntVal(char c){
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        } throw new IllegalArgumentException("unsupported character");
    }
    
    public int romanToInt(String s){
        int result = 0;
        for(int i = 0; i< s.length() -1; i++){
            int current = getRomanToIntVal(s.charAt(i));
            int next = getRomanToIntVal(s.charAt(i+1));
            if(current >= next) result += current;
            else result -= current;
        }
        return result + getRomanToIntVal(s.charAt(s.length()-1));
    }

	public String IntToRoman(int num) {
		if(num < 0) return null;

		int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4,1};
		String[] digits = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		StringBuffer sb=new StringBuffer();
		int i=0;

		while(num > 0){
			int times = num/nums[i];
			num = num - nums[i]*times;
			for(;times > 0;times--){
				sb.append(digits[i]);
			}
			i++;
		}
		return sb.toString();
	}

	public int romanToIntApproach2(String s) {
		if(s == null) return -1;
		HashMap<Character, Integer> ht = new HashMap<Character, Integer>();
		ht.put('I',1);
		ht.put('V',5);
		ht.put('X',10);
		ht.put('L',50);
		ht.put('C',100);
		ht.put('D', 500);
		ht.put('M',1000);

		int n = s.length();
		char lastChar = s.charAt(n-1);
		int sum = ht.get(lastChar);
		for(int i = n-2; i >= 0; i--){
			char previousChar = s.charAt(i+1);
			char currentChar = s.charAt(i);
			// if previous char is > current we reduce value like in IV
			if (ht.get(previousChar) > ht.get(currentChar)){
				sum -= ht.get(currentChar);
			}
			// IIII
			else {
				sum += ht.get(currentChar);
			}
		}
		return sum;
	}
	public static void main(String[] args) {
		E_0013_RomanToInteger obj = new E_0013_RomanToInteger();
		System.out.println(obj.romanToInt("XC"));
		System.out.println(obj.romanToInt("MCMXCIV"));
	}
}
