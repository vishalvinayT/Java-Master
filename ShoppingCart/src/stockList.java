import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class stockList {
    private Map<String,StockItem> Items;
    public stockList(){
        Items=new LinkedHashMap<>();
    }
    public int addStock(StockItem item){
        if(item!=null){
            StockItem stock=this.Items.get(item.getName());
            if(stock!=null){
                item.adjustStock(stock.getQuantity());
            }
            this.Items.put(item.getName(),item);
            return item.getQuantity();
        }
       return 0;
    }

    public int sellStock(String item, int quantity){
        if(item!=null){
            StockItem stock=this.Items.get(item);
            if(stock!=null){
                if(quantity>0 && quantity<=stock.getQuantity()){
                    stock.finalzeQuantiy(quantity);
                    return stock.getQuantity();
                }

            }
        }
        return 0;
    }

    public int reserveStock(String name, int quantity){
        if(name!=null && quantity>0){
            StockItem item=Items.get(name);
            if(item!=null){
                item.reserve(quantity);
                return quantity;
            }
        }
        return 0;
    }

    public int unreserveStock(String name, int quantity){
        if(name!=null && quantity>0){
            StockItem item=Items.get(name);
            if(item!=null){
                item.unreserve(quantity);
                return quantity;
            }
        }
        return 0;
    }

    public StockItem item(String name){
        return this.Items.getOrDefault(name, null);
    }

    public Map<String, StockItem> Items(){
        return Collections.unmodifiableMap(this.Items);
    }
    
    @Override
    public String toString(){
        double value=0;
        for(Map.Entry<String,StockItem> item: this.Items.entrySet()){
            System.out.println("Item name: "+item.getKey()+" item Value: "+item.getValue()+" item quantity: "+item.getValue().getQuantity()+" item price: "+item.getValue().getPrice());
            value=item.getValue().getQuantity()*item.getValue().getPrice();
        }
        return "Total Price of Quantity: "+String.format("%.2f",value);
    }

}
