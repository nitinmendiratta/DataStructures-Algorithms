package Sorting_Searching;
import java.util.*;
/*
 * Count occurrences of a number in a sorted array with duplicates using Binary Search
 * here instead of traversing the list for counting occurrences which gives complexity 
 * as O(n) if we choose binary search and calculate first and last occurrence of the
 * repeating element we can get the count
 * So i have created 2 methods which return the first occurrence and last occurrence of
 * the element respectively. Internally both use binary search
 * https://www.youtube.com/watch?v=pLT_9jwaPLs&list=PL2_aWCzGMAwL3ldWlrii6YeLszojgH77j&index=5
 */
public class CountOccurrencesOfaNumberInSortedArray{

    public static int getFirstOccurrenceIndx(List<Integer> inputArrayList, int elem, boolean flagFirstOccurrence){
        int index = -1;
        int start = 0;
        int end = inputArrayList.size()-1;
        while(start <= end){
            int mid = (start+end)/2;
            if(elem == inputArrayList.get(mid)){
                index = mid;
                if(flagFirstOccurrence) end = mid-1;
                else start = mid+1;
            }
            else if(elem < inputArrayList.get(mid)) end = mid-1;
            else start = mid+1;
         }
         return index;
    }
    
    public static void main(String[] args){
        /*BinarySearch input = new BinarySearch();
        List<Integer> arrList = input.getInputArray();

        Sorting sort = new Sorting();
        List<Integer> sortedList = sort.quickSort(arrList,0,arrList.size()-1);
        //System.out.println("Sorted List is:"+sortedList);
        
        System.out.println("Enter the element you wanna count");
        Scanner in = new Scanner(System.in);
        in = new Scanner(System.in);
        int element = in.nextInt();

        int firstOccurrenceIndx = getFirstOccurrenceIndx(sortedList,element,true);
        //System.out.println("Fist index is:"+firstOccurrenceIndx);
        int lastOccurrenceIndx = getFirstOccurrenceIndx(sortedList,element,false);
        //System.out.println("last index is:"+lastOccurrenceIndx);
        if((firstOccurrenceIndx == -1) || (lastOccurrenceIndx == -1)){
            System.out.println("Element not present");
            System.exit(0);
        }
        int result = (lastOccurrenceIndx - firstOccurrenceIndx) + 1;
        System.out.println("Element is present: "+result+" times in the given array");*/
    }
}
