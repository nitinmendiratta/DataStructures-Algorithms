package Array_Matrix;
/*
 * http://quiz.geeksforgeeks.org/find-the-element-that-appears-once/
 * Time complexity of this solution is O(n) and it requires O(1) extra space.
 */
public class A124_FindElementThatAppearsOnce {

	public int findSingle(int ar[]){
	     // Do XOR of all elements and return
	     int res = ar[0];
	     for (int i=1; i < ar.length; i++)
	        res = res ^ ar[i];
	 
	     return res;
	}
	
	public static void main(String[] args) {
		A124_FindElementThatAppearsOnce obj = new A124_FindElementThatAppearsOnce();
		int ar[] = {2, 3, 5, 4, 5, 3, 4};
		System.out.println("Element occurring once is: " +obj.findSingle(ar));
	}
}
