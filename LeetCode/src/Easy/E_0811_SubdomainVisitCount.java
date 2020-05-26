package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/subdomain-visit-count/
 */
public class E_0811_SubdomainVisitCount {

	public List<String> subdomainVisits(String[] cpdomains) {
		Map<String, Integer> counts = new HashMap();
		for (String domain: cpdomains) {
			String[] cpinfo = domain.split("\\s+");
			String[] frags = cpinfo[1].split("\\.");
			int count = Integer.valueOf(cpinfo[0]);
			String cur = "";
			for (int i = frags.length - 1; i >= 0; --i) {
				cur = frags[i] + (i < frags.length - 1 ? "." : "") + cur;
				counts.put(cur, counts.getOrDefault(cur, 0) + count);
			}
		}

		List<String> ans = new ArrayList();
		for (String dom: counts.keySet())
			ans.add("" + counts.get(dom) + " " + dom);
		return ans;
	}

	public List<String> subdomainVisitsAppraoch2(String[] cpdomains) {
		List<String> res = new ArrayList<>();
		HashMap<String, Integer> hm = new HashMap<>();
		StringBuilder sb;

		for(int i = 0; i < cpdomains.length; i++){

			String[] entry = cpdomains[i].split(" ");
			if(entry.length != 2) break;
			int value = Integer.valueOf(entry[0]);
			int j = entry[1].length()-1;

			sb = new StringBuilder();

			while(j >= 0){
				char curr = entry[1].charAt(j);
				if(curr == '.'){
					hm.put(sb.toString(), hm.getOrDefault(sb.toString(), 0) + value);
				}
				sb.insert(0, curr);
				j--;
			}
			hm.put(sb.toString(), hm.getOrDefault(sb.toString(), 0) + value);
		}
		for (Map.Entry<String, Integer> entry : hm.entrySet()) {
			res.add(entry.getValue() + " " + entry.getKey());
		}
		return res;
	}
	public static void main(String[] args) {
		E_0811_SubdomainVisitCount obj = new E_0811_SubdomainVisitCount();
		System.out.println(obj.subdomainVisits(new String[] {""}));
	}
}
