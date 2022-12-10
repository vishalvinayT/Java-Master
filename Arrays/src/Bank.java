import java.util.ArrayList;
public class Bank {
    private String name;
    private ArrayList<Branch> branches;
    public Bank(String name){
        this.name =name;
        this.branches=new ArrayList<Branch>();
    }

    public boolean addBranch(String name){
        Branch branch=findBranch(name);
        if(branch!=null){
            return false;
        }
        branches.add(new Branch(name));
        return true;
    }
    public boolean addCustomer(String branchName, String customerName, double transaction){
        Branch branch =findBranch(branchName);
        if(branch !=null){
            branch.newCustomer(customerName,transaction);
            return true;
        }
        return false;

    }

    public boolean addCustomerTransaction(String branchName, String customerName, double transaction){
        Branch branch=findBranch(branchName);
        if(branch!=null){
            branch.addCustomerTransaction(customerName,transaction);
            return true;
        }
        return false;
    }
    private Branch findBranch(String name){
        for(int i=0;i<branches.size();i++){
            Branch branch=branches.get(i);
            if(branch.getName().equals(name)){
                return branch;
            }
        }
        return null;
    }

    public boolean listCustomers(String branchName, boolean transactions){
        Branch branch=findBranch(branchName);
        if(branch!=null){
            System.out.println("Customer details for branch "+branch.getName());
            ArrayList<Customer> customers=branch.getCustomers();
            for(int i=0;i<customers.size();i++){
                Customer customer=customers.get(i);
                System.out.println("Customer "+customer.getName()+"["+(i+1)+"]");
                if(transactions){
                    ArrayList<Double> transactions1=customer.getTransactions();
                    System.out.println("Transactions ");
                    for(int j=0;j<transactions1.size();j++){
                        double transaction=transactions1.get(j);
                        System.out.println("["+(j+1)+"]"+" Amount "+ transaction);
                    }
                }
            }
            return true;
        }
        return false;
    }

}
