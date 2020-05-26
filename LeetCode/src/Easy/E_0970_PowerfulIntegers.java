package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/powerful-integers/
 */
public class E_0970_PowerfulIntegers {

	// try all combinations
	public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> result = new HashSet<>();
        
        // a will be x then x*x then x*x*x and so on..
        for (int a = 1; a < bound; a *= x) {
        	// similarly b will be y then y*y and so on..
            for (int b = 1; a + b <= bound; b *= y) {
            	// any any valid combination
                result.add(a + b);
                if (y == 1) {
                    break;
                }
            }
            if (x == 1) {
                break;
            }
        }
        return new ArrayList<>(result);
    }
	
	/*
	 * Math approach If x^i > bound, the sum x^i + y^j can't be less than or
	 * equal to the bound. Similarly for y^j. 
	 * Thus, we only have to check for 0 <= i, j <= log_x(bound) <= 19
	 * 
	 * Why 19?
	 * 2^19 = 524,288. And (2^19) + 1 = 524,289. 
	 * And 524,289 <= 10^6.
	 */
	
	public List<Integer> powerfulIntegersApproach2(int x, int y, int bound) {
        Set<Integer> seen = new HashSet<Integer>();
        for (int i = 0; i < 18 && Math.pow(x, i) <= bound; ++i)
            for (int j = 0; j < 18 && Math.pow(y, j) <= bound; ++j) {
                int v = (int) Math.pow(x, i) + (int) Math.pow(y, j);
                if (v <= bound)
                    seen.add(v);
            }

        return new ArrayList<Integer>(seen);
    }
	public static void main(String[] args) {
		E_0970_PowerfulIntegers obj = new E_0970_PowerfulIntegers();
		System.out.println(obj.powerfulIntegers(2, 3, 10));
	}
}
