package Easy;
/*
 * https://leetcode.com/problems/arranging-coins/
 */
public class E_0441_ArrangingCoins {

    // n = (x + 1) * x / 2
    // x² + x = 2n
    // x² + x + 1/4 - 1/4 = 2n
    // (x + 1/2)² = 2n + 1 / 4
    // (x + 1/2)² = (8n + 1) / 4
    // x + 1/2 = sqrt(8n + 1) / 2
    // x = (sqrt(8n + 1) / 2) - (1 / 2)
    // x = (sqrt(8n + 1) - 1) / 2
    public int arrangeCoins(int n) {
        return (int)((Math.sqrt(1 + 8 * (long)n) - 1) / 2);
    }
    public int arrangeCoinsApprach2(int n) {
		if(n < 1) return 0;
        for(int i = 1; ;i++){
            n -=i;
            if(n < 0) return i-1;
        }
    }
    public int arrangeCoinsApprach3(int n) {   
        //convert int to long to prevent integer overflow
        long nLong = (long)n;
        
        long st = 0;
        long ed = nLong;
        
        long mid = 0;
        
        while (st <= ed){
            mid = st + (ed - st) / 2;
            
            if (mid * (mid + 1) <= 2 * nLong){
                st = mid + 1;
            }else{
                ed = mid - 1;
            }
        }
        
        return (int)(st - 1);
    }
	public static void main(String[] args) {
		E_0441_ArrangingCoins obj = new E_0441_ArrangingCoins();
		System.out.println(obj.arrangeCoins(5));
		System.out.println(obj.arrangeCoinsApprach2(5));
		System.out.println(obj.arrangeCoinsApprach3(5));
	}
}
