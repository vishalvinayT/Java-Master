package match;

import stack.ListNode;
import stack.MyStatckLinkedList;
import java.util.HashMap;
import java.util.Map;

public class GeneratePostfixExpression {

    public static String convertInfixPostfix(String infixExpression){
        char[] infixExpArr= infixExpression.toCharArray();
        char[] postfixExpArr=  new char[infixExpArr.length];
        MyStatckLinkedList<Character> stack= new MyStatckLinkedList<>(new ListNode<>());
        int i=0;
        int j=0;
        while(i< infixExpArr.length){
            if(!isOperator(infixExpArr[i])){
                postfixExpArr[j]=infixExpArr[i];
                i++;
                j++;
            }
            else{
                int precidenceStackTop= !stack.isEmpty()? precidence(stack.stackTop()) :-1;
                if(precidence(infixExpArr[i])>precidenceStackTop){
                    stack.push(infixExpArr[i]);
                    i++;

                }else{
                    char top=(char) stack.stackTop();
                    postfixExpArr[j]=top;
                    stack.pop();
                    j++;
                }

            }
        }
        while (!stack.isEmpty()){
            char top= (char) stack.stackTop();
            postfixExpArr[j]=top;
            stack.pop();
            j++;
        }
        return new String(postfixExpArr);
    }



    private static boolean isOperator(char value) {
        String operators = "+-/*()[]{}";
        if (operators.indexOf(value) >= 0) {
            return true;
        }
        return false;
    }

    private static int precidence(Object operator){
        Map<Character,Integer> precidenceMap= new HashMap<>();
        precidenceMap.put('+',10);precidenceMap.put('-',10);precidenceMap.put('/',15);precidenceMap.put('*',15);precidenceMap.put('(',20);
        precidenceMap.put(')',20); precidenceMap.put('[',20);precidenceMap.put(']',20);precidenceMap.put('{',20);
        precidenceMap.put('}',20);
        if(operator!=null){
            return precidenceMap.get((char) operator);
        }
        return -1;
    }
}
