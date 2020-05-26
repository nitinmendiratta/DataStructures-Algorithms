package Array_Matrix;
import java.util.Arrays;
import java.util.Hashtable;

/*
 * http://www.geeksforgeeks.org/find-a-pair-with-the-given-difference/
 */
 
public class A065_FindPairWithGivenDifference {

	// nlogn + n
	public boolean isSumApproach1(int[] arr, int x){
		
		Arrays.sort(arr);
		int diff = 0;
		int start = 0;
		int end = arr.length-1;
		
		while(start < end){
			diff = arr[end] - arr[start];
			if(diff == x){
				return true;
			}
			else if(diff > x){
				start++;
			}
			else{
				end--;
			}
		}
		return false;
	}
	
	// time: n + space: n
	public boolean isSumApproach2(int[] arr, int x){
		Hashtable<Integer,Boolean> hash = new Hashtable<Integer,Boolean>();
		int diff = 0;
		int i = 0;
		while(i < arr.length){
			diff = Math.abs(arr[i]+x);
			if(hash.containsKey(arr[i])){
				return true;
			}else{
				hash.put(diff,true);
			}
			i++;
		}
		return false;
	}
	
	public static void main(String[] args) {
		A065_FindPairWithGivenDifference obj = new A065_FindPairWithGivenDifference();
		int[] arr = {1, 8, 30, 40, 100};
		System.out.println("diff exists:"+obj.isSumApproach1(arr,60));
		System.out.println("diff exists:"+obj.isSumApproach2(arr,60));
	}
}
