package Array_Matrix;
/*
 * http://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
 */
import java.util.*;
/*
 * Print 2d array in spiral order.
 * Here we have taken 4 var topRow,bottomRow,leftCol,rightCol pointing to respective roows 
 * and columns. Also we have taken a dir param which corresponds to the dir in which we 
 * wanna move.
 * dir =0 (->)
 * dir = 1 (down)
 * dir = 2 (<-)
 * dir = 3 (up)
 * so we have 4 cases from dir = 0 to 3 whenever we cover a row or col we don't come to 
 * it again and we do so by modifying the pointers we have taken.
 */
public class PrintMatrixInSpiralForm{

    public void print2dArr(int arr[][], int m, int n){

        int topRow = 0, bottomRow = m-1, leftCol = 0, rightCol = n-1, dir = 0;
        while((topRow <= bottomRow) && (leftCol <= rightCol)){
            if(dir == 0){
                for(int i = leftCol; i<= rightCol;i++)
                    System.out.print(arr[topRow][i]+",");
                    dir = 1;
                    topRow++;
            }
            else if(dir == 1){
                 for(int i = topRow; i<= bottomRow;i++)
                    System.out.print(arr[i][rightCol]+",");
                    dir = 2;
                    rightCol--;
            }
            else if(dir == 2){
                for(int i = rightCol; i >= leftCol;i--)
                    System.out.print(arr[bottomRow][i]+",");
                    dir = 3;
                    bottomRow--;
            }
            else if(dir == 3){
                for(int i = bottomRow; i >= topRow;i--)
                    System.out.print(arr[i][leftCol]+",");
                    dir = 0;
                    leftCol++;
            }
        }
    }

    public static void main(String[] args){
        PrintMatrixInSpiralForm obj = new PrintMatrixInSpiralForm();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter dimensions of the 2d array(mxn)");
        int m = in.nextInt();
        int n = in.nextInt();
        int arr[][] = new int[m][n];
        System.out.println("Enter elements for 2-D array");
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                int input = in.nextInt();
                arr[i][j] = input;
            }
        }
        System.out.println("Elements in spiral order is:");
        obj.print2dArr(arr,m,n);
    }
}
