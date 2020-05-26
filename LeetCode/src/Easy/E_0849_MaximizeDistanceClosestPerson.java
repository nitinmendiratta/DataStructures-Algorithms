package Easy;
/*
 * https://leetcode.com/problems/maximize-distance-to-closest-person/
 */
public class E_0849_MaximizeDistanceClosestPerson {

	public int maxDistToClosest(int[] seats) {
		int len = seats.length, count = 0, last1indx = -1, diff = 0, i = 0;

		while(i < len){

			// move to next 1 and ignore all zeroes
			while(i < len && seats[i] != 1) i++;

			if(i == len || last1indx == -1){
				// special case if we have zeroes in starting/end
				diff = i - last1indx - 1;
			}else {
				diff = (i - last1indx)/2;
			}

			// get the max diff
			count = Math.max(count, diff);
			// update last index of 1
			last1indx = i;
			i++;
		}
		return count;
	}
	public static void main(String[] args) {
		E_0849_MaximizeDistanceClosestPerson obj = new E_0849_MaximizeDistanceClosestPerson();
		System.out.println(obj.maxDistToClosest(new int[] {1,0,0, 0,0,0,1,0,0}));
	}
}
