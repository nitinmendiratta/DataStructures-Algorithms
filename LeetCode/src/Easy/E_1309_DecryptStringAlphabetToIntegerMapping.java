package Easy;
/*
 * https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
 */
public class E_1309_DecryptStringAlphabetToIntegerMapping {

	public String freqAlphabets(String s) {
		
        StringBuilder res = new StringBuilder();
        int i = 0, len = s.length(), curr;
        
		while(i < len) {
			if(i+2 < len && s.charAt(i+2) == '#') {
				curr = Integer.valueOf(s.substring(i, i+2));
				i = i+2;
			}else {
				curr = Character. getNumericValue(s.charAt(i));
			}
			char c = (char) (curr + 'a' - 1);
			res.append(c);
			i++;
		}
		return res.toString();
    }
	public static void main(String[] args) {
		E_1309_DecryptStringAlphabetToIntegerMapping obj = new E_1309_DecryptStringAlphabetToIntegerMapping();
		System.out.println(obj.freqAlphabets("10#11#12"));
		System.out.println(obj.freqAlphabets("1326#"));
		System.out.println(obj.freqAlphabets("25#"));
		System.out.println(obj.freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"));
	}
}
