package Sorting_Searching;

import java.util.*;

public class Helper{
       public static List<Integer> getInputArray(){

        List<Integer> arrList = new ArrayList<Integer>();
        System.out.println("Enter the number of elements in the array");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int input = 0;
        System.out.println("Enter the elements");
        for(int i = 0; i < n; i++){
            in = new Scanner(System.in);
            input = in.nextInt();
            arrList.add(input);
        }
        return arrList;
    }

    public static List<Integer> quickSort(List<Integer> inputArrList, int start, int end){
        if(start < end){
            int pIndex = randomizedPivotSelector(inputArrList,start,end);
            quickSort(inputArrList, start, pIndex-1);
            quickSort(inputArrList, pIndex+1, end);
        }
        return inputArrList;
    }

    //this random pivot generator improves the worst case complexity in sorting
    public static int randomizedPivotSelector(List<Integer> tempList,int start, int end){
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
    }

    public static void swap(List<Integer> tempInputArrList,int i, int j){
        int temp = 0;
        temp = tempInputArrList.get(i);
        tempInputArrList.set(i,tempInputArrList.get(j));
        tempInputArrList.set(j,(Integer)temp);
    }
}

