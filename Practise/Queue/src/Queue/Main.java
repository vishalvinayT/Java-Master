package Queue;

public class Main {
    public static void main(String[] args) {
//        QueueArr<Integer> queueArr= new QueueArr<>(5);
//        queueArr.enQueue(20);
//        queueArr.enQueue(30);
//        queueArr.enQueue(40);
//        int ele=queueArr.deQueue();
//        queueArr.enQueue(13);
//        queueArr.enQueue(45);
//        ele=queueArr.deQueue();
//        queueArr.enQueue(123);
//        queueArr.deQueue();
//        queueArr.traverse();
//        System.out.println("Size of array: "+ queueArr.queueSize);
//        queueArr.isFull();
//        System.out.println("Queue Top: "+queueArr.queueTop());
//        System.out.println("Queue Bottom: "+ queueArr.queueBottom());


        QueueLinkedList<Integer> queueTesting= new QueueLinkedList<>();
        System.out.println(queueTesting.isEmpty());
        queueTesting.enQueue(20);
        queueTesting.enQueue(45);
        queueTesting.enQueue(123);
        queueTesting.enQueue(67);
        queueTesting.enQueue(12);

        int val=queueTesting.deQueue();
        queueTesting.enQueue(33);
        queueTesting.enQueue(78);

        val=queueTesting.deQueue();

        System.out.println("Size: "+queueTesting.getQueueSize());

        queueTesting.traverse();
    }
}