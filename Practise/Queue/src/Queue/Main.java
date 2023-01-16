package Queue;

public class Main {
    public static void main(String[] args) {
        QueueArr<Integer> queueArr= new QueueArr<>(5);
        queueArr.enQueue(20);
        queueArr.enQueue(30);
        queueArr.enQueue(40);
        int ele=queueArr.deQueue();
        queueArr.enQueue(13);
        queueArr.enQueue(45);
        queueArr.deQueue();
        queueArr.enQueue(123);
        queueArr.enQueue(125);

        System.out.println("Size of array: "+ queueArr.queueSize);

        queueArr.isFull();
        System.out.println("Queue Top: "+queueArr.queueTop());
        System.out.println("Queue Bottom: "+ queueArr.queueBottom());
    }
}