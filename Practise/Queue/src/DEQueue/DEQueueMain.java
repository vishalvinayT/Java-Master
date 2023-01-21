package DEQueue;

public class DEQueueMain {

    public static void main(String[] args){

        DEQueueArr<Integer> array= new DEQueueArr<>(6);
        array.frontEnqueue(12);
        array.frontEnqueue(13);
        array.frontEnqueue(14);
        array.frontEnqueue(16);
        array.frontEnqueue(20);
        int val=array.rearDequeue();
        val=array.rearDequeue();
        val= array.rearDequeue();
        array.rearEnqueue(99);
        array.rearEnqueue(90);
        array.rearEnqueue(123);
        val=array.frontDequeue();
        val=array.frontDequeue();

        array.traverse();

    }
}
