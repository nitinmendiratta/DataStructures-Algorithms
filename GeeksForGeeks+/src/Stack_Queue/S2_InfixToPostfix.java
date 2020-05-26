// https://www.geeksforgeeks.org/stack-set-2-infix-to-postfix/
package Stack_Queue;
import java.util.*;
/*
 * Input Postfix expression must be in a desired format.
 * Operands and operator, both must be single character.
 * Only '+', '-', '*', '/' and '^' (for exponentiation)  operators are expected. 
*/
public class S2_InfixToPostfix{

    public String infixToPostfix(String expression){
        String postfixExpression = "";// Initialize postfix as empty string.
        char[] exp = expression.toCharArray();
        // Declaring a Stack 
        Stack<Character>  stack = new Stack<Character>();
        for(int i = 0;i < exp.length;i++){
            // Scanning each character from left. 
		    // If character is a delimitter, move on. 
		    if(exp[i] == ' ' || exp[i] == ',') continue;
            // Else if character is an operand
            else if(isOperand(exp[i])){
                postfixExpression = postfixExpression + exp[i];
            }
            else if(isOperator(exp[i])){
                while((!stack.isEmpty())&&(hasHigherPrecedence(stack.peek(),exp[i]))
                		&&(!isOpeningParenthesis(stack.peek()))){
                        postfixExpression = postfixExpression + stack.pop();
                }
                stack.push(exp[i]);
            }
            else if(isOpeningParenthesis(exp[i])){
                stack.push(exp[i]);
            }
            else if(isClosingParenthesis(exp[i])){
                while(!stack.isEmpty() && !isOpeningParenthesis(stack.peek())){
                    postfixExpression = postfixExpression + stack.pop();
                }
                stack.pop();
            }
        }

        while(!stack.isEmpty()){
            postfixExpression = postfixExpression + stack.pop();
        }
        return postfixExpression;
    }

    // Function to verify whether a character is english letter or numeric digit. 
    // We are assuming in this solution that operand will be a single character
    public boolean isOperand(char operand){
        if(operand >= '0' && operand <= '9') return true;
	    if(operand >= 'a' && operand <= 'z') return true;
	    if(operand >= 'A' && operand <= 'Z') return true;
	    return false;
    }
    // Function to verify whether a character is operator symbol or not.
    public boolean isOperator(char operator){
        if(operator == '+' || operator == '-' || operator == '/' || operator == '*' 
                || operator == '^') return true;
        return false;
    }

    // Function to perform an operation and return output.
    public boolean hasHigherPrecedence(char op1, char op2){
        int op1Weight = getOperatorWeight(op1);
	    int op2Weight = getOperatorWeight(op2);
 
	    // If operators have equal precedence, return true if they are left associative. 
	    // return false, if right associative. 
	    // if operator is left-associative, left one should be given priority. 
	    if(op1Weight == op2Weight){
		    if(isRightAssociative(op1)) return false;
		    else return true;
	    }
	    return op1Weight > op2Weight ?  true: false;
    }

    // Function to get weight of an operator. An operator with higher weight will have 
    // higher precedence. 
    public int  getOperatorWeight(char op){
	    int weight = -1; 
	    switch(op){
	        case '+':
	        case '-':
	    	    weight = 1;break;
	        case '*':
	        case '/':
	    	    weight = 2;break;
	        case '^':
	    	    weight = 3;
	    }
	    return weight;
    }
    
    // Function to verify whether an operator is right associative or not.
    public boolean isRightAssociative(char op){
	    if(op == '^') return true;
	    return false;
    }

    public boolean isOpeningParenthesis(char paranthesis){
        if(paranthesis == '(' || paranthesis == '[' || paranthesis == '{')
            return true;
        else return false;
    }

    public boolean isClosingParenthesis(char paranthesis){
        if(paranthesis == ')' || paranthesis == ']' || paranthesis == '}')
            return true;
        else return false;
    }

    public static void main(String[] args){
        S2_InfixToPostfix obj = new S2_InfixToPostfix();
        String expression; 
	    System.out.println("Enter infix expression");
        Scanner in = new Scanner(System.in);
        expression = in.nextLine();
	    String postfix = obj.infixToPostfix(expression);
	    System.out.println("Postfix expression is:"+postfix);
    }
}
