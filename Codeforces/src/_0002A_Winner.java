import java.util.*;
/*
 * https://codeforces.com/problemset/problem/2/A
 */
public class _0002A_Winner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rounds = sc.nextInt();

		int maxscore = 0;
		HashMap<String, Integer> hm = new HashMap();
		String[] players = new String[rounds];
		int scores[] = new int[rounds];

		for (int i = 0; i < rounds; i++) {

			players[i] = sc.next();
			scores[i] = Integer.valueOf(sc.nextInt()) + hm.getOrDefault(players[i], 0);
			hm.put(players[i], scores[i]);
		}
		
		maxscore = Collections.max(hm.values());
		
		for(int i = 0; i < rounds ; i ++){
			if(maxscore == hm.get(players[i]) && scores[i] >= maxscore){
				System.out.println(players[i]);
				break;
			}
		}
	}
}
