

public class Main {
    public static void main(String[] args) {
        try{
            int size=10;
            Integer[] arr=new Integer[10];
            MyStack<Integer> myStack=new MyStack<>(arr,size);
            System.out.println(myStack.isEmpty());
            myStack.push(20);
            myStack.push(400);
            myStack.push(30);
            myStack.push(50);
            myStack.push(60);
            myStack.push(503);
            myStack.push(604);

            myStack.pop();

            System.out.println(myStack.peek(2));

            System.out.println("Stack top is: "+ myStack.stackTop());
            System.out.println("Stack Bottom is: "+ myStack.stackBottom());

            myStack.peekAll();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
}