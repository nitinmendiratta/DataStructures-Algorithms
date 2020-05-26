package Hard;
/*
 * A073: http://www.geeksforgeeks.org/median-of-two-sorted-arrays-of-different-sizes/
 * H_004: https://leetcode.com/problems/median-of-two-sorted-arrays/
 * http://www.programcreek.com/2012/12/leetcode-median-of-two-sorted-arrays-java/
 * http://articles.leetcode.com/median-of-two-sorted-arrays/
 * -> https://www.youtube.com/watch?v=LPFhl65R7ww&t=1013s
 */
public class H_004_MedianOfTwoSortedArrays {

	/*
	 * Take minimum size of two array. Possible number of partitions are from 0 to m in m size array.
	 * Try every cut in binary search way. When you cut first array at i then you cut second array at (m + n + 1)/2 - i
	 * Now try to find the i where a[i-1] <= b[j] and b[j-1] <= a[i]. So this i is partition around which lies the median.
	 * Time: O(log(min(m,n)))
	 * Space O(1)
	 */
	public double findMedianSortedArrays(int input1[], int input2[]) {
		//if input1 length is greater than switch them so that input1 is smaller than input2.
		if (input1.length > input2.length) {
			return findMedianSortedArrays(input2, input1);
		}
		int x = input1.length;
		int y = input2.length;

		int low = 0;
		int high = x;
		while (low <= high) {
			int partitionX = (low + high)/2;
			int partitionY = (x + y + 1)/2 - partitionX;

			//if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
			//if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
			int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : input1[partitionX - 1];
			int minRightX = (partitionX == x) ? Integer.MAX_VALUE : input1[partitionX];

			int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : input2[partitionY - 1];
			int minRightY = (partitionY == y) ? Integer.MAX_VALUE : input2[partitionY];

			if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
				//We have partitioned array at correct place
				// Now get max of left elements and min of right elements to get the median in case of even length combined array size
				// or get max of left for odd length combined array size.
				if ((x + y) % 2 == 0) {
					return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
				} else {
					return (double)Math.max(maxLeftX, maxLeftY);
				}
			} else if (maxLeftX > minRightY) { //we are too far on right side for partitionX. Go on left side.
				high = partitionX - 1;
			} else { //we are too far on left side for partitionX. Go on right side.
				low = partitionX + 1;
			}
		}

		//Only we we can come here is if input arrays were not sorted. Throw in that scenario.
		throw new IllegalArgumentException();
	}

	public static double findMedianSortedArraysApproach2(int A[], int B[]) {
		int m = A.length;
		int n = B.length;

		if ((m + n) % 2 != 0) // odd
			return (double) findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1);
		else { // even
			return (findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1) 
					+ findKth(A, B, (m + n) / 2 - 1, 0, m - 1, 0, n - 1)) * 0.5;
		}
	}

	public static int findKth(int A[], int B[], int k, int aStart, int aEnd, int bStart, int bEnd) {

		int aLen = aEnd - aStart + 1;
		int bLen = bEnd - bStart + 1;

		// Handle special cases
		if (aLen == 0)
			return B[bStart + k];
		if (bLen == 0)
			return A[aStart + k];
		if (k == 0)
			return A[aStart] < B[bStart] ? A[aStart] : B[bStart];

			int aMid = aLen * k / (aLen + bLen); // a's middle count
			int bMid = k - aMid - 1; // b's middle count

			// make aMid and bMid to be array index
			aMid = aMid + aStart;
			bMid = bMid + bStart;

			if (A[aMid] > B[bMid]) {
				k = k - (bMid - bStart + 1);
				aEnd = aMid;
				bStart = bMid + 1;
			} else {
				k = k - (aMid - aStart + 1);
				bEnd = bMid;
				aStart = aMid + 1;
			}
			return findKth(A, B, k, aStart, aEnd, bStart, bEnd);
	}

	public static void main(String[] args) {
		H_004_MedianOfTwoSortedArrays obj = new H_004_MedianOfTwoSortedArrays();
		int[] a = {900};
		int[] b = {5, 8, 10, 20};
		System.out.println("Median is:"+obj.findMedianSortedArraysApproach2(a,b));
		System.out.println("Median is:"+obj.findMedianSortedArrays(a,b));
	}


}
