public class StockItem {
    private String name;
    private double price;
    private int  reserved=0;
    private int quantity;
    public StockItem(String name, double price){
        this.name=name;
        this.price=price;
        this.quantity=0;
    }
    public StockItem(String name, double price, int quantity){
        this.name=name;
        this.price=price;
        if(quantity>0){
            this.quantity=quantity;
        }
        else{
            this.quantity=0;
        }
    }
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity-reserved;
    }

    public int reserve(int quantity){
        if(quantity>0 && quantity<=getQuantity()){
            reserved+=quantity;
            return quantity;
        }
        return 0;
    }

    public int unreserve(int quantity){
        if(quantity>0 && quantity<=reserved){
            reserved-=quantity;
            return quantity;
        }
        return 0;
    }

    public int finalzeQuantiy(int quantity){
        if(quantity<=reserved){
            reserved-=quantity;
            this.quantity-=quantity;
            return quantity;
        }
        return 0;
    }

    public void adjustStock(int quantity){
        int newQuantity=this.quantity+quantity;
        if(newQuantity>=0){
            this.quantity=newQuantity;
        }
    }


    @Override
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        else if (obj==null || this.getClass()!=obj.getClass()) {
            return false;
        }
        else{
            return this.getName().equals(((StockItem) obj).getName());
        }
    }

    @Override
    public int hashCode(){
        return this.getName().hashCode()+50;
    }

    @Override
    public String toString(){
        return this.getName()+" price: "+this.getPrice();
    }


    public int compareTo(StockItem item){
        if(this==item){
            return 0;
        }
        if(item!=null){
            return this.getName().compareTo(item.getName());
        }
        throw new NullPointerException();
    }
}
