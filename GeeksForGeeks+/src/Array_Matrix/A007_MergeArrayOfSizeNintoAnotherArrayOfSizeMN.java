package Array_Matrix;
/*
 * http://www.geeksforgeeks.org/merge-one-array-of-size-n-into-another-one-of-size-mn/
 */
public class A007_MergeArrayOfSizeNintoAnotherArrayOfSizeMN {

	public int[] merge(int[] a, int[] b){
		int n = b.length;
		int mplusn = a.length;
		for(int i = mplusn-1,j = mplusn-1 ;i >= 0;i--){
			if(a[i] != -1){
				a[j] = a[i];
				j--;
			}
		}
		int i = n, j = 0, k = 0;
		while(k < mplusn){
			/* Take an element from a[] if
       		a) value of the picked element is smaller and we have not reached end of it
       		b) We have reached end of b[] */

			if ((j == n) || (i < mplusn && a[i] <= b[j])){
				a[k] = a[i];
				k++;
				i++;
			}
			else {  // Otherwise take element from b[]
				a[k] = b[j];
				k++;
				j++;
			}
		}
		return a;
	}

	public static void main(String[] args) {
		A007_MergeArrayOfSizeNintoAnotherArrayOfSizeMN obj = new A007_MergeArrayOfSizeNintoAnotherArrayOfSizeMN();
		int[] a = {1,-1,-1,4,5,6};
		int[] b = {2,3};
		int[] result = obj.merge(a,b);
		for(int i = 0;i < result.length;i++) System.out.print(result[i]+",");
	}
}
