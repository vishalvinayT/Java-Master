package DEQueue;

/* This is the implementation of DEQueue with circular queue method */


import java.util.EmptyStackException;

public class DEQueueArr<T> extends DEQueueADT<T>{
    public static int size;

    private int dequeueSize=0;
    private Object[] DEQueueArr;
    public DEQueueArr(int sizeOfArray){
        super.front=0;
        super.rear=0;
        size=sizeOfArray;
        DEQueueArr= new Object[size];
    }

    @Override
    protected boolean isEmpty() {
        if(front==rear){
            return true;
        }
        return false;
    }

    @Override
    protected boolean isFull() {
        if((rear+1)%size==front){
            return true;
        }
        return false;
    }

    @Override
    protected void frontEnqueue(T value) {
        // Hey for restricted input DEQueue the frontEnqueue will be out.
        if(!isFull()){
            int frontDecrement= front-1;
            if(frontDecrement<0){
                frontDecrement=size-1;
            }
            DEQueueArr[front]= value;
            front=frontDecrement;
            dequeueSize++;
        }
        else{
            System.out.println("DEQueue is Full");
            throw  new StackOverflowError();
        }
    }

    @Override
    protected void rearEnqueue(T value) {
        if (!isFull()){
            rear=(rear+1)%size;
            DEQueueArr[rear]=value;
            dequeueSize++;
        }
        else{
            System.out.println("DEQueue is Full");
            throw new StackOverflowError();
        }
    }

    @Override
    protected T frontDequeue() {
        if(!isEmpty()){
            front=(front+1)%size;
            T removedValue=(T) DEQueueArr[front];
            dequeueSize--;
            return removedValue;
        }else{
            System.out.println("DEQueue is Empty");
            throw new EmptyStackException();
        }
    }

    @Override
    protected T rearDequeue() {
        // Hey for restricted out DEQueue the rearDequeue will be out.
        if(!isEmpty()){
            T removedValue= (T) DEQueueArr[rear];
            int rearDecrement=rear-1;
            if(rearDecrement<0){
                rearDecrement=size-1;
            }
            dequeueSize--;
            rear=rearDecrement;
            return removedValue;
        }
        else{
            System.out.println("DEQueue is Empty");
            throw new EmptyStackException();
        }
    }

    @Override
    protected void traverse() {
        if(!isEmpty()){
            int val=front;
            for(int i=0; i<dequeueSize; i++){
                val=(val+1)%size;
                T value= (T) DEQueueArr[val];
                System.out.println(value);
            }
            return;
        }
        System.out.println("DEQueue is Empty");
    }
}
