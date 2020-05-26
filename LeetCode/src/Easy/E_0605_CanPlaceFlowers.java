package Easy;
/*
 * https://leetcode.com/problems/can-place-flowers/
 */
public class E_0605_CanPlaceFlowers {

	public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length, i = 0;
        
        while(i < len && n > 0){
            // curr pos to be right place, prev and next both should be 0
            if((i == 0 || flowerbed[i-1] == 0) && flowerbed[i] == 0 && (i == len -1 || flowerbed[i+1] == 0)){
               n--;
               i++;
            } 
            i++;
        }
        if(n == 0) return true;
        return false;
    }
	public static void main(String[] args) {
		E_0605_CanPlaceFlowers obj = new E_0605_CanPlaceFlowers();
		int[] flowerbed = {1,0,0,0,1};
		System.out.println(obj.canPlaceFlowers(flowerbed, 1));
	}
}
