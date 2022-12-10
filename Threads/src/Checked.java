public class Checked implements Runnable{
    @Override
    public void run(){
        System.out.println("Hey Iam from "+getClass().getName());
    }
}
