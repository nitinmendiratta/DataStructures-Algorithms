package Easy;
/*
 * https://leetcode.com/problems/peak-index-in-a-mountain-array/
 */
public class E_0852_PeakIndexMountainArray {

	// binary search awesome approach
	public int peakIndexInMountainArray(int[] A) {
		int lo = 0, hi = A.length - 1;
		while (lo < hi) {
			int mi = lo + (hi - lo) / 2;
			if (A[mi] < A[mi + 1])
				lo = mi + 1;
			else
				hi = mi;
		}
		return lo;
	}

	public int peakIndexInMountainArrayApproach2(int[] A) {
		int i = 0;
		while (A[i] < A[i+1]) i++;
		return i;
	}
	public static void main(String[] args) {
		E_0852_PeakIndexMountainArray obj = new E_0852_PeakIndexMountainArray();
		System.out.println(obj.peakIndexInMountainArrayApproach2(new int[] {0,1,0}));
	}
}
