package Sorting_Searching;

import java.util.*;

 /*Merge Sort. Merge Sort does \theta(nLogn)operations in all cases. Most of the other sorting algorithms have worst and best cases. 
  * In the typical implementation of Quick Sort (where pivot is chosen as a corner element), the worst occurs when the input array is 
  * already sorted and the best occur when the pivot elements always divide array in two halves. For insertion sort, the worst case 
  * occurs when the array is reverse sorted and the best case occurs when the array is sorted in the same order as output.
  *
  * if we want to compare standard sorting algorithms on the basis of space, then Auxiliary Space would be a better criteria than 
  * Space Complexity. Merge Sort uses O(n) auxiliary space, Insertion sort and Heap Sort use O(1) auxiliary space. Space complexity
  * of all these sorting algorithms is O(n) though.
*/
public class SS2_Sorting{
    public static void main(String[] args){
        /*System.out.println("Enter the number of elements you wanna sort");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> arrList = new ArrayList<Integer>();
        System.out.println("Enter elements");
        for(int i=0;i<n;i++){
            in = new Scanner(System.in);
            int input = in.nextInt();
            arrList.add(input);
        }
        int listSize = arrList.size();
        */
        System.out.println("Please choose option for  the type of sorting you want:\n"+
               "1 For Bubble Sort\n"+
               "2 For Selection Sort\n"+
               "3 For Insertion Sort\n"+
               "4 For Shell Sort\n"+
               "5 For Merge Sort\n"+
               "6 For Heap Sort\n"+
               "7 For Quick Sort\n"+
               "8 FOR Tree Sort\n"+
               "9 FOR Counting Sort\n"+
               "10 For Bucket Sort\n"+
               "11 For Radix Sort");
        Scanner in = new Scanner(System.in);
        in = new Scanner(System.in);
        int option = in.nextInt();
        //List<Integer> result;
         
        int[] arr = {1,4,1,2,7,5,2};
        switch (option) {
            case 1: bubbleSort(arr);break;
            case 2: selectionSort(arr);break;
            case 3: insertionSort(arr);break;
            case 4: shellSort(arr);break;
            case 5: mergeSort(arr);break;
            case 6: heapSort(arr);break;
            //case 7: quickSort(arr);break;
            //case 8: treeSort(arr);break;
            case 9: countingSort(arr, 9);break;
            //case 10 bucketSort(arr);break;
            //case 11: radixSort(arr);break;
            default: bubbleSort(arr);break;
        }
       System.out.println("Sorted elememnts are:");
       
       for(int i = 0;i < arr.length;i++){
			System.out.print(arr[i]+",");
       }
    }

/* BUBBLE SORT
 * T(n)=(n-1)*(n-1)*c
 * T(n)=O(n2)
 * works by repeatedly stepping through the list to be sorted, comparing each pair of 
 * adjacent items and swapping them if they are in the wrong order. The pass through the
 * list is repeated until no swaps are needed, which indicates that the list is sorted. 
 * The algorithm gets its name from the way smaller elements "bubble" to the top of the 
 * list. Because it only uses comparisons to operate on elements, it is a comparison sort.
 *
 * Improvement can be done in second loop as everytime we have some part as unsorted and
 * some part as sorted.So there is no point in passing through the sorted part bcoz there 
 * will be no swapping in that part. For first pass we can run this inner loop till n-2, 
 * for the second pass we can run this inner loop till n-3 and we will be good. For the 
 * third pass, we can only run till n-4 and so on. So in general we can run the loop till 
 * n-k-1, so when k is 1, we can run till n-2 , when k is 2 we will run till n-3 all this 
 * will make some improvement but in this case also if you will calculate the time 
 * expression it will be some polynomial of the O(n^2).
 * 1 more improvement that can be made is that we can have a flag variable that checks if 
 * there was a swap in the whole inner cycle if not that means that the array is sorted so 
 * there is no need of running the loop again and we can break out of it in the array
 * So for the improved version we have
 * Best case T(n) = O(n) because we have input as a already sorted array than it will take
 * constant time c, in the worst case time taken will be c*(n-1).
 * Avg case: T(n) = O(n^2)
 * Worst case: O(n^2)
 */

