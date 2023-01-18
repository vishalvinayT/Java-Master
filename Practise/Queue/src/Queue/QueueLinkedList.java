package Queue;

import ListPackage.ListNode;

import java.util.EmptyStackException;

public class QueueLinkedList<T> extends QueueADT<T>{
    private ListNode<T> front= null;
    private ListNode<T> rear=null;
    private int queueSize=0;

    @Override
    public boolean isEmpty() {
        if(front==null){
            return true;
        }
        return false;
    }

    @Override
    public boolean isFull() {
        ListNode<T> dummy= new ListNode<>();
        if(dummy==null){
            return true;
        }
        return false;
    }

    @Override
    public T queueTop() {
        if(!isEmpty()){
            return rear.value;
        }
        return null;
    }

    @Override
    public T queueBottom() {
        if(!isEmpty()){
            return front.value;
        }
        return null;
    }

    @Override
    public void enQueue(T value) {
        if(!isFull()){
            ListNode<T> node= new ListNode<>(value);
            if(front==null){
                rear=front=node;
                queueSize++;

            }else{
                rear.next=node;
                rear=node;
                queueSize++;
            }
        }else {
            System.out.println("Queue OverFlow");
            throw new StackOverflowError();
        }
    }

    @Override
    public T deQueue() {
        if(!isEmpty()){
            T value= front.value;
            front=front.next;
            queueSize--;
            return value;
        }else{
            System.out.println("Queue Empty");
            throw new EmptyStackException();
        }
    }

    @Override
    public void traverse() {
        if(!isEmpty()){
            for(ListNode<T> val= front; val!=null; val=val.next){
                System.out.println(val.value);
            }
        }
    }

    public int getQueueSize() {
        return queueSize;
    }
}
