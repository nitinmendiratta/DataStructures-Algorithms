//http://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
package Stack_Queue;
import java.util.*;
/*
 *  The properties that must hold are:-
 *  1. Every opening parenthesis must find a closing counterpart to its right.
 *  2. Every closing parenthesis must find an opening counterpart to it's left.
 *  3. A parenthesis shud be closed only when all the parenthesis opened after
 *  it are closed.ie last unclosed shud be the first one to be closed.
 *
 *  Algorithm:
 *  Scan from left to right.
 *  If opening symbol, push it into a stack.
 *  If closing symbol and top of stack = opening of same type pop.
 *  Should end with an empty list.
 */
//Time Complexity: O(n)
//Auxiliary Space: O(n) for stack.
public class S6_CheckBalancedParenthesesUsingStack{

    public static boolean isPair(char a, char b){
        if((a == '[') && (b == ']')) return true;
        else if((a == '{') && (b == '}')) return true;
        else if((a == '(') && (b == ')')) return true;
        else return false;
    }
    
    public static boolean isParenthesisBalanced(String expression){
        char[] arr = expression.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0;i < arr.length; i++){
            if(arr[i] == '[' || arr[i] == '{' || arr[i] == '('){
                stack.push(arr[i]);
            }
            else if(arr[i] == ']' || arr[i] == '}' || arr[i] == ')'){
                if(stack.isEmpty() || !isPair(stack.peek(),arr[i]))
                    return false;
                else
                    stack.pop();
            }
        }
        return stack.isEmpty() ? true:false;
    }

    public static void main(String[] args){
      System.out.println("Enter an expression");
      Scanner in = new Scanner(System.in);
      String exp = in.nextLine();
      if(isParenthesisBalanced(exp))
        System.out.println("Paranthesis balanced");
      else
        System.out.println("Paranthesis unbalanced");
    }
}
