//http://quiz.geeksforgeeks.org/stack-set-3-reverse-string-using-stack/
package Stack_Queue;
import java.util.*;

/*
 * Time Complexity wud be O(n) as the push and pop loop are running till size of array
 * Space Complexity is also O(n) as we are placing all elements in stack
 * Better approach wud be too take pointers one from start the other from endand swap
 * one by one until i<j. This algo uses constant space but the time complexity is still
 * O(n).    
 */
public class S4_ReverseStringUsingStack{

     public static void main(String[] args){
        System.out.println("Enter a string to be reversed");
        Scanner in = new Scanner(System.in);
        String strInput = in.nextLine();

        char[] arr = strInput.toCharArray();
        int size = arr.length;

        Stack<Character> stack = new Stack<Character>();
        for(int i = 0;i<size;i++){
            stack.push(new Character(arr[i]));
        }
        StringBuffer sb = new StringBuffer();
        System.out.println("Reversed String is:");
        for(int i = 0;i<size;i++){
            sb.append(stack.pop());
            //System.out.print(out);
        }
        System.out.println(sb);

    }
}
