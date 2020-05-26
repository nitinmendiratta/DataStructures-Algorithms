package Array_Matrix;
import java.util.*;
import java.util.Map.Entry;
/*
 * http://www.geeksforgeeks.org/sort-elements-by-frequency/
 * http://www.java-fries.com/2015/02/sort-elements-frequency/
 * 
First step: We will create frequency map.
	Frequency map would look like this {2 = 3, 5 = 3, 3 = 4, 8 =1 , 7 = 1}

Second step: Sort above frequency map by value.
	After sorting frequency map would be {3 = 4, 2 = 3, 5 = 3, 8 =1 , 7 = 1}

Third step: Rearrange array elements from above sorted map.
	{3, 3, 3, 3, 2, 2, 2, 5, 5, 5, 8, 7}
 */
public class A015_SortElementsByFrequency {

	private static void sortByFrequency(int[] arr) {
        Map<Integer, Integer> frequencyMap = createFrequencyMap(arr);
 
        List<Entry<Integer, Integer>> entryList = sortByValue(frequencyMap);
 
        putSortedElementsBackInArray(arr, entryList);
    }
 
    private static Map<Integer, Integer> createFrequencyMap(int[] arr) {
 
        // Use LinkedHashMap because it maintains insertion order of elements.
        Map<Integer, Integer> frequencyMap = new LinkedHashMap<>();
 
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            if (frequencyMap.containsKey(key)) {
                frequencyMap.put(key, frequencyMap.get(key) + 1);
            } else {
                frequencyMap.put(key, 1);
            }
        }
        return frequencyMap;
    }
 
    private static List<Entry<Integer, Integer>> sortByValue(
            Map<Integer, Integer> frequencyMap) {
 
        // List containing elements of map's entry set.
        List<Entry<Integer, Integer>> entryList = new ArrayList<Entry<Integer, Integer>>(
                frequencyMap.entrySet());
 
        // Sort the list.
        Collections.sort(entryList,
                new Comparator<Map.Entry<Integer, Integer>>() {
 
                    @Override
                    public int compare(Entry<Integer, Integer> o1,
                            Entry<Integer, Integer> o2) {
                        return o2.getValue().compareTo(o1.getValue());
                    }
                });
        return entryList;
    }
 
    private static void putSortedElementsBackInArray(int[] arr,
            List<Entry<Integer, Integer>> list) {
        int index = 0;
 
        // Arrange array elements in sorted list of entry set of frequency map.
        for (Map.Entry<Integer, Integer> entry : list) {
            for (int i = 0; i < entry.getValue(); i++) {
                arr[index++] = entry.getKey();
            }
        }
    }
    private static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
    public static void main(String[] args) {
		int[] arr = {2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8};

		System.out.println("Input array before sorting elements by frequency.");
		printArray(arr);

		sortByFrequency(arr);

		System.out.println();
		System.out.println();

		System.out.println("Array after sorting elements by frequency.");
		printArray(arr);
	}
}
