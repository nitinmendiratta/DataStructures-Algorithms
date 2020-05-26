package Strings;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/given-a-string-find-its-first-non-repeating-character/
 */

class Node{
	int count;
	int index = -1;
}

public class S009_FindFirstNonRepeatingCharacter {

	// better approach
	public void nonRepeatingApproach2(String str){
		char[] a = str.toCharArray();
		Map<Character,Integer> myMap = new LinkedHashMap<Character,Integer>();
		for(char ch: a){
			if(myMap.containsKey(ch)){
				myMap.put(ch, myMap.get(ch)+1);
			}
			else{
				myMap.put(ch, 1);
			}
		}
		
		for(Map.Entry<Character, Integer> entry : myMap.entrySet()){
			if(entry.getValue()==1){
				System.out.println(entry.getKey());
				break;
			}
		}
	}
	
	public void nonRepeatingApproach1(String str){
		int  i = 0, minindx = Integer.MAX_VALUE;
		Node count[] = new Node[256];
		for(i = 0;i < count.length;i++) count[i] = new Node();
		
		for(i = 0;i < str.length();i++){
			int c = str.charAt(i);		
			if(count[c].count != 0){
				count[c].count++;
			}else{
				count[c].index = i;
				count[c].count++;
			}
		}
		i = 0;
		
		while(i < count.length){
			if(count[i].count == 1){
				minindx = Math.min(minindx,count[i].index);
			}
			i++;
		}
		
		if(minindx != Integer.MAX_VALUE){
			System.out.println(str.charAt(minindx));
		}else{
			System.out.println("Not found");
		}
	}
	
	public static void main(String[] args) {
		S009_FindFirstNonRepeatingCharacter obj = new S009_FindFirstNonRepeatingCharacter();
		String s = "geeksforgeeks";
		obj.nonRepeatingApproach1(s);
		obj.nonRepeatingApproach2(s);
	}
}