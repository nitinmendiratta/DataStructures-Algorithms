package Easy;

public class WorkPartition {

/*
 * n = hubs
 * d = drivers
 * a[] = number of deliveries at each hub
 */
 	static int MAX_N = 100;
	public int findMax(int A[], int n, int d) {
		int M[][] = new int[MAX_N + 1][MAX_N + 1]; //M[n][d] stands for n hubs, d drivers.
		int cum[] = new int[MAX_N + 1]; //cumulative sums, very quick to get sum for A[i,i+1,...j] with cum[j]-cum[i-1]
		M[0][0] = 0; //Initial value
		cum[0] = 0;
		for (int i = 1; i <= n; i++)
			cum[i] = cum[i - 1] + A[i - 1];

		for (int i = 1; i <= n; i++)
			M[i][1] = cum[i];
		for (int i = 1; i <= d; i++)
			M[1][i] = A[0];

		for (int i = 2; i <= d; i++) {
			for (int j = 2; j <= n; j++) {
				int best = Integer.MAX_VALUE;
				for (int p = 1; p <= j; p++) {
					best = Math.min(best,
							Math.max(M[p][i - 1], cum[j] - cum[p]));
				}
				M[j][i] = best;
			}
		}
		
		return M[n][d];
	}

	public static void main(String[] args) {
		WorkPartition obj = new WorkPartition();
		int a[] = {10,20,30,40,50,60,70,80,90};
		System.out.println(obj.findMax(a,9,3));
	}

}
