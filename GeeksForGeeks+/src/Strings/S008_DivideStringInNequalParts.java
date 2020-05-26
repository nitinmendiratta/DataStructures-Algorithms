package Strings;
/*
 * http://www.geeksforgeeks.org/divide-a-string-in-n-equal-parts/
 */
public class S008_DivideStringInNequalParts {

	static void divide(String str, int n){
		
		int size=str.length();
		int part_size;
		if((size%n)==0)
			part_size=(size/n);
		else{
			System.out.println("The input string is not valid");
			return;
		}
	
		int count=0;
		for(int i=0;i<size;i++){
			if(count<part_size){
				System.out.print(str.charAt(i));
				count++;
			}
			else{
				System.out.println();
				count=1;
				System.out.print(str.charAt(i));
			}
		}
	}
	
	public static void main(String[] args) {
		divide("geeksforgee", 4);
	}
}
