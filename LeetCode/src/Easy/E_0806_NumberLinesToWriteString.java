package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/number-of-lines-to-write-string/
 */
public class E_0806_NumberLinesToWriteString {

	public int[] numberOfLines(int[] widths, String S) {
		int total = 0, width = 0, i = 0, count = 1;
        while(i < S.length()){
            width = widths[S.charAt(i) - 'a'];
            total += width;
            if(total > 100){
                count++;
                i--;
                total = 0;
            }
            i++;
        }
        return new int[]{count, total};
    }
	public static void main(String[] args) {
		E_0806_NumberLinesToWriteString obj = new E_0806_NumberLinesToWriteString();
		int[] widths = new int[] {4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
		String S = "bbbcccdddaaa";
		System.out.println(Arrays.toString(obj.numberOfLines(widths, S)));
	}
}
