package Queue;

import java.util.Arrays;
import java.util.EmptyStackException;

public class QueueArr<T> extends QueueADT<T>{
    private Object[] queuearr;
    private Object[] copyArr;
    private int size;
    public int queueSize=0;
    public QueueArr(int size){
        this.size=size;
        this.queuearr= new Object[this.size];
    }

    @Override
    public boolean isEmpty() {
        if(frontIndex<=0){
            return true;
        }
        return false;
    }



    @Override
    public boolean isFull() {
        if(frontIndex>=this.size-1){
            return true;
        }
        return false;
    }

    @Override
    public T queueBottom() {
        try{
            return (T) queuearr[frontIndex];
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Queue is Empty");
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public T queueTop() {
        try {
            return (T)queuearr[0];
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Queue is Empty");
            throw new ArrayIndexOutOfBoundsException();
        }

    }

    @Override
    public void enQueue(T value) {
        if(!isFull()){
            frontIndex++;
            queuearr[frontIndex]=value;
            queueSize++;
        }else{
            System.out.println("Queue is Full");
            throw new StackOverflowError();
        }


    }

    @Override
    public T deQueue() {
        if(!isEmpty()){
            T result=(T)queuearr[0];
            copyArr= new Object[this.size];
            System.arraycopy(queuearr,1,copyArr,0,queuearr.length-1);
            frontIndex--;
            queueSize--;
            queuearr=copyArr;
            return result;
        }

        System.out.println("Queue is Empty");
        throw new EmptyStackException();
    }
}
