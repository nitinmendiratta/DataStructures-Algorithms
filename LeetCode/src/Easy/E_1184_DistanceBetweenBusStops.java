package Easy;
/*
 * https://leetcode.com/problems/distance-between-bus-stops/
 */
public class E_1184_DistanceBetweenBusStops {

	public int distanceBetweenBusStops(int[] distance, int start, int destination) {
		int n = distance.length, dist = 0, total = 0;

		if(start > destination) {
			int temp = destination;
			destination = start;
			start = temp;
		}
		for(int i = 0; i < n; i++) {
			total += distance[i];
			if(i >= start && i < destination) dist += distance[i];
		}
		return Math.min(dist, total-dist);
	}
	public static void main(String[] args) {
		E_1184_DistanceBetweenBusStops obj = new E_1184_DistanceBetweenBusStops();
		System.out.println(obj.distanceBetweenBusStops(new int[] {1,2,3,4}, 0, 1));
		System.out.println(obj.distanceBetweenBusStops(new int[] {1,2,3,4}, 0, 2));
		System.out.println(obj.distanceBetweenBusStops(new int[] {1,2,3,4}, 3, 2));
	}
}
