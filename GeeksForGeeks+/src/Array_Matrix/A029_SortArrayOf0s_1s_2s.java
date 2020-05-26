package Array_Matrix;
/*
 * http://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
 * Time Complexity: O(n)
 */
public class A029_SortArrayOf0s_1s_2s {
 
	public int[] sort012(int[] arr){
		int n = arr.length;
		int l = 0;
		int h = n - 1;
		int mid = 0;

		while(mid <= h){

			switch(arr[mid]){
				case 0:
					if(arr[l] != arr[mid])
						swap(arr,l,mid);
	
					mid++;
					l++;
					break;
				case 1:
					mid++;
					break;
				case 2:
					if(arr[mid] != arr[h])
						swap(arr,mid,h);
					h--;
					break;
			}
		}
		return arr;
	}

	public void swap(int[] arr, int i,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		A029_SortArrayOf0s_1s_2s obj = new A029_SortArrayOf0s_1s_2s();
		int[] arr = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
		arr = obj.sort012(arr);
		for(int i = 0; i < arr.length;i++){
			System.out.print(arr[i]+",");
		}
	}
}
