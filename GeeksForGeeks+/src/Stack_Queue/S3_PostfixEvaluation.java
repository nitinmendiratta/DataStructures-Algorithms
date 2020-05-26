//http://quiz.geeksforgeeks.org/stack-set-4-evaluation-postfix-expression/
package Stack_Queue;
import java.util.*;
/*
 * Input shud be in the form 
 * 2 3*5 4*+9-
 * there shud be space between 2 numbers, this program accepts 2 digit numbers too
 * if number is a 2 digit number enter without space
 */
public class S3_PostfixEvaluation{

    public int postfixEvaluator(String exp){
        char[] arr = exp.toCharArray();
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0;i<arr.length;i++){

           // Scanning each character from left. 
		   // If character is a delimitter, move on. 
		   if((arr[i] == ' ') || (arr[i] == ',')) continue;
           // If character is operator, pop two elements from stack, perform operation and push the result back.
           else if(isOperand(arr[i])){
               System.out.println(arr[i]);
                // Extract the numeric operand from the string keep incrementing i as long as you are getting a numeric digit. 
			    int operand = 0; 
			    while((i<arr.length) && (isOperand(arr[i]))) {
				// For a number with more than one digits, as we are scanning from left to right. 
				// Everytime , we get a digit towards right, we can multiply current total in operand by 10 
				// and add the new digit. arr[i] is a char so we need to remove '0'
				    operand = (operand*10) + (arr[i] - '0'); 
				    i++;
			    }
			    // Finally, you will come out of while loop with i set to a non-numeric character or end of string
			    // decrement i because it will be incremented in increment section of loop once again. 
			    // We do not want to skip the non-numeric character by incrementing i twice. 
			    i--;
                System.out.println("Pushing:"+operand);
                stack.push(operand);
           }
           else if(isOperator(arr[i])){
            // Pop two operands.
            int operand2 = stack.pop();
            int operand1 = stack.pop();
            // Perform operation
            System.out.println("performing:"+arr[i]+" on:"+operand2+","+operand1);
            int result = performOperation(arr[i],operand1,operand2);
            //Push back result of operation on stack.
            System.out.println("result is:"+result);
            stack.push(result);
           }
        }
        return stack.pop();
    }

    public boolean isOperand(char operand){
        if(operand >= '0' && operand <= '9') return true;
	        return false;
    }
    // Function to verify whether a character is operator symbol or not
    public boolean isOperator(char operator){
        if(operator == '+' || operator == '-' || operator == '/' || operator == '*')
            return true;
        else return false;
    }

    public int performOperation(char operator, int op1, int op2){
        if(operator == '+') return (op1 + op2);
        else if(operator == '-') return (op1 - op2);
        else if(operator == '/') return (op1/op2);
        else if(operator == '*') return (op1*op2);
        else 
            System.out.println("Unexpected operation");
        return -1;
    }

    public static void main(String[] args){
        System.out.println("Enter a postfix expression");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        S3_PostfixEvaluation p = new S3_PostfixEvaluation();
        int result = p.postfixEvaluator(input);
        System.out.println("Postfix evaluation is:"+result);
    }
}
