import javax.sound.sampled.FloatControl;

public class Starvation {

    public static int counter=0;
    public static void main(String[] args){

        Thread t1=new Thread(new Worker(ThreadColor.ANSI_RED,counter),"Priority 2");
        Thread t2 =new Thread(new Worker(ThreadColor.ANSI_GREEN,counter),"Priority 10");
        Thread t3 =new Thread(new Worker(ThreadColor.ANSI_PURPLE,counter),"Priority 4");
        Thread t4 =new Thread(new Worker(ThreadColor.ANSI_CYAN,counter),"Priority 6");
        Thread t5 =new Thread(new Worker(ThreadColor.ANSI_BLUE,counter),"Priority 0");


        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
class Worker implements Runnable{
    private String color;
    public static final Object lock = new Object();
    public int counter;

    public Worker(String color,int counter){
        this.color=color;
        this.counter=counter;
    }

    @Override
    public  void run() {
        synchronized (lock){
            while(counter<=10){
                System.out.println(color+"The number is "+counter);
                counter++;
            }
        }


    }
}