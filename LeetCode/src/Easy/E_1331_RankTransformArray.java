package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/rank-transform-of-an-array/
 */
public class E_1331_RankTransformArray {

	public int[] arrayRankTransform(int[] arr) {
		int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);
        HashMap<Integer, Integer> rank = new HashMap<>();
        for (int x : sortedArr) rank.putIfAbsent(x, rank.size() + 1);
        for (int i = 0; i < arr.length; ++i) arr[i] = rank.get(arr[i]);
        return arr;
	}
	public static void main(String[] args) {
		E_1331_RankTransformArray obj = new E_1331_RankTransformArray();
		System.out.println(Arrays.toString(obj.arrayRankTransform(new int[] {40,10,20,30})));
		System.out.println(Arrays.toString(obj.arrayRankTransform(new int[] {100,100,100})));
	}
}