    public static void bubbleSort(int[] inputArrList){

        //improvement in changing the inner loop from inputArrList.size()-2
        //to inputArrList.size()-k-1
        /*for(int k = 0;k <= n-2;k++){
            int flag = 0;
            for(int i = 0;i <= n-k-2;i++){
                if(inputArrList.get(i) > inputArrList.get(i+1)){
                    swap(inputArrList,i,i+1);
                    flag =1;//improvement
                }
            }
            if(flag==0) break;
        }
        return inputArrList;*/
      }

/* SELECTION SORT
 * Worst case performance	Ðž(n2)
 * Best case performance	Ðž(n2)
 * Average case performance	Ðž(n2)
 * Worst case space complexity  Ðž(n) total, O(1) auxiliary
 *
 * The algorithm divides the input list into two parts: the sublist of items already
 * sorted, which is built up from left to right at the front (left) of the list, and
 * the sublist of items remaining to be sorted that occupy the rest of the list.
 * Initially, the sorted sublist is empty and the unsorted sublist is the entire input list.
 * The algorithm proceeds by finding the smallest (or largest, depending on sorting order) 
 * element in the unsorted sublist, exchanging it with the leftmost unsorted element
 * (putting it in sorted order), and moving the sublist boundaries one element to the right.
 *
 * 64 25 12 22 11 // this is the initial, starting state of the array
 * 11 25 12 22 64 // sorted sublist = {11} //after swapping 64 and 11
 * 11 12 25 22 64 // sorted sublist = {11, 12} //after swapping 12 and 25
 * 11 12 22 25 64 // sorted sublist = {11, 12, 22} //no swapping
 * 11 12 22 25 64 // sorted sublist = {11, 12, 22, 25} //no swapping
 * 11 12 22 25 64 // sorted sublist = {11, 12, 22, 25, 64}	//no swapping
 */
    public static void selectionSort(int[] inputArrList) {
        /*for(int i = 0; i < n-1; i++){
            int iMin = i;
            for (int j = i+1; j < n; j++){
                if(inputArrList.get(iMin) > inputArrList.get(j)){
                    iMin = j;
                }
             }
             swap(inputArrList,iMin,i);
        }
        return inputArrList;*/
    }

