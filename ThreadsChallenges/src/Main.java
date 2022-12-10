import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {

        BankAcount jointAccount=new BankAcount(123456678888888888L,1000);
        Consumer c1=new Consumer(jointAccount);
        Consumer c2=new Consumer(jointAccount);
        Thread t1=new Thread(){
            @Override
            public void run(){
                c1.printAccount();
                c1.depositamt(300);
                c1.withdrawamt(50);

            }
        };

        Thread t2=new Thread(){
            @Override
            public void run(){
                c2.printAccount();
                c2.depositamt(203.75);
                c2.withdrawamt(100);
            }
        };

        t1.start();
        t2.start();

    }
}
class Consumer extends Thread{
    public final BankAcount account;
    public Consumer(BankAcount account){
        this.account=account;
    }

    public void depositamt(double money){
            double mybal=this.account.deposit(money);
            System.out.println("Current Balance "+ mybal);
    }

    public void withdrawamt(double money){

            double mybal=this.account.withDraw(money);
            System.out.println("Current Balance "+mybal);
    }

    public long getAccount(){
        return this.account.getAccountNumber();
    }

    public void printAccount(){
        this.account.printAccountNumber();
    }


}