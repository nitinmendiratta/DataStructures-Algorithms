package Easy;
/*
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class E_0088_MergeSortedArray {


	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int k = m + n - 1, j = n - 1, i = m - 1;
		while(i >=0 && j>= 0 && k >=0){

			if(nums1[i] == nums2[j]){
				nums1[k] = nums1[i];
				k--;
				i--;
				nums1[k] = nums2[j];
				j--;
			}else if(nums1[i] > nums2[j]){
				nums1[k] = nums1[i];
				i--;
			} else if(nums1[i] < nums2[j]){
				nums1[k] = nums2[j];
				j--;
			}
			k--;
		}
		while(j >= 0){
			nums1[k] = nums2[j];
			k--;
			j--;
		}
	}


	public void mergeApproach2(int a[], int m, int b[], int n){

		int mplusn = m+n, i = m-1,j = mplusn-1,k = 0;;
		if(a.length < mplusn) return;
		while(i >= 0){
			a[j] = a[i];
			j--;
			i--;
		}
		i = 0;j++;
		while(j < mplusn && k < n){

			if(a[j] < b[k]){
				a[i] = a[j];
				j++;
			}
			else if(a[j] > b[k]){
				a[i] = b[k];
				k++;
			}
			else{
				a[i] = a[j];
				i++;
				j++;
				a[i] = b[k];
				k++;
				System.out.println(a[i]);
			}
			i++;
		}
		while(j < mplusn){
			a[i] = a[j];
			i++;j++;
		}
		while(k < n){
			a[i] = b[k];
			i++;k++;
		}
	}

	public static void main(String[] args) {
		E_0088_MergeSortedArray obj = new E_0088_MergeSortedArray();
		int a[] = {0,0,0};
		int[] b = {2,5,6};
		obj.merge(a,0,b,3);
		for(int i = 0;i < a.length;i++)	System.out.print(a[i]+",");
	}
}