 /* INSERTION SORT
  *http://www.youtube.com/watch?v=i-SKeOcBwko
  * Relation to other sorting algorithms
  * Insertion sort is very similar to selection sort. As in selection sort, after k passes through the array,
  * the first k elements are in sorted order. For selection sort these are the k smallest elements, while in
  * insertion sort they are whatever the first k elements were in the unsorted array. Insertion sort's advantage
  * is that it only scans as many elements as needed to determine the correct location of the k+1st element, while
  * selection sort must scan all remaining elements to find the absolute smallest element.
  *
  * Calculations show that insertion sort will usually perform about half as many comparisons as selection sort.
  * Assuming the k+1st element's rank is random, insertion sort will on average require shifting half of the 
  * previous k elements, while selection sort always requires scanning all unplaced elements. If the input array
  * is reverse-sorted, insertion sort performs as many comparisons as selection sort. If the input array is already 
  * sorted, insertion sort performs as few as n-1 comparisons, thus making insertion sort more efficient when given 
  * sorted or "nearly sorted" arrays.
  *
  * While insertion sort typically makes fewer comparisons than selection sort, it requires more writes because the 
  * inner loop can require shifting large sections of the sorted portion of the array. In general, insertion sort 
  * will write to the array O(n2) times, whereas selection sort will write only O(n) times. For this reason selection
  * sort may be preferable in cases where writing to memory is significantly more expensive than reading, such as with
  * EEPROM or flash memory.
  *
  * Some divide-and-conquer algorithms such as quicksort and mergesort sort by recursively dividing the list into 
  * smaller sublists which are then sorted. A useful optimization in practice for these algorithms is to use insertion
  * sort for sorting small sublists, where insertion sort outperforms these more complex algorithms. The size of list for
  * which insertion sort has the advantage varies by environment and implementation, but is typically between eight and
  * twenty elements. A variant of this scheme runs quicksort with a constant cutoff K, then runs a single insertion sort
  * on the final array:
  *
  * proc quicksort(A, lo, hi)
  *     if hi - lo < K
  *             return
  * pivot â†� partition(A, lo, hi)
  * quicksort(A, lo, pivot-1)
  * quicksort(A, pivot + 1, hi)
  * proc sort(A)
  * quicksort(A, 0, length(A))
  * insertionsort(A)
  *
  * This preserves the O(n lg n) expected time complexity of standard quicksort, because after running the quicksort 
  * procedure, the array A will be partially sorted in the sense that each element is at most K positions away from 
  * its final, sorted position. On such a partially sorted array, insertion sort will run at most K iterations of its 
  * inner loop, which is run n-1 times, so it has linear time complexity.
  *
  * Example: The following table shows the steps for sorting the sequence {3, 7, 4, 9, 5, 2, 6, 1}. 
  * In each step, the key under consideration is underlined. The key that was moved (or left in place because it was 
  * biggest yet considered) in the previous step is shown in bold.
  *
(3) 7 4 9 5 2 6 1
3 (7) 4 9 5 2 6 1
3 7 (4) 9 5 2 6 1
3 4 7 (9) 5 2 6 1
3 4 7 9 (5) 2 6 1
3 4 5 7 9 (2) 6 1
2 3 4 5 7 9 (6) 1
2 3 4 5 6 7 9 (1)
1 2 3 4 5 6 7 9
 */

    public static void insertionSort(int[] inputArrList) {
        
       /* for(int i = 1; i < n; i++){
            int value = inputArrList.get(i);
            int hole = i;
            while((hole>0) && (inputArrList.get(hole-1) > value)){
                inputArrList.set(hole,inputArrList.get(hole-1));//a[hole] <- a[hole-1]
                hole--;
            }
            inputArrList.set(hole,value);
        }
        return inputArrList;*/
    }

 /*SHELL SORT(not working)
  * Ref: http://www.youtube.com/watch?v=IlRyO9dXsYE
  * Worst case performance	O(n2)
  * Best case performance	O(n log n)
  * Average case performance	depends on gap sequence
  * Worst case space complexity	Ðž(n) total, O(1) auxiliary
  *
  * Shellsort is a generalization of insertion sort that allows the exchange of items that are far apart. 
  * The idea is to arrange the list of elements so that, starting anywhere, considering every hth element 
  * gives a sorted list. Such a list is said to be h-sorted. Equivalently, it can be thought of as h
  * interleaved lists, each individually sorted.[4] Beginning with large values of h, this rearrangement
  * allows elements to move long distances in the original list, reducing large amounts of disorder quickly,
  * and leaving less work for smaller h-sort steps to do.[5] If the file is then k-sorted for some smaller 
  * integer k, then the file remains h-sorted. Following this idea for a decreasing sequence of h values 
  * ending in 1 is guaranteed to leave a sorted list in the end.
  * the subarrays that Shellsort operates on are initially short; later they are longer but almost ordered.
  * In both cases insertion sort works efficiently.
 */
       public static void shellSort(int[] inputArrList) {
        // Define an interval sequence
           /*int gap = n / 2;
           // Keep looping until the gap is 0 then this becomes an insertion sort
           // hum ye loop pehle gap n/2 se start karke jab tak gap 0 nhi ho jata tab tak chalaenge
	  	    while (gap > 0) {
                // ye loop hai to keep track for the elements in the array we move one by one
                for (int i = 0; (i+gap) < n; i++) {
                    // Continue incrementing outer until the end of the array is reached
                    // we took one more index j that is for moving at an interval gap between elements
			        int j = i;
			        for(;j+gap<n;j=j+gap){
                        // here we compare the elements that are at an interval of gap and swap if first is larger
                        // than the second
                        if(inputArrList.get(j) > inputArrList.get(j+gap)){
                            swap(inputArrList,j,(j+gap));
                            // one more index is created to track the previous elements ie if the elements previous
                            // to the current element at gap interval are sorted or not if not we swap them
                            int index=j;
                            //this loop tracks that all the elements are sorted at gap intervals 
			                while (((index-gap) >= 0) && (inputArrList.get(index-gap) > inputArrList.get(index))) {
				                swap(inputArrList,(index-gap),index);
				                index = (index - gap);
                            }
			            }
                    }
                }

                gap = gap/2;
            }
            return inputArrList;*/
    }
    
