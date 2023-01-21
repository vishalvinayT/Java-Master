package DEQueue;

public abstract class DEQueueADT<T> {
    protected int front=-1;
    protected int rear=-1;
    protected abstract boolean isEmpty();
    protected abstract boolean isFull();
    protected abstract void  frontEnqueue(T value);
    protected abstract void  rearEnqueue(T value);
    protected abstract T  frontDequeue();
    protected abstract T  rearDequeue();
    protected abstract void traverse();

}
