import javax.swing.plaf.TableHeaderUI;

public class DeadLocks {
    public static final Object lock1=new Object();
    public static final Object lock2 =new Object();
    public static void main(String[] args){
        Thread t1=new Thread(new Thread1());
        Thread t2=new Thread(new Thread2());
        t1.start();
        t2.start();

        System.out.println("Hey DeadLock");
    }
}
 class Thread1 implements Runnable {
    public void run(){
        synchronized (DeadLocks.lock1){
            System.out.println("Entered lock 1 By "+getClass().getName());
            System.out.println("Entering lock 2....");
            synchronized (DeadLocks.lock2){
                System.out.println("entered lock 2 by "+ getClass().getName());
            }
        }
        System.out.println("Exitted from "+getClass().getName());
    }
}

class Thread2 implements Runnable{
    public void run(){
        synchronized (DeadLocks.lock1){
            System.out.println("Entered lock 1 By "+getClass().getName());
            System.out.println("Entering lock 1....");
            synchronized (DeadLocks.lock2){
                System.out.println("Entered lock 2 by "+getClass().getName());
            }
        }
        System.out.println("Exitted from "+getClass().getName());
    }
}
