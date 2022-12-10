import javax.swing.plaf.TableHeaderUI;
import javax.swing.table.TableRowSorter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
//        Thread newThread=new Thread(new Checked());
//        newThread.start();
//
//        new Thread(new myclass(){
//            @Override
//            public void run(){
//                System.out.println("Hey I am from "+ getClass().getName());
//            }
//        }).start();
//        System.out.println("Hello world! I am from main thread");

        ArrayList<String> buffer=new ArrayList<>();
        Thread p=new Thread(new Producer(buffer,ThreadColor.ANSI_RED));
        p.setName("P");
        Thread c1=new Thread(new Consumer(buffer,ThreadColor.ANSI_BLUE));
        c1.setName("C1");
        Thread c2=new Thread(new Consumer(buffer,ThreadColor.ANSI_GREEN));
        c2.setName("C2");
        p.start();
        c1.start();
        c2.start();
    }
}

class myclass implements Runnable{
    @Override
    public void run(){}
}

class Producer implements Runnable{
    public ArrayList<String> buffer;
    public String color;
    public ReentrantLock lock;
    public Producer(ArrayList<String> buffer,String color){
        this.buffer=buffer;
        this.color=color;
        this.lock =new ReentrantLock();
    }
    @Override
    public void run(){
        ReentrantLock lock=new ReentrantLock();
        String[] arr={"hi","hello","new","java","learn"};

            try{
                for(String val:arr) {
                    synchronized (buffer) {
                        buffer.add(val);
                        System.out.println(color + " Added " + val + " to buffer");
                        Thread.sleep(1000);
                    }

                }

            }catch (InterruptedException e){
                e.printStackTrace();
            }
        synchronized (buffer){
            buffer.add("EOF");
        }

    }
}
class Consumer implements Runnable{
    public static final String  EOF="EOF";
    public ArrayList<String> buffer;
    public String color;
    public Consumer(ArrayList<String> buffer, String color){
        this.buffer=buffer;
        this.color=color;
    }
    @Override
    public void run(){
        while(true){
            synchronized (buffer){
                if(!buffer.isEmpty()){
                    if(buffer.get(0)==EOF){
                        System.out.println("Achieved End of file");
                        break;
                    }
                    else{
                        System.out.println("printed "+buffer.get(0)+" by: "+ Thread.currentThread().getName());
                        buffer.remove(0);
                    }
                }
            }
        }
        System.out.println("Exitted");
    }
}
