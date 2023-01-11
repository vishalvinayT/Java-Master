package stack;


public class MyStatckLinkedList<T> implements StackADT {
    private ListNode<T> top;
    private int size;

    public MyStatckLinkedList(ListNode<T> source){
        this.top=source;

    }

    @Override
    public boolean isEmpty() {
        if(top.value==null){
            return true;
        }
        return false;
    }

    @Override
    public boolean isFull() {
        ListNode<T> p= new ListNode();
        if(p==null){
            return true;
        }
        return false;
    }

    @Override
    public void push(Object value) {
        ListNode<T> copy=this.top;
        if(!isFull()){
            ListNode<T> head= new ListNode(value);
            head.next=copy;
            top=head;
            size++;
        }else{
            throw new StackOverflowError();
        }
    }

    @Override
    public void pop() {
        ListNode<T> copy= this.top;
        if(!isEmpty()){
            top=copy.next;
            size--;
        }else{
            throw  new NullPointerException();
        }
    }

    @Override
    public Object peek(int index) {
        ListNode<T> copy= this.top;
        if(index>=0 && index<size){
            for(int i=0; i<index;i++){
                copy=copy.next;
            }
            return copy.value;
        }else{
            throw new IndexOutOfBoundsException();
        }
    }

    public Object stackTop(){
        if(!isEmpty()){
            return top.value;
        }else {
            throw new NullPointerException();
        }
    }

    public Object stackBottom(){
        ListNode<T> copy= this.top;
        if(!isEmpty()){
            if(copy.next!=null){
                copy=copy.next;
            }
            return copy.value;
        }else{
            throw new NullPointerException();
        }
    }


    public void traverse(){
        ListNode<T> copy=this.top;
        while(!isEmpty()){
            System.out.println(copy.value);
        }
    }
}
