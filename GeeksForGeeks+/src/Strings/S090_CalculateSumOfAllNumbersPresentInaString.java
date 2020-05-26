package Strings;
/*
 * http://www.geeksforgeeks.org/calculate-sum-of-all-numbers-present-in-a-String/
 * Time complexity of above solution is O(n) where n is length of the string.
 */
public class S090_CalculateSumOfAllNumbersPresentInaString {

	// Function to calculate sum of all numbers present
	// in a String containing alphanumeric characters
	int findSum(String str){
			int i=0,sum=0;
			String temp="0";
			while(i<str.length()){
				char s=str.charAt(i);
				if(isDigit(s)){
					temp+=str.charAt(i);
				}else{
					sum+=Integer.valueOf(temp);
					temp="0";
				}
				i++;
			}
			sum+=Integer.valueOf(temp);
			return sum;
	}
		
	public boolean isDigit(char ch){
		return "0123456789".contains(Character.toString(ch));
	}
	public static void main(String[] args) {
		S090_CalculateSumOfAllNumbersPresentInaString obj = new S090_CalculateSumOfAllNumbersPresentInaString();
		// input alphanumeric String
	    String str = "12abc20yz68";
	 
	    System.out.println(obj.findSum(str));
	}
}
