package match;

import stack.ListNode;
import stack.MyStatckLinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        //String expression="(3x(4+8)-9";
        //String matching=parenthesisEvaluate(expression)? "parenthesis are matching": "parenthesis are not matching";
        String expression="[3*23+(23+2)-{5+(90/3)-0}]-99)";
//        String matching=multipleParenthesisMatching(expression)? "parenthesis are matching": "parenthesis are not matching";
//        System.out.println(matching);
        String infixExpression="x-y/z-k*d";
        String postfixExpression=GeneratePostfixExpression.convertInfixPostfix(infixExpression);
        System.out.println(postfixExpression);

    }
    public static boolean parenthesisEvaluate(String expression){
        if(expression!=null){ // Guard Closing
            char[] expressionArray= expression.toCharArray();
            ListNode<Character> list= new ListNode<>();
            MyStatckLinkedList<Character> stack= new MyStatckLinkedList<>(list);

            for(char exp: expressionArray){
                if(exp=='('){
                    stack.push(exp);
                }
                if (exp == ')'){
                    if(stack.isEmpty()){
                        return false;
                    }
                    stack.pop();
                }
            }

            if(stack.isEmpty()){
                return true;
            }

        }
        return false;
    }

    public static boolean multipleParenthesisMatching(String expression){
        if(expression!=null){ // Guard Closing
            char[] expressionArray= expression.toCharArray();
            ListNode<Character> list= new ListNode<>();
            MyStatckLinkedList<Character> stack= new MyStatckLinkedList<>(list);

            for(char exp: expressionArray){
                if(exp=='(' || exp=='{' || exp=='[' ){
                    stack.push(exp);
                }
                if (exp == ')' || exp == '}' || exp == ']' ){
                    if(stack.isEmpty()){
                        return false;
                    }
                    char value= (char) stack.stackTop();
                    if(match(value,exp)){
                        stack.pop();
                    }else {
                        return false;
                    }
                }
            }

            if(stack.isEmpty()){
                return true;
            }

        }
        return false;
    }

    public static boolean match(char value , char expression){
        if(value=='(' && expression ==')'){
            return true;
        }
        if(value=='[' && expression ==']'){
            return true;
        }
        if(value=='{' && expression =='}'){
            return true;
        }
        return false;
    }
}