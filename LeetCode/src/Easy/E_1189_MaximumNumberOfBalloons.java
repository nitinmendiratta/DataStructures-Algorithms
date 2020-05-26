package Easy;
/*
 * https://leetcode.com/problems/maximum-number-of-balloons/
 */
public class E_1189_MaximumNumberOfBalloons {

	public int maxNumberOfBalloons(String text) {
		int[] chars = new int[26]; //count all letters
        for (char c : text.toCharArray()) {
            chars[c - 'a']++;
        }
        int min = chars['b'-'a'];//for b
        min = Math.min(min, chars['a'-'a']);//for a
        min = Math.min(min, chars['l'-'a'] / 2);// for l /2 
        min = Math.min(min, chars['o'-'a'] / 2);//similarly for o/2
        min = Math.min(min, chars['n'-'a']);//for n
        return min;      
    }
	public static void main(String[] args) {
		E_1189_MaximumNumberOfBalloons obj = new E_1189_MaximumNumberOfBalloons();
		System.out.println(obj.maxNumberOfBalloons("loonbalxballpoon"));
	}
}
