package Easy;
/*
 * https://leetcode.com/problems/reverse-only-letters/
 */
public class E_0917_ReverseOnlyLetters {

	public String reverseOnlyLetters(String S) {
		int i = 0, j = S.length()-1;
		char[] arr = S.toCharArray();
		
		while(i < j){

			while(i < j && !Character.isLetter(arr[i])) i++;
			while(i < j && !Character.isLetter(arr[j])) j--;

			if(i < j){
				char temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
			i++;
			j--;

		}
		return new String(arr);
	}
	public static void main(String[] args) {
		E_0917_ReverseOnlyLetters obj = new E_0917_ReverseOnlyLetters();
		System.out.println(obj.reverseOnlyLetters("a-bC-dEf-ghIj")); // j-Ih-gfE-dCba
		System.out.println(obj.reverseOnlyLetters("Test1ng-Leet=code-Q!")); // Qedo1ct-eeLg=ntse-T!
	}
}
