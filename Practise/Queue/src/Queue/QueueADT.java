package Queue;

public abstract class QueueADT<T> {
    public int frontIndex=-1;
    public int backIndex=-1;
    public int size;
    public abstract boolean isEmpty();
    public abstract boolean isFull();
    public abstract T queueTop();
    public abstract T queueBottom();
    public abstract void enQueue(T value);
    public abstract T deQueue();

}
