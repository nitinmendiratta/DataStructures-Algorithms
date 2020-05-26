package Medium;

/*
 * https://leetcode.com/problems/h-index-ii/
 */
public class M_0275_HIndex2 {

	/*
	 * 	case 1: citations[mid] == len-mid, then it means there are citations[mid] papers that have at least citations[mid] citations.
		case 2: citations[mid] > len-mid, then it means there are citations[mid] papers that have moret than citations[mid] citations, so we should continue searching in the left half
		case 3: citations[mid] < len-mid, we should continue searching in the right side
		After iteration, it is guaranteed that right+1 is the one we need to find (i.e. len-(right+1) papars have at least len-(righ+1) citations)
	 */
	public int hIndex(int[] citations) {

		int start = 0, end = citations.length-1, len = citations.length;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (citations[mid] >= len - mid) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return len - start;
	}

	public static void main(String[] args) {
		M_0275_HIndex2 obj = new M_0275_HIndex2();
		System.out.println(obj.hIndex(new int[] { 0, 1, 3, 5, 6 })); // 3
		System.out.println(obj.hIndex(new int[] { 3, 4, 5, 8, 10})); // 4
		System.out.println(obj.hIndex(new int[] { 3, 3, 5, 8, 25})); // 3
		System.out.println(obj.hIndex(new int[] { 5, 6, 7, 8, 9})); // 5
	}
}
