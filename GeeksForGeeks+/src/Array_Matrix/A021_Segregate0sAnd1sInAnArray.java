package Array_Matrix;

/*
 * http://www.geeksforgeeks.org/segregate-0s-and-1s-in-an-array-by-traversing-array-once/
 */
 
public class A021_Segregate0sAnd1sInAnArray {

	public int[] segregate(int[] arr){
		int l = 0;
		int r = arr.length-1;
		int temp = 0;
		
		while(l < r){
		
			while(arr[l] == 0 && l < r) l++;		
			while(arr[r] == 1 && l < r) r--;
			
			if(l < r){
				temp = arr[r];
				arr[r] = arr[l];
				arr[l] = temp;
				l++;
				r--;
			}
		}
		return arr;
	}
	
	public static void main(String[] args) {
		A021_Segregate0sAnd1sInAnArray obj = new A021_Segregate0sAnd1sInAnArray();
		int[] arr = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
		arr = obj.segregate(arr);
		for(int i = 0; i < arr.length;i++){
			System.out.print(arr[i]+",");
		}
	}
}
