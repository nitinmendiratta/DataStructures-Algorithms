package Easy;

import java.util.*;

/*
 * https://leetcode.com/problems/destination-city/
 */
public class E_1436_DestinationCity {

	public String destCity(List<List<String>> paths) {
		if (paths == null || paths.size() == 0)
			return "";
		Map<String, String> map = new HashMap<>();
		
		for (List<String> path : paths) {
			map.put(path.get(0), path.get(1));
		}
		for (String city : map.values()) {
			if (!map.containsKey(city)) {
				return city;
			}
		}
		return "";
	}

	public static void main(String[] args) {
		E_1436_DestinationCity obj = new E_1436_DestinationCity();
		List<List<String>> paths = new ArrayList();
		paths.add(Arrays.asList("London", "New York"));
		paths.add(Arrays.asList("New York", "Lima"));
		paths.add(Arrays.asList("Lima", "Sao Paulo"));
		System.out.println(obj.destCity(paths));
	}
}
