
import java.util.Scanner;
/*
 * https://codeforces.com/problemset/problem/1/A
 */
public class _0001A_TheatreSquare {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double m = sc.nextInt();
		double n = sc.nextInt();
		double a = sc.nextInt();
		System.out.println((long) Math.ceil(m / a) * (long) Math.ceil(n / a));
	}

}
