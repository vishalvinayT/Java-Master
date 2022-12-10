import javax.naming.NamingSecurityException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class BankAcount{
    private long accountNumber;
    private double balance;
    public ReentrantLock lock;
    public BankAcount(long accountNumber, double balance ){
        this.accountNumber=(long) accountNumber;
        if(balance>=0){
            this.balance =balance;
        }
        else{
            System.out.println("Wrong balance");
        }

        this.lock=new ReentrantLock();

    }

    public double deposit(double amount){
        boolean status=false;
        try {
            if(lock.tryLock(1000,TimeUnit.MILLISECONDS) && !status){
                status=true;
                try{
                    if(amount>0){
                        this.balance+=amount;
                    }
                    else{
                        System.out.println("Wrong amount");
                    }
                    return this.balance;
                }finally {
                    lock.unlock();
                }
            }else System.out.println("Could Not get the lcok");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Current Status "+status);
        return this.balance;
    }

    public double withDraw(double amount){
        boolean status=false;
        try {
            if (lock.tryLock(100, TimeUnit.MILLISECONDS) && !status) {
                status=true;
                try {

                    if (amount > 0 && amount <= this.balance) {
                        this.balance -= amount;
                    } else {
                        System.out.println("Wrong amount");
                    }
                    return this.balance;
                } finally {
                    lock.unlock();
                }
            }
        }
        catch (InterruptedException e) {
                System.out.println("Coundnot get the lock");
                throw new RuntimeException();

        }
        System.out.println("Current Status :"+status);
        return this.balance;
    }

    public long getAccountNumber(){
        return this.accountNumber;
    }

    public void printAccountNumber(){
        System.out.println("Account Number "+ this.accountNumber);
    }

}
