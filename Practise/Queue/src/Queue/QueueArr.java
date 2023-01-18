package Queue;

import java.util.Arrays;
import java.util.EmptyStackException;

public class QueueArr<T> extends QueueADT<T>{
    private Object[] queuearr;
    private Object[] copyArr;
    private int size;
    public int queueSize=0;
    public QueueArr(int size){
        super.frontIndex=0;
        super.backIndex=0;
        this.size=size;
        this.queuearr= new Object[this.size];
    }

    @Override
    public boolean isEmpty() {
        if(backIndex==frontIndex){
            return true;
        }
        return false;
    }

    @Override
    public boolean isFull() {
        if((backIndex+1)%size==frontIndex){
            return true;
        }
        return false;
    }

    @Override
    public T queueBottom() {
        if(!isEmpty()){
            return (T) queuearr[backIndex];
        }
        else{
            return null;
        }
    }
    @Override
    public T queueTop() {
        if(!isEmpty()){
            return (T) queuearr[(frontIndex+1)%size];
        }else {
            return null;
        }
    }

    @Override
    public void enQueue(T value) {
        // converted code from Old commit queue code to new circular queue code
        if(!isFull()){
            backIndex= (backIndex+1) % size;
            queuearr[backIndex]=value;
            queueSize++;
        }else{
            System.out.println("Queue is Full");
            throw new StackOverflowError();
        }


    }

    @Override
    public T deQueue() {
        // converted code from Old commit queue code to new circular queue code
        if(!isEmpty()){
            frontIndex=(frontIndex+1)%size;
            queueSize--;
            return (T) queuearr[frontIndex];
        }

        System.out.println("Queue is Empty");
        throw new EmptyStackException();
    }


    @Override
    public void traverse(){
        if(!isEmpty()){
            int startIndex=frontIndex;
            for(int i=0 ; i<queueSize ;i++){
                startIndex=(startIndex+1)%size;
                System.out.println(queuearr[startIndex]);
            }
            return;
        }
        System.out.println("Queue is Empty");

    }
}
