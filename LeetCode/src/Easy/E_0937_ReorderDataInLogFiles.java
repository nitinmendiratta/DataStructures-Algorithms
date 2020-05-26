package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/reorder-data-in-log-files/
 */
public class E_0937_ReorderDataInLogFiles {

	class customSort<T> implements Comparator<String> {

		/*
		 * value > 0 log1 is greater than log2
		 * value = 0 log1 is equal to log2
		 * value < 0 log1 is less than log2
		 */
		public int compare(String log1, String log2) {
			String[] split1 = log1.split(" ", 2);
			String[] split2 = log2.split(" ", 2);
			boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
			boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

			if (!isDigit1 && !isDigit2) {
				int cmp = split1[1].compareTo(split2[1]);
				if (cmp != 0) return cmp;
				return split1[0].compareTo(split2[0]);
			}

			// log1 is digit log and log2 is letter we return 1 means log1 > log2 so log2 will be put before log1
			return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
		}
	}
	public String[] reorderLogFiles(String[] logs) {
		Arrays.sort(logs, new customSort<String>());
		return logs;
	}



	// my approach
	public String[] reorderLogFilesApproach2(String[] logs) {

		ArrayList<String> digitLog = new ArrayList<String>();
		ArrayList<String> wordLog = new ArrayList<String>();

		for(int i = 0; i < logs.length; i++){
			if(isDigitLog(logs[i])) {
				digitLog.add(logs[i]);
			}else {
				wordLog.add(logs[i]);
			}
		}
		Collections.sort(wordLog, new MyComparator<String>());
		wordLog.addAll(digitLog);
		return wordLog.toArray(new String[logs.length]);
	}
	class MyComparator<T> implements Comparator<String> {
		private String getDescription(String s, boolean compareOnlyKey) {
			// get all String after CODE
			String[] all = s.split(" ", 2);

			// if there is some content
			if (all.length >= 2) {
				if(compareOnlyKey) return all[0].toLowerCase();
				// get it in LOWER CASE
				return all[1].toLowerCase();
			}
			else 
				return "";
		}

		public int compare(String s0, String s1) {
			String s0Desc = getDescription(s0, false);
			String s1Desc = getDescription(s1, false);

			if(s0Desc.equals(s1Desc)) {
				s0Desc = getDescription(s0, true);
				s1Desc = getDescription(s1, true);
			}
			return s0Desc.compareTo(s1Desc);
		}
	}
	public boolean isDigitLog(String log) {
		int i = 0;
		while(log.charAt(i) != ' ') i++;
		if(Character.isDigit(log.charAt(i+1))) return true;
		return false;
	}

	public static void main(String[] args) {
		E_0937_ReorderDataInLogFiles obj = new E_0937_ReorderDataInLogFiles();
		System.out.println(Arrays.toString(obj.reorderLogFiles(new String[] {"dig1 8 1 5 1","let11 art can","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"})));
	}
}