    /* MERGE SORT
     * http://www.youtube.com/watch?v=TzeBrDU-JaY
     * Worst case performance	O(n log n)
     * Best case performance	O(n log n) typical, O(n) natural variant
     * Average case performance	O(n log n)
     * Worst case space complexity	O(n) auxiliary(that is not in quick sort)
     *
    */
    public static void mergeSort(int[] inputArrList) {
        /*List<Integer> inputLeftList = new ArrayList<Integer>();
        List<Integer> inputRightList = new ArrayList<Integer>();
        if(n < 2) return inputArrList;
        int mid = n/2;
        inputLeftList = new ArrayList<Integer>(inputArrList.subList(0,mid));
        inputRightList = new ArrayList<Integer>(inputArrList.subList(mid,n));
     
        mergeSort(inputLeftList,mid);
        mergeSort(inputRightList,n-mid);
        mergeHelper(inputLeftList,mid,inputRightList,n-mid,inputArrList);
        return inputArrList;*/
    }

    /*public static void mergeHelper(List<Integer> leftList, int lLength, List<Integer> rightList, 
        int rLength, List<Integer> originalList){
        int i=0,j=0,k=0;
        while(i < lLength && j < rLength){
            if(leftList.get(i) < rightList.get(j)) originalList.set(k++,leftList.get(i++));
            else originalList.set(k++,rightList.get(j++));
        } 
        while(j < rLength) originalList.set(k++,rightList.get(j++));
        while(i < lLength) originalList.set(k++,leftList.get(i++));
    }*/
    /*
     * http://www.sanfoundry.com/java-program-implement-heap-sort/
    */
    public static void heapSort(int[] inputArrList) {
        //TODO: will complete during priority queue chapter
        
        //return inputArrList;
    }

    /*QUICK SORT
     * worst case performance	O(n2)
     * Best case performance	O(n log n) (simple partition) or O(n) (three-way partition and equal keys)
     * Average case performance	O(n log n)
     * Worst case space complexity	O(n) auxiliary (naive) O(log n) auxiliary
     * PSEUDO CODE
     * QuickSort(A.end,start){
     *  if(start<end){
     *      pIndex <- partition(A,start,end);
     *      QuickSort(A,start,pIndex-1);
     *      QuickSort(A,Index+1,end);   
     *  }
     * }
     *
     * Partition(A,start,end){
     *  pivot <- A[end]
     *  pIndex <- start
     *
     *  for i <- start to end{
     *      if(A[i] <= pivot){
     *          swap(A[i],A[pIndex])
     *          pIndex++
     *      }
     *  }
     *  swap(pIndex,end)
     *  return pIndex
     * }
     *
     * The idea is to push all the elements less than pivot to the right of pIndex
     *
    */
    public static void quickSort(int[] inputArrList, int start, int end) {
        /*if(start < end){
            int pIndex = randomizedPivotSelector(inputArrList,start,end);
            quickSort(inputArrList, start, pIndex-1);
            quickSort(inputArrList, pIndex+1, end);
        }
        return inputArrList;*/
    }

