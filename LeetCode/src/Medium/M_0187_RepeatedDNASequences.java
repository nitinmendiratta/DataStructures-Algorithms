package Medium;

import java.util.*;

/*
 * https://leetcode.com/problems/repeated-dna-sequences/
 */
public class M_0187_RepeatedDNASequences {

	/*
	 * The whole idea is to transform the DNA string to numbers (so it'll be quicker
	 * for comparison), and this is actually easy since we know for a fact that the
	 * sequence only consists of 4 letters (all upper case) 'A', 'C', 'G' and 'T'.
	 * 
	 * If we want to map this to binary, we'd need (log 4 = 2) 
	 * 00 -> 'A' 01 -> 'C'
	 * 10 -> 'G' 11 -> 'T'
	 */
	public List<String> findRepeatedDnaSequences(String s) {
		Set<Integer> words = new HashSet<>();
		Set<Integer> doubleWords = new HashSet<>();
		List<String> rv = new ArrayList<>();
		char[] map = new char[26];
		// map['A' - 'A'] = 0;
		map['C' - 'A'] = 1;
		map['G' - 'A'] = 2;
		map['T' - 'A'] = 3;

		/*	So we start with a variable V = 0.
			Then for each letter we shift V to the left by 2 bits and OR it with the letter representation
			so for sequence "CG" for example:
			v = 0
	
			v <<= 2
			v = 00
	
			v |= map[s.charAt(j) - 'A'];
			So map[s.charAt(j) - 'A'] = 0 = 01
			v |= 01 = 01
	
			Nex Character "G":
			v = 01
	
			v <<= 2
			v = 0100
	
			v |= map[s.charAt(j) - 'A'];
			So map[s.charAt(j) - 'A'] = 0 = 10
			v |= 0100 = 0110
	
			and so on for the 10 chars.
		*/
		for (int i = 0; i < s.length() - 9; i++) {
			int v = 0;
			for (int j = i; j < i + 10; j++) {
				v <<= 2;
				v |= map[s.charAt(j) - 'A'];
			}
			if (!words.add(v) && doubleWords.add(v)) {
				rv.add(s.substring(i, i + 10));
			}
		}
		return rv;
	}

	
	// simple solution
	public List<String> findRepeatedDnaSequencesApproach2(String s) {
		Set seen = new HashSet(), repeated = new HashSet();
		for (int i = 0; i + 9 < s.length(); i++) {
			String ten = s.substring(i, i + 10);
			if (!seen.add(ten))
				repeated.add(ten);
		}
		return new ArrayList(repeated);
	}

	public static void main(String[] args) {
		M_0187_RepeatedDNASequences obj = new M_0187_RepeatedDNASequences();
		System.out.println(obj.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
	}

}
