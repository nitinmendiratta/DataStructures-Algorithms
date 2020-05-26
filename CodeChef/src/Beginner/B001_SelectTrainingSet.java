package Beginner;
import java.util.*;
/*
 * https://www.codechef.com/problems/TRAINSET
 * Sample Input:
 * 	First line will contain T, number of test cases. Then the test cases follow.
	The first line of each test case contains a single integer N.
	N lines follow. For each valid i, the i-th of these lines contains a string wi, followed by a space and an integer(boolean) si, denoting the i-th item.
 	3
	3
	abc 0
	abc 1
	efg 1
	7
	fck 1
	fck 0
	fck 1
	body 0
	body 0
	body 0
	ram 0
	5
	vv 1
	vv 0
	vv 0
	vv 1
	vv 1
 */
public class B001_SelectTrainingSet {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for(int i = 0; i < t; i++){
			
			int n = sc.nextInt();
			String str[] = new String[n];
			int bool[] = new int[n];
			
			for(int j = 0; j < n; j++){
				str[j] = sc.next();
				bool[j] = sc.nextInt();
			}
			HashMap<String,Integer> map1 = new HashMap<String,Integer>();
			HashMap<String,Integer> map2 = new HashMap<String,Integer>();
			
			for(int j = 0; j < n; j++){
				if(map1.containsKey(str[j])){
					
					if(bool[j] == 1){
						map1.put(str[j], map1.get(str[j])+1);
						map2.put(str[j], map2.get(str[j])+1);
					}
					else{
						map2.put(str[j], map2.get(str[j])-1);
					}
				}
				else if(map2.containsKey(str[j])){
					if(bool[j] == 0){
						map2.put(str[j], map2.get(str[j])-1);	
					}
					if(bool[j]==1){
						map1.put(str[j],1);
						map2.put(str[j], map2.get(str[j])+1);
					}
				}
				else{
					if(bool[j] == 0){
						map2.put(str[j],-1);	
					}
					if(bool[j] == 1){
						map1.put(str[j],1);
						map2.put(str[j],1);
					}
				}
			}
			int ans = 0;
			for(String as:map2.keySet()){
				if(!map1.containsKey(as))
					map1.put(as,0);
				if(map2.get(as)  <0 && map1.containsKey(as))
					ans += Math.abs(map2.get(as)) + map1.get(as);
				if(map2.get(as) >= 0 && map1.containsKey(as))
					ans += map1.get(as);
			}
			System.out.println(ans);
		}
	}
}
