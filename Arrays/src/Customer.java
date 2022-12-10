import java.util.ArrayList;
public class Customer {
    private String name;
    private ArrayList<Double> transactions;
    public Customer(String name, double transaction){
        this.name=name;
        transactions=new ArrayList<Double>();
        this.addTransaction(transaction);
    }
    public String getName(){
        return this.name;
    }
    public ArrayList<Double> getTransactions(){
        return this.transactions;
    }
    public void addTransaction(Double transaction){
        this.transactions.add(transaction);
    }
}