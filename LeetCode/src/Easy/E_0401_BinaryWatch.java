package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/binary-watch/
 */
public class E_0401_BinaryWatch {

	public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
            	// because the biggest number of minutes is 59, which is "111011", 6 bit, so need to left move h to 6 bit which is h<<6 or h*64
                if (Integer.bitCount((h << 6) | m) == num) {
                    res.add(h + ":" + ((m < 10) ? ("0" + m) : m));
                }
            }
        }
        return res;
    }
	public static void main(String[] args) {
		E_0401_BinaryWatch obj = new E_0401_BinaryWatch();
		System.out.println(obj.readBinaryWatch(1));
	}
}