    //this random pivot generator improves the worst case complexity in sorting
    /*public static int randomizedPivotSelector(List<Integer> tempList,int start, int end){
        Random rand = new Random();
        int pivotIndex = rand.nextInt((end - start)+1) + start;
        swap(tempList,pivotIndex,end);
        int pIndex = quickSortPartitioner(tempList,start,end);
        return pIndex;
    }
    //helper function that returns the index for which all elements left are lesser and to the right all are larger
    public static int quickSortPartitioner(List<Integer> partitionList, int start, int end){
        int pivot = partitionList.get(end);
        int pIndex = start;
        for(int i = start; i < end ; i++){
          if(partitionList.get(i) <= pivot){
            swap(partitionList, pIndex, i);
            pIndex++;
         }
        }
        swap(partitionList,pIndex,end);
        return pIndex;
    }*/
     /*
      * 
     */
    public static void treeSort(int[] inputArrList, int n) {
        //TODO: Will complete when doing BST 
        //return inputArrList;
    }

     /*
      * http://www.geeksforgeeks.org/counting-sort/
     */

    public static void countingSort(int[] arr, int range) {
    	int n = arr.length;
    	 
        // The output character array that will have sorted arr
        int output[] = new int[n];
 
        // Create a count array to store count of inidividul
        // characters and initialize count array as 0
        int count[] = new int[range];
        for (int i=0; i < range; ++i)
            count[i] = 0;
 
        // store count of each character
        for (int i=0; i<n; ++i)
            ++count[arr[i]];
 
        // Change count[i] so that count[i] now contains actual
        // position of this character in output array
        for (int i=1; i < range; ++i)
            count[i] += count[i-1];
 
        // Build the output character array
        for (int i = 0; i<n; ++i)
        {
            output[count[arr[i]]-1] = arr[i];
            --count[arr[i]];
        }
 
        // Copy the output array to arr, so that arr now
        // contains sorted characters
        for (int i = 0; i<n; ++i)
            arr[i] = output[i];
    } 

    /*
     * works by partitioning an array into a number of buckets. Each bucket is then sorted individually,
     * either using a different sorting algorithm, or by recursively applying the bucket sorting algorithm.
     * It is a distribution sort, and is a cousin of radix sort in the most to least significant digit 
     * flavour. Bucket sort is a generalization of pigeonhole sort. Bucket sort can be implemented with 
     * comparisons and therefore can also be considered a comparison sort algorithm. The computational 
     * complexity estimates involve the number of buckets.
     *
     * Bucket sort works as follows:
     * Set up an array of initially empty "buckets".
     * Scatter: Go over the original array, putting each object in its bucket.
     * Sort each non-empty bucket.
     * Gather: Visit the buckets in order and put all elements back into the original array.
    */
    
    /*http://www.youtube.com/watch?v=ovAfqUafjAA
     */
    public static void bucketSort(int[] inputArrList) {
        //return inputArrList;
    }

    /*
     * 
    */

    /*public static List<Integer> radixSort(List<Integer> inputArrList, int n) {
        //return inputArrList;
    } */
    /*
     *
    */

    /*public static List<Integer> topologicalSort(List<Integer> inputArrList, int n) {
        //TODO: Will complete when doing graphs
        //return inputArrList;
    }*/

    public static void externalSort(int[] inputArrList, int n) {
        //TODO: Will complete later
        //return inputArrList;
    }

    public static void swap(int[] tempInputArrList,int i, int j){
        int temp = 0;
        temp = tempInputArrList[i];
        tempInputArrList[i] = tempInputArrList[j];
        tempInputArrList[j] = temp;
    }

}
