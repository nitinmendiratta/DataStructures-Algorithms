package Easy;
/*
 * https://leetcode.com/problems/find-the-town-judge/
 */
public class E_0997_FindTownJudge {

	// Time O(T + N), space O(N)
	public int findJudge(int N, int[][] trust) {
        int[] count = new int[N+1];
        for (int[] t: trust) {
            count[t[0]]--;
            count[t[1]]++;
        }
        for (int i = 1; i <= N; ++i) {
            if (count[i] == N - 1) return i;
        }
        return -1;
    }
	public static void main(String[] args) {
		E_0997_FindTownJudge obj = new E_0997_FindTownJudge();
		System.out.println(obj.findJudge(4, new int[][] {
			{1,3},{1,4},{2,3},{2,4},{4,3}}));
		System.out.println(obj.findJudge(2, new int[][] {
			{1,2},{2,1}}));
		System.out.println(obj.findJudge(4, new int[][] {
			{1,2},{1,3},{2,1},{2,3},{1,4},{4,3},{4,1}}));
	}
}
