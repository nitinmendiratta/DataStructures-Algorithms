package Medium;

import java.util.*;

/*
 * https://leetcode.com/problems/top-k-frequent-elements/
 */
public class M_0347_TopKFrequentElements {

	/*
	 * Time complexity : O(Nlog(k)). The complexity of Counter method is O(N). To
	 * build a heap and output list takes O(Nlog(k)). Hence the overall complexity
	 * of the algorithm is O(N + N log(k)) = O(Nlog(k)).
	 * 
	 * Space complexity : O(N) to store the hash map.
	 */
	public int[] topKFrequent(int[] nums, int k) {

		HashMap<Integer, Integer> hm = new HashMap();
		int[] res = new int[k];

		// A custom comparator that compares two Strings by their length.
		Comparator<Integer> freqComparator = new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return hm.get(a) - hm.get(b);
			}
		};

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, freqComparator);

		for (int i = 0; i < nums.length; i++) {
			hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
		}

		for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
			pq.offer(entry.getKey());

			if (pq.size() > k) {
				pq.poll();
			}
		}

		int i = 0;
		while (!pq.isEmpty()) {
			res[i] = pq.poll();
			i++;
		}
		return res;
	}

	// Using bucket sort
	public int[] topKFrequentApproach2(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int n : nums) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}

		// corner case: if there is only one number in nums, we need the bucket has
		// index 1.
		List<Integer>[] bucket = new List[nums.length + 1];
		for (int n : map.keySet()) {
			int freq = map.get(n);
			if (bucket[freq] == null)
				bucket[freq] = new LinkedList<>();
			bucket[freq].add(n);
		}

		List<Integer> res = new LinkedList<>();
		for (int i = bucket.length - 1; i > 0 && k > 0; --i) {
			if (bucket[i] != null) {
				List<Integer> list = bucket[i];
				res.addAll(list);
				k -= list.size();
			}
		}

		Object[] objectAarray = res.toArray();
		int[] resArr = new int[objectAarray.length];
		for (int i = 0; i < objectAarray.length; i++) {
			resArr[i] = (int) objectAarray[i];
		}

		return resArr;
	}

	public static void main(String[] args) {
		M_0347_TopKFrequentElements obj = new M_0347_TopKFrequentElements();
		System.out.println(Arrays.toString(obj.topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 3)));
	}
}
