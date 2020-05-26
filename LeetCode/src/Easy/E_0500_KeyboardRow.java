package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/keyboard-row/
 */
public class E_0500_KeyboardRow {

	public String[] findWords(String[] words) {
        String[] strs = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i<strs.length; i++){
            for(char c: strs[i].toCharArray()){
                map.put(c, i);//put <char, rowIndex> pair into the map
            }
        }
        
        List<String> res = new LinkedList<>();
        
        for(String w: words){
            if(w.equals("")) continue;
            int index = map.get(w.toUpperCase().charAt(0));
            for(char c: w.toUpperCase().toCharArray()){
                if(map.get(c) != index){
                    index = -1; //don't need a boolean flag. 
                    break;
                }
            }
            if(index != -1) res.add(w);//if index != -1, this is a valid string
        }
        return res.toArray(new String[0]);
    }
	public static void main(String[] args) {
		E_0500_KeyboardRow obj = new E_0500_KeyboardRow();
		String[] input = {"Hello", "Alaska", "Dad", "Peace"};
		System.out.println(Arrays.toString(obj.findWords(input)));
	}
}
