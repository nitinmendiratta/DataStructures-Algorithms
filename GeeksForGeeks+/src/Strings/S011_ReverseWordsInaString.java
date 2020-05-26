package Strings;
/*
 * http://www.geeksforgeeks.org/reverse-words-in-a-given-string/
 */
public class S011_ReverseWordsInaString {

	public String reverse(String s){
		if(s == null || s.length() == 0) return s;
		String[] arr = s.split("\\s+");
		StringBuilder sb = new StringBuilder();
		
		for(int i = arr.length-1;i >=0;i--){
			sb.append(arr[i]+" ");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		S011_ReverseWordsInaString obj = new S011_ReverseWordsInaString();
		String s = "i  i like this program very much";
		System.out.println("New String after reversing: "+obj.reverse(s));
	}
}
