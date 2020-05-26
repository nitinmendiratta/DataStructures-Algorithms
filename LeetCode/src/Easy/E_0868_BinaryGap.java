package Easy;
/*
 * https://leetcode.com/problems/binary-gap/
 */
public class E_0868_BinaryGap {

	public int binaryGap(int n) {
		int maxDist = 0, prev = -1, dist = 0, bit = 0;

		while (n > 0){
			bit = n % 2; 
			n = n / 2;
			dist++;
			if(bit == 1 && prev == -1){
				prev = dist;
			}else if(bit == 1){
				maxDist = Math.max(maxDist, dist-prev);
				prev = dist;
			}
		}
		return maxDist;
	}
	
	public int binaryGapApproach2(int N) {
        int[] A = new int[32];
        int t = 0;
        for (int i = 0; i < 32; ++i)
            if (((N >> i) & 1) != 0)
                A[t++] = i;

        int ans = 0;
        for (int i = 0; i < t - 1; ++i)
            ans = Math.max(ans, A[i+1] - A[i]);
        return ans;
    }
	public static void main(String[] args) {
		E_0868_BinaryGap obj = new E_0868_BinaryGap();
		System.out.println(obj.binaryGap(22));
		System.out.println(obj.binaryGap(5));
		System.out.println(obj.binaryGap(6));
		System.out.println(obj.binaryGap(8));
	}
}
